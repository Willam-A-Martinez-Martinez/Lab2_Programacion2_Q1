/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2_programacion2q2;
import java.util.Calendar;
/**
 *
 * @author Mario
 */
public class EmpleadoTemporal extends Empleado {
    private Calendar fechafinContrato;

    public EmpleadoTemporal(Calendar fechafinContrato, int codigo, String nombre, double salarioBase, int horasTrabajadas) {
        super(codigo, nombre, salarioBase, horasTrabajadas);
        this.fechafinContrato = fechafinContrato;
    }
    
    public Calendar getfechafinContrato(){
        return fechafinContrato;
    }
    
    public void setfechafinContrato(Calendar fechafinContrato){
        this.fechafinContrato = fechafinContrato;
    }
    
    public double calcularPago() {
        Calendar fechaActual = Calendar.getInstance();
        if (fechaActual.before(fechafinContrato) || fechaActual.equals(fechafinContrato)) {
            return (super.salarioBase / 160) * super.horasTrabajadas;
        }
        return 0.1;
    }
    public String mostrarInformacion(){
        return super.mostrarInformacion() + " Fin del contrato " + fechafinContrato.getTime();
    }
}
