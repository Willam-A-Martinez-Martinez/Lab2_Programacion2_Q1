package lab2_programacion2q2;

import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.*; 

public class EmpleadoVentas extends Empleado {
    private ArrayList<Double> ventasMensuales;
    private double comision;

    public EmpleadoVentas(int codigo, String nombre, double salarioBase, int horasTrabajadas, double comision) {
        super(codigo, nombre, salarioBase, horasTrabajadas);
        this.ventasMensuales = new ArrayList<>(12); 
        this.comision = comision;

        for (int i = 0; i < 12; i++) {
            ventasMensuales.add(0.0);
        }
    }

   
    public void registrarVentas(int mes, double monto) {
        if (mes >= 1 && mes <= 12) {
            ventasMensuales.set(mes - 1, ventasMensuales.get(mes - 1) + monto);
        } else {
            JOptionPane.showMessageDialog(null,"Mes inválido. Debe estar entre 1 y 12.");
        }
    }

    public double calculoComision(int mes) {
        if (mes >= 1 && mes <= 12) {
            return ventasMensuales.get(mes - 1) * (comision / 100);
        } else {
            return 0;
        }
    }

    public double calculoPagoMensual(int mes) {
        double salarioPro = calculoPago(horasTrabajadas);
        double comisionMes = calculoComision(mes);
        return salarioPro + comisionMes;
    }

    public double calculoVentasAnuales() {
        double totalVentas = 0;
        for (double venta : ventasMensuales) {
            totalVentas += venta;
        }
        return totalVentas;
    }

    @Override
    public String mostrarInformacion() {
        double ventasAnuales = calculoVentasAnuales();
        return super.mostrarInformacion() + "\nVentas anuales: " + ventasAnuales;
    }
}
