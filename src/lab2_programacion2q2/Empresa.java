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
       
      public void actualizarFechaFinContrato(int codigo, Calendar nuevaFecha) {
        for (Empleado e : empleados) {
            if (e.getCodigo() == codigo && e instanceof EmpleadoTemporal) {
                ((EmpleadoTemporal) e).setfechafinContrato(nuevaFecha);
                System.out.println("Fecha de fin de contrato actualizada para el empleado " + codigo);
                return;
            }
        }
       JOptionPane.showMessageDialog(null,"Error: No se encontro un empleado temporal con ese codigo.");
    }
    
    public double calcularPagoMensual(int codigo, int mes) {
        for (Empleado e : empleados) {
            if (e.getCodigo() == codigo) {
                if (e instanceof EmpleadoTemporal) {
                    return ((EmpleadoTemporal) e).calcularPago();
                } else if (e instanceof EmpleadoVentas) {
                    return ((EmpleadoVentas) e).calculoPagoMensual(mes);
                } else {
                    return e.calculoPago(e.getHorasTrabajadas());
                }
            }
        }
      JOptionPane.showMessageDialog(null,"Error: No se encontro un empleado con ese codigo.");
        return 0.0;
    }
    
    public void generarReporteEmpleados() {
        int estandar = 0, temporal = 0, ventas = 0;
        for (Empleado e : empleados) {
            if (e instanceof EmpleadoTemporal) {
                temporal++;
            } else if (e instanceof EmpleadoVentas) {
                ventas++;
            } else {
                estandar++;
            }
            System.out.println(e.mostrarInformacion());
        }
       JOptionPane.showMessageDialog(null,"\nResumen de empleados:");
       JOptionPane.showMessageDialog(null,"Empleados estandar: " + estandar);
       JOptionPane.showMessageDialog(null,"Empleados temporales: " + temporal);
       JOptionPane.showMessageDialog(null,"Empleados de ventas: " + ventas);
    }
    
    public Empleado buscarEmpleadoPorCodigo(int codigo) {
        for (Empleado e : empleados) {
            if (e.getCodigo() == codigo) {
                return e;
            }
        }
        JOptionPane.showMessageDialog(null,"Error: No se encontro un empleado con ese codigo.");
        return null;
    }
}
