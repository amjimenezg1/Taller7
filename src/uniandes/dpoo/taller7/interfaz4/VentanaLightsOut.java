package uniandes.dpoo.taller7.interfaz4;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import uniandes.dpoo.taller7.modelo.RegistroTop10;
import uniandes.dpoo.taller7.modelo.Tablero;
import uniandes.dpoo.taller7.modelo.Top10;

public class VentanaLightsOut extends JFrame {

	private static final File data = new File("data/top10.csv");
		
	private JPanel todoPanel;
	private Tablero tableroLogica;
	private JPanel contenedorPanel;
	private Top10 top10;
	private String nombreJugador;
	private PanelTablero panelTablero;
	private PanelDuranteJuego panelDuranteJuego;
	private PanelMenu panelMenu;
	private PanelPreparacion panelPreparacion;
	
	//Método constructor
	public VentanaLightsOut() {
		
		//Doy titulo de la ventana
		setTitle("LightsOut");
		
		//Cargo el top10
		this.top10 = new Top10(); //Esta es de las que nos dan
		top10.cargarRecords(data); //Cargas los datos que tienes guardados del top 10
		
		//Quiero un panel grande con MINIpaneles
		todoPanel = new JPanel();
		todoPanel.setBackground(Color.white);
		todoPanel.setLayout(new BorderLayout());
		//Margen de la venta
		todoPanel.setBorder(new EmptyBorder(12,12,12,12));
	
		//Agrega el panel que acabo de crear a la ventana
		setContentPane(todoPanel);
		
		//Aca voy a crear el panel Preparacion Juego!
		panelPreparacion = new PanelPreparacion();
		todoPanel.add(panelPreparacion, BorderLayout.NORTH);
		
		//Ahora todo lo que va debajo de preparar el juego en otro panelcito

		contenedorPanel = new JPanel();
		
		contenedorPanel.setBackground(Color.white);
		todoPanel.add(contenedorPanel, BorderLayout.EAST);
		//Ahora quiero que mis botones del menu se puedan centrar entonces otro layout!
		contenedorPanel.setLayout(new BorderLayout());
		
		
		panelMenu = new PanelMenu(this);
		contenedorPanel.add(panelMenu, BorderLayout.CENTER);
		
		//Vamos con el panelDurantePartida
		
		//Creo la cuadricula que lleva el nombre y las jugadas
		
	
		//Veo si el nombre esta bien o no
			if (nombreJugador == null || nombreJugador.isBlank()) {
					  this.nombreJugador  = "Tay";
			}
			else {
				this.nombreJugador = nombreJugador;
			}
		
		//Ahora panel durante juego pero ya tengo el nombre
		panelDuranteJuego = new PanelDuranteJuego(nombreJugador);
		todoPanel.add(panelDuranteJuego, BorderLayout.SOUTH);
		
		
		//Me voy con la grilla del tablero
		panelTablero = new PanelTablero(this, 1);
		todoPanel.add(panelTablero, BorderLayout.CENTER);
		
		//Cambiar cosas top 10 al cerrar
		// Esto se usa para que al cerrar la ventana se salven los resultados
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				try {
					top10.salvarRecords(data);
				}catch (Exception e) {}
			}
		});
		
		//Ajusta tamaño ventana mejor
		pack();
		//Centrar ventana en pantalla
		setLocationRelativeTo(null);
		
		//Aplicación debe cerrar en su ejecución
		setDefaultCloseOperation(EXIT_ON_CLOSE);
				
		//Hace que la ventana aparezca
		setVisible(true);
	}
	
	private String getNombreUsuario() {
		
		//Primero hay que pedir el nombre del jugador y eso puede ser en un aviso aparte al iniciar
		nombreJugador = JOptionPane.showInputDialog(null, "Por favor escriba su nombre", "LightsOut", JOptionPane.PLAIN_MESSAGE);
		
		//Si no está le pongo tay por taylor swift
		if (nombreJugador == null || nombreJugador.isBlank()) {
			  this.nombreJugador  = "Tay";
		}
		else {
			this.nombreJugador = nombreJugador;
		}
		
		return nombreJugador;
	}
	
	public boolean estaEncendida(int i, int j) {
		
		if (panelTablero.getCantidadCuadrados() == 1)
			return true;
		return tableroLogica.darTablero()[i][j];
	}
	
	public void juegoNuevo() {
		
		//Aca sacas la infromacion necesaria para crear
		int cell = panelPreparacion.getTamanioTablero();
		int diff = panelPreparacion.getDificultad();
		
		tableroLogica = new Tablero(cell);
		panelTablero.setCantidadCuadrados(cell);
		
		tableroLogica.desordenar(diff);
		panelTablero.repaint();
	}
	
	public void reiniciar() {
		tableroLogica.reiniciar();
		panelTablero.repaint();
	}
	
	public void top10() {
		new MostrarTop10(top10.darRegistros().stream().toArray(RegistroTop10[]::new));
	}
	
	public void cambiarDeJugador() {
		panelDuranteJuego.setJugadas(0);
		panelDuranteJuego.setJugador(getNombreUsuario());
		juegoNuevo();
	}
	
	public void iniciarJuego(int[] celdas) {
		if (tableroLogica!= null) {
			tableroLogica.jugar(celdas[0], celdas[1]);
			panelDuranteJuego.setJugadas(tableroLogica.darJugadas());
			if (tableroLogica.tableroIluminado()) {
				int score = tableroLogica.calcularPuntaje();
				String label = "Coronasteee! yey" + "Tu puntaje: " + score;
				if (top10.esTop10(score)) {
					label += "\n Llegaste al top 10, crack!";
					top10.agregarRegistro(nombreJugador, score);
				}
				JOptionPane.showMessageDialog(null, label);
			}
		}
	}
	
	
	//El main xd
	
	//Main que genera una instancia del juego
		public static void main (String[] arg) {
			VentanaLightsOut ventanaLights = new VentanaLightsOut();
		}

}
