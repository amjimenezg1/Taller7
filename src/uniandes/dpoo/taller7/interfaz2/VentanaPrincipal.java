package uniandes.dpoo.taller7.interfaz2;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaPrincipal extends JFrame{
    public static void main(String[] args) {
        // Crear un nuevo marco
        JFrame frame = new JFrame("Ventana Principal");

        // Configurar el tamaño del marco
        frame.setSize(700, 500);

        // Configurar la operación de cierre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hacer visible el marco
        frame.setVisible(true);
    }
}