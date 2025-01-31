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

    public void registrarEmpleado() {
        try {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del empleado:"));
            for (Empleado e : empleados) {
                if (e.getCodigo() == codigo) {
                    JOptionPane.showMessageDialog(null, "Error: El codigo de empleado ya esta registrado.");
                    return;
                }
            }

            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado:");
            double salarioBase = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario base del empleado:"));
            int horasTrabajadas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las horas trabajadas del empleado:"));

            if (horasTrabajadas < 0) {
                JOptionPane.showMessageDialog(null, "Error: Las horas trabajadas no pueden ser negativas.");
                return;
            }

            String tipoEmpleado;
            do {
                tipoEmpleado = JOptionPane.showInputDialog("Ingrese el tipo de empleado (Estandar/Temporal/Ventas):");
            } while (!tipoEmpleado.equalsIgnoreCase("Estandar") && !tipoEmpleado.equalsIgnoreCase("Temporal") && !tipoEmpleado.equalsIgnoreCase("Ventas"));

            Empleado empleado;
            if (tipoEmpleado.equalsIgnoreCase("Temporal")) {
                Calendar fechaFinContrato = Calendar.getInstance();
                int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de fin de contrato:"));
                int mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes de fin de contrato (1-12):")) - 1;
                int dia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dia de fin de contrato:"));
                fechaFinContrato.set(anio, mes, dia);
                if (fechaFinContrato.before(Calendar.getInstance())) {
                    JOptionPane.showMessageDialog(null, "Error: La fecha de fin de contrato no puede ser anterior a la fecha actual.");
                    return;
                }
                empleado = new EmpleadoTemporal(fechaFinContrato, codigo, nombre, salarioBase, horasTrabajadas);
            } else if (tipoEmpleado.equalsIgnoreCase("Ventas")) {
                double comision = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la comision del empleado (porcentaje):"));
                if (comision < 0) {
                    JOptionPane.showMessageDialog(null, "Error: La comision no puede ser negativa.");
                    return;
                }
                empleado = new EmpleadoVentas(codigo, nombre, salarioBase, horasTrabajadas, comision);
            } else {
                empleado = new Empleado(codigo, nombre, salarioBase, horasTrabajadas);
            }

            empleados.add(empleado);
            JOptionPane.showMessageDialog(null, "Empleado registrado correctamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Ingreso de datos invalido. Asegurese de ingresar valores numericos correctos.");
        }

    }

    public void registrarHoras(int codigo, int horas) {
        if (horas < 0) {
            JOptionPane.showMessageDialog(null, "Error: Las horas trabajadas no pueden ser negativas.");
            return;
        }
        for (Empleado e : empleados) {
            if (e.getCodigo() == codigo) {
                e.registrarHoras(horas);
                JOptionPane.showMessageDialog(null, "Horas registradas correctamente para el empleado " + codigo);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Error: No se encontro un empleado con ese codigo.");
    }

    public void registrarVentas(int codigo, int mes, double monto) {
        if (mes < 1 || mes > 12) {
            JOptionPane.showMessageDialog(null, "Error: El mes ingresado no es valido. Debe estar entre 1 y 12.");
            return;
        }
        if (monto < 0) {
            JOptionPane.showMessageDialog(null, "Error: El monto de venta no puede ser negativo.");
            return;
        }
        for (Empleado e : empleados) {
            if (e.getCodigo() == codigo && e instanceof EmpleadoVentas) {
                ((EmpleadoVentas) e).registrarVentas(mes, monto);
                JOptionPane.showMessageDialog(null, "Venta registrada correctamente para el empleado " + codigo + " en el mes " + mes);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Error: No se encontro un empleado de ventas con ese codigo.");
    }

    public void actualizarFechaFinContrato(int codigo, Calendar nuevaFecha) {
        for (Empleado e : empleados) {
            if (e.getCodigo() == codigo && e instanceof EmpleadoTemporal) {
                ((EmpleadoTemporal) e).setfechafinContrato(nuevaFecha);
                System.out.println("Fecha de fin de contrato actualizada para el empleado " + codigo);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Error: No se encontro un empleado temporal con ese codigo.");
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
        JOptionPane.showMessageDialog(null, "Error: No se encontro un empleado con ese codigo.");
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
        JOptionPane.showMessageDialog(null, "\nResumen de empleados:");
        JOptionPane.showMessageDialog(null, "Empleados estandar: " + estandar);
        JOptionPane.showMessageDialog(null, "Empleados temporales: " + temporal);
        JOptionPane.showMessageDialog(null, "Empleados de ventas: " + ventas);
    }

    public Empleado buscarEmpleadoPorCodigo(int codigo) {
        for (Empleado e : empleados) {
            if (e.getCodigo() == codigo) {
                return e;
            }
        }
        JOptionPane.showMessageDialog(null, "Error: No se encontro un empleado con ese codigo.");
        return null;
    }
}
