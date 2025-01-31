package lab2_programacion2q2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;



public class Interfaz_grafica {
    JFrame frame = new JFrame();
    JLabel titulo = new JLabel();
//    JLabel backgroundForWords = new JLabel();
//    JLabel background = new JLabel();
    JButton registrarEmpleados = new JButton();
    JButton registrarHoras = new JButton();
    JButton registrarVentas = new JButton();
    JButton actualizarFechaFinContrato = new JButton();
    JButton calcularPagoMensual = new JButton();
    JButton generarReportes = new JButton();
    JButton buscarEmpleadosCodigo = new JButton();
    JButton salir = new JButton();
    //botones necesario Registrar empleado, registrar horas trabajas, registrar ventas, 
    //actualizar fecha de fin de contrato, calcular pago mensual, generarReportes de empleados y buscar empleados por codigo
    public Interfaz_grafica(){
        frame.setLayout(null);
        
        frame.setSize(1300, 1000);
        frame.setLocationRelativeTo(null);
        
        
        
        titulo.setBounds(600, 25, 200, 50);

        registrarEmpleados.setBounds(500, 100, 200, 50);//registrarEmpleados registrarHoras registrarVentas actualizarFechaFinContrato calcularPagoMensual generarReportes buscarEmpleadosCodigo salir
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
        buscarEmpleadosCodigo.setText("Buscar Empleado por Código");
        salir.setText("Salir");
        
        titulo.setText("Segmented & corp");
        
        frame.add(titulo);
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
        
        
    }
    
    public static void main(String[] args) {
        new Interfaz_grafica();
    }
}
