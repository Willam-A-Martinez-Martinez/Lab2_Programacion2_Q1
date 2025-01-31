package lab2_programacion2q2;

import java.awt.event.ActionEvent;

import java.util.Calendar;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Interfaz_grafica {
    JFrame frame = new JFrame();
    JButton registrarEmpleados = new JButton();
    JButton registrarHoras = new JButton();
    JButton registrarVentas = new JButton();
    JButton actualizarFechaFinContrato = new JButton();
    JButton calcularPagoMensual = new JButton();
    JButton generarReportes = new JButton();
    JButton buscarEmpleadosCodigo = new JButton();
    JButton salir = new JButton();
    
    Empresa emp = new Empresa();
    
    public boolean esNumero(String str) {
        return str.matches("\\d+");
    }
    
    public Interfaz_grafica(){
        frame.setLayout(null);
        frame.setSize(1300, 1000);
        frame.setLocationRelativeTo(null);
        
        registrarEmpleados.setBounds(500, 100, 200, 50);
        registrarHoras.setBounds(500, 200, 200, 50);
        registrarVentas.setBounds(500, 250, 200, 50);
        actualizarFechaFinContrato.setBounds(500, 325, 200, 50);
        calcularPagoMensual.setBounds(500, 400, 200, 50);
        generarReportes.setBounds(500, 475, 200, 50);
        buscarEmpleadosCodigo.setBounds(500, 525, 200, 50);
        salir.setBounds(500, 600, 200, 50);
        
        registrarEmpleados.setText("Registrar Empleados");
        registrarHoras.setText("Registrar Horas");
        registrarVentas.setText("Registrar Ventas");
        actualizarFechaFinContrato.setText("Actualizar Fecha de Contrato");
        calcularPagoMensual.setText("Calcular Pago Mensual");
        generarReportes.setText("Generar Reportes");
        buscarEmpleadosCodigo.setText("Buscar Empleado por Codigo");
        salir.setText("Salir");
        
        frame.add(registrarEmpleados);
        frame.add(registrarHoras);
        frame.add(registrarVentas);
        frame.add(actualizarFechaFinContrato);
        frame.add(calcularPagoMensual);
        frame.add(generarReportes);
        frame.add(buscarEmpleadosCodigo);
        frame.add(salir);
        
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        registrarEmpleados.addActionListener((ActionEvent e) -> emp.registrarEmpleado());

        registrarHoras.addActionListener((ActionEvent e) -> {
            String codigo = JOptionPane.showInputDialog("Ingrese el codigo del empleado: ");
            while (!esNumero(codigo)) {
                codigo = JOptionPane.showInputDialog("Codigo invalido! Ingrese nuevamente: ");
            }
            int horas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las horas trabajadas: "));
            emp.registrarHoras(Integer.parseInt(codigo), horas);
        });

        registrarVentas.addActionListener((ActionEvent e) -> {
            String codigo = JOptionPane.showInputDialog("Ingrese el codigo del empleado: ");
            while (!esNumero(codigo)) {
                codigo = JOptionPane.showInputDialog("Codigo invalido! Ingrese nuevamente: ");
            }
            int mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes de la venta (1-12): "));
            double monto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto de la venta: "));
            emp.registrarVentas(Integer.parseInt(codigo), mes, monto);
        });

        actualizarFechaFinContrato.addActionListener((ActionEvent e) -> {
            String codigo = JOptionPane.showInputDialog("Ingrese el codigo del empleado: ");
            while (!esNumero(codigo)) {
                codigo = JOptionPane.showInputDialog("Codigo invalido! Ingrese nuevamente: ");
            }
            int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de fin de contrato: "));
            int mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes de fin de contrato (1-12): ")) - 1;
            int dia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dia de fin de contrato: "));
            Calendar fechaNueva = Calendar.getInstance();
            fechaNueva.set(anio, mes, dia);
            emp.actualizarFechaFinContrato(Integer.parseInt(codigo), fechaNueva);
        });

        calcularPagoMensual.addActionListener((ActionEvent e) -> {
            String codigo = JOptionPane.showInputDialog("Ingrese el codigo del empleado: ");
            while (!esNumero(codigo)) {
                codigo = JOptionPane.showInputDialog("Codigo invalido! Ingrese nuevamente: ");
            }
            int mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes para calcular el pago (1-12): "));
            double pago = emp.calcularPagoMensual(Integer.parseInt(codigo), mes);
            JOptionPane.showMessageDialog(null, "El pago mensual es: " + pago);
        });

        generarReportes.addActionListener((ActionEvent e) -> emp.generarReporteEmpleados());

        buscarEmpleadosCodigo.addActionListener((ActionEvent e) -> {
            String codigo = JOptionPane.showInputDialog("Ingrese el codigo del empleado: ");
            while (!esNumero(codigo)) {
                codigo = JOptionPane.showInputDialog("Codigo invalido! Ingrese nuevamente: ");
            }
            Empleado empleado = emp.buscarEmpleadoPorCodigo(Integer.parseInt(codigo));
            if (empleado != null) {
                JOptionPane.showMessageDialog(null, empleado.mostrarInformacion());
            }
        });

        salir.addActionListener((ActionEvent e) -> System.exit(0));
    }
    
    public static void main(String[] args) {
        new Interfaz_grafica();
    }
}
