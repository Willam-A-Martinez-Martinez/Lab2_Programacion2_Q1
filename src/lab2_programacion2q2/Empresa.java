/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2_programacion2q2;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
/**
 *
 * @author DELL
 */
public class Empresa {

    private ArrayList<Empleado> empleados;

    public Empresa() {
        this.empleados = new ArrayList<>();
    }

    public void registrarEmpleado(Empleado empleado) {
        for (Empleado e : empleados) {
            if (e.getCodigo() == empleado.getCodigo()) {
                System.out.println("El codigo de empleado ya esta registrado.");
                return;
            }
        }
        empleados.add(empleado);
        System.out.println("Empleado registrado correctamente");
    }
       public void registrarHoras(int codigo, int horas) {
        for (Empleado e : empleados) {
            if (e.getCodigo() == codigo) {
                e.registrarHoras(horas);
                System.out.println("Horas registradas correctamente para el empleado " + codigo);
                return;
            }
        }
        System.out.println("No se encontro un empleado con ese codigo");
    }
        public void registrarVentas(int codigo, int mes, double monto) {
        for (Empleado e : empleados) {
            if (e.getCodigo() == codigo && e instanceof EmpleadoVentas) {
                ((EmpleadoVentas) e).registrarVentas(mes, monto);
                System.out.println("Venta registrada correctamente para el empleado " + codigo + " en el mes " + mes);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, " No se encontro un empleado de ventas con ese codigo");
    }
       
}
