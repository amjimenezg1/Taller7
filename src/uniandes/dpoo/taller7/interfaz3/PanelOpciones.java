package uniandes.dpoo.taller7.interfaz3;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelOpciones extends JFrame {
    public PanelOpciones() {
        // Configurar el tamaño del marco
        setSize(800, 600);

        // Configurar la operación de cierre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear paneles
        JPanel panelSuperior = new PanelSuperior();
        JPanel panelDerecha = new PanelDerecha();
        JPanel panelInferior = new PanelInferior();

        // Configurar el diseño de la ventana principal
        setLayout(new BorderLayout());

        // Agregar paneles a la ventana principal
        add(panelSuperior, BorderLayout.NORTH);
        add(panelDerecha, BorderLayout.EAST);
        add(panelInferior, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        // Crear una instancia de la ventana principal
    	PanelOpciones ventana = new PanelOpciones();

        // Hacer visible la ventana principal
        ventana.setVisible(true);
    }
}

class PanelSuperior extends JPanel {
    public PanelSuperior() {
        // Configurar el diseño del panel superior
        setLayout(new FlowLayout());

        // Crear componentes
        JLabel label = new JLabel("Tamaño:");
        JComboBox<String> comboBox = new JComboBox<>(new String[]{"5X5", "7x7", "10x10"});
        JRadioButton radioButton1 = new JRadioButton("Fácil");
        JRadioButton radioButton2 = new JRadioButton("Medio");
        JRadioButton radioButton3 = new JRadioButton("Dificil");

        // Agrupar los botones de radio
        ButtonGroup grupoRadio = new ButtonGroup();
        grupoRadio.add(radioButton1);
        grupoRadio.add(radioButton2);
        grupoRadio.add(radioButton3);

        // Agregar componentes al panel
        add(label);
        add(comboBox);
        add(radioButton1);
        add(radioButton2);
        add(radioButton3);
    }
}

class PanelDerecha extends JPanel {
    public PanelDerecha() {
        // Configurar el diseño del panel de la derecha
        setLayout(new GridLayout(0, 1));

        // Crear botones
        JButton button1 = new JButton("Nuevo");
        JButton button2 = new JButton("Reiniciar");
        JButton button3 = new JButton("Top - 10");
        JButton button4 = new JButton("Cambiar Jugador");
        

        // Agregar botones al panel
        add(button1);
        add(button2);
        add(button3);
        add(button4);
    }
}

class PanelInferior extends JPanel {
    private int contador = 0;
    private JLabel contadorLabel;

    public PanelInferior() {
        // Configurar el diseño del panel inferior
        setLayout(new FlowLayout());

        // Crear componentes
        JLabel label = new JLabel("Jugador:");
        JTextField textField = new JTextField(20);
        JButton jugarButton = new JButton("..");
        contadorLabel = new JLabel("Jugadas:" + contador);

        // Agregar listener al botón de jugar
        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Incrementar el contador y actualizar la etiqueta
                contador++;
                contadorLabel.setText("Jugadas: " + contador);
            }
        });

        // Agregar componentes al panel
        add(label);
        add(textField);
        add(jugarButton);
        add(contadorLabel);
    }

    public int getContador() {
        return contador;
    }
}