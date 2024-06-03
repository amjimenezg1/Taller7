package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelMenu extends JPanel implements ActionListener {
	
	private static final String[] menu_nombres = {"NUEVO", "REINICIAR", "TOP-10", "CAMBIAR JUGADOR"};
	private VentanaLightsOut padre;
	private Color colorPanel;
	private Color colorGris;
	
	public PanelMenu (VentanaLightsOut papa) {
		
		//Panel color azulito
		colorPanel = new Color (72,132,220);
		setBackground(colorPanel);
		
		//Fondo color gris lindo clarito :3
		colorGris = new Color (242,242,242);
		
		this.padre = papa;
		
		//Arreglo de mis botones que son 4 :)
		JButton [] misBotones = new JButton [4];
		
		//Aqui los botones van uno por uno en grillita
        GridLayout gridLayout = new GridLayout(4, 1); // 4 filas, 1 columna
        gridLayout.setHgap(30); // Espacio horizontal entre componentes
        gridLayout.setVgap(30); //Espacio vertical entre componentes
        setLayout(gridLayout);
		
		//Creo botones
		for(int cont=0; cont < 4; cont++) {
			
			//Boton por boton
			misBotones[cont] = new JButton(menu_nombres[cont]);
			misBotones[cont].setForeground(Color.white);
			misBotones[cont].setFont(new Font("Arial", Font.BOLD, 15));
			misBotones[cont].setBackground(colorPanel);

			add(misBotones[cont]);
		}
		
		//Ahora voy a asignar los ActionListeners
		misBotones[0].setActionCommand("NUEVO");
		misBotones[0].addActionListener(this);
		
		misBotones[1].setActionCommand("REINICIAR");
		misBotones[1].addActionListener(this);
		
		misBotones[2].setActionCommand("TOP");
		misBotones[2].addActionListener(this);
		
		misBotones[3].setActionCommand("CAMBIAR");
		misBotones[3].addActionListener(this);
		
		//Fondo gris
		setBackground(colorGris);
		
	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Veo grito y miro que hacer
		String grito = e.getActionCommand();

		if(grito.equals("NUEVO")) {
			padre.juegoNuevo();
		}
		else if(grito.equals("REINICIAR")) {
			padre.reiniciar();
		}
		else if(grito.equals("TOP")){
			padre.top10();
			}
		else if(grito.equals("CAMBIAR")){
			padre.cambiarDeJugador();
			}
		
		
		}
	
}
