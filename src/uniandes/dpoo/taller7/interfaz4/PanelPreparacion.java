package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class PanelPreparacion extends JPanel {

	private JComboBox<String> comboBox;
	private ButtonGroup grupoDificultad;
	private Color colorPanel;
	private JLabel tamanoL;
	private JLabel dificultadL;
	private int enteroDificultad;

	public PanelPreparacion() {
		
		//Panel color azulito
		colorPanel = new Color (72,132,220);
		setBackground(colorPanel);

		//Label de tamaño
		tamanoL = new JLabel("Tamaño:");
		tamanoL.setForeground(Color.WHITE);
		tamanoL.setFont(new Font("Arial", Font.BOLD, 15));
		//Añado pa que se vea
		add(tamanoL);

		//Opciones desplegadas con un JComboBox
		comboBox = new JComboBox<String>();
		//Hace que los elementos "5x5", "6x6", "7x7", "8x8", "9x9" sean los elementos disponibles para seleccionar en el JComboBox
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "5x5", "7x7", "10x10"}));
		//Esto lo uso mas tarde
		comboBox.setSelectedIndex(0);
		add(comboBox);

		//Label de dificultad
		JLabel dificultadL = new JLabel("Dificultad:");
		dificultadL.setForeground(Color.WHITE);

		dificultadL.setFont(new Font("Arial", Font.BOLD, 15));
		add(dificultadL);
		
		//Solo una opcion -> creo grupo
		grupoDificultad = new ButtonGroup();

		String[] niveles = { "Facil", "Medio", "Dificil"};
		JRadioButton[] groupedRadioButtons = new JRadioButton[niveles.length];
		for (int i = 0; i < niveles.length; i++) {
			//Nuevo boton
			groupedRadioButtons[i] = new JRadioButton(niveles[i]);
			groupedRadioButtons[i].setBackground(colorPanel);
			groupedRadioButtons[i].setForeground(Color.WHITE);
			groupedRadioButtons[i].setFont(new Font("Arial", Font.BOLD, 15));
			//Añado a grupoDificultad
			grupoDificultad.add(groupedRadioButtons[i]);
			add(groupedRadioButtons[i]);
		}
		
		//Dale el nombre de la dificultad al action command
		 //Le doy nombre de la dificultad a facil, medio, dificil
		groupedRadioButtons[0].setActionCommand("facil");
		groupedRadioButtons[1].setActionCommand("medio");
		groupedRadioButtons[2].setActionCommand("dificil");
		
		//Facil seleccionado por defecto
		groupedRadioButtons[0].setSelected(true);

	}

	public int getTamanioTablero() {
		//Hago la generacion del tamaño en función del indice de seleccion
		//Si elige 0 + 5 = 5x5
		return comboBox.getSelectedIndex() + 5;
	}


	public int getDificultad() {
		//El grito me ayuda
		String grito = grupoDificultad.getSelection().getActionCommand();
			
		//Numero que retorno es la cantidad de movimientos pa desordenar el tablero
		if(grito.equals("facil")) {
			enteroDificultad = 30;
		}
				
		else if(grito.equals("medio")) {
			enteroDificultad = 15;
		}
				
		else if(grito.equals("dificil")) {
			enteroDificultad = 8;
		}
				
		return enteroDificultad;
	}

}
