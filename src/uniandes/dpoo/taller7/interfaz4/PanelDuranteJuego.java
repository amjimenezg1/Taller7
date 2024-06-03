package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class PanelDuranteJuego extends JPanel {

	private JLabel[] valores;
	private String nombreJugador;
	//Empieza en 0 movimientos
	private int movimientos = 0;
	private Color colorGris;

	public PanelDuranteJuego(String nombreJugador) {
		this.nombreJugador = nombreJugador;
		setLayout(new GridLayout(1, 2, 1, 2));
		
		//Fondo color gris lindo clarito :3
		colorGris = new Color (242,242,242);
				
		setBackground(colorGris);
		setLayout(new GridLayout(1, 2, 1, 2));

		//Arreglo de mis etiquetas
		JLabel[] misEtiquetas = new JLabel[2];
		String[] nombreEtiquetas = { "Jugadas: ", "Jugador: " };
		
		valores = new JLabel[2];
		String[] nombreValores = new String[] { "" + movimientos, nombreJugador };

		//Hago etiquetas
		for (int i = 0; i < 2; i++) {
			//Voy con las etiquetas que hacen de llave
			misEtiquetas[i] = new JLabel(nombreEtiquetas[i]);
			misEtiquetas[i].setForeground(Color.BLACK);
			misEtiquetas[i].setFont(new Font("Arial", Font.PLAIN, 15));
			
			//Voy con las etiquetas que hacen de valores
			valores[i] = new JLabel(nombreValores[i]);
			valores[i].setForeground(Color.BLACK);
			valores[i].setFont(new Font("Arial", Font.PLAIN, 15));
			
			//Añado todas las etiquetas
			add(misEtiquetas[i]);
			add(valores[i]);
		}
	}

	public void setJugadas(int i) {
		movimientos = i;
		valores[0].setText("" + i);
	}

	public void setJugador(String nombreJug) {
		valores[1].setText(nombreJug);
	}

	public int getJugadas() {
		return movimientos;
	}
}

