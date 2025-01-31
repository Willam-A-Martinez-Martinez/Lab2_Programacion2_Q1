package lab2_programacion2q2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



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
        frame.setLocationRelativeTo(null);
        frame.setSize(1300, 1000);
        
        frame.add(titulo);
        frame.add();
        frame.add();
        frame.add();
        frame.add();
        frame.add();
        frame.add();
        frame.add();
        frame.add();
        
    }
}
