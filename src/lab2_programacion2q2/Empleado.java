/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2_programacion2q2;

import java.util.Calendar;

/*
* Métodos Clave:

* Registrar horas trabajadas: Permite actualizar el total de horas trabajadas por el empleado en el mes actual.

* Cálculo de pago: Calcula el salario proporcional según las horas trabajadas, tomando un mes estándar de 160 horas como base.
* Para empleados estándar, se aplica una deducción fija del 3.5%.

* Mostrar información: Devuelve una cadena que incluye el código, el nombre y la fecha de contratación del empleado.
 */


public class Empleado {
    /**
 * Propósito: Representar la base común para todos los empleados de la empresa, gestionando atributos generales y comportamientos comunes.
Atributos:

* Código único: Identifica de manera exclusiva a cada empleado.

* Nombre: El nombre completo del empleado.

* Fecha de contratación: Fecha en que el empleado ingresó a la empresa (se inicializa con la fecha actual). usar Calendar investigar.

* Salario base: Representa la remuneración mensual estándar del empleado.

* Horas trabajadas: Total de horas registradas por el empleado en el mes.
*/
    int codigo;
    String nombre, fechaContratacion;
    double salarioBase;
    int horasTrabajadas;

    public Empleado(int codigo, String nombre, double salarioBase, int horasTrabajadas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        this.horasTrabajadas = horasTrabajadas;
        fechaContratacion=String.valueOf(Calendar.getInstance());
    }
    
    public void registrarHoras(int horas){
        horasTrabajadas+=horas;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }
    
    
    
    //Cálculo de pago: Calcula el salario proporcional según las horas trabajadas, tomando un mes estándar de 160 horas como base.
    //Para empleados estándar, se aplica una deducción fija del 3.5%.
    public double calculoPago(int horas){
        return (horas/160)*salarioBase-(((horas/160)*salarioBase)*0.35);
    }    
    
//    Mostrar información: Devuelve una cadena que incluye el código, el nombre y la fecha de contratación del empleado.
    public String mostrarInformacion(){
        return "Nombre del empleado: "+nombre+"\nCodigo del empleado: "+codigo+"\nFecha de contratacion: "+fechaContratacion;
    }
}
