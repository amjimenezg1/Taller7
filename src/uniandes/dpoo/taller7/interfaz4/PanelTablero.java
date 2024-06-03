package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JPanel;



public class PanelTablero extends JPanel implements MouseMotionListener, MouseListener {

	//Matriz de botones para mostrar lights
	
	private int cantidadCuadros = 5;
	private VentanaLightsOut padre;

	//Espacio entre cuadrados
	private int espacio = 2;
	private int tamanioCuadro;
	
	//Coordenadas mouse en panel
	private int coordenadaX;
	private int coordenadaY;
	private boolean juegoPausado = false;

	//pARA CREAR UNA GRILLA PASAS UNA REFERENCIA AL JUEGO Y EL TAMAÃ‘O DEL PANEL (I)
	public PanelTablero(VentanaLightsOut papa, int tamanioTablero) {
		
		this.cantidadCuadros = tamanioTablero;
		this.padre = papa;
		
		//Dimensiones del tablero
		setPreferredSize(new Dimension(450, 450));
		addMouseMotionListener(this);
		addMouseListener(this);
	}

	public void setCantidadCuadrados(int cantidad) {
		this.cantidadCuadros = cantidad;
	}

	public int getCantidadCuadrados() {
		return cantidadCuadros;
	}

	//Metodos de los Listeners
	
	@Override
	public void paintComponent(Graphics gB) {
		//Graphics como se indicó en el taller de java2d -> cubrir cosas complejas de diseño
		Graphics2D g = (Graphics2D) gB;
		
		//Fondo color gris lindo clarito :3
		Color colorGris = new Color (242,242,242);
		
		//Pongo color gris en fondo
		g.setColor(colorGris);
		

		
		g.fillRoundRect(0, 0, getSize().width, getSize().height, 20,20);
		

		//tamanio de 1 cuadro
		tamanioCuadro = Math.min(getSize().width, getSize().height) / cantidadCuadros;
		
		//Cargo la imagen
		 ImageIcon iconoOriginal = new ImageIcon("./data/luz.png");
	     Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(tamanioCuadro - 2 * espacio, tamanioCuadro - 2 * espacio, Image.SCALE_SMOOTH);
	     ImageIcon iconoBombillo = new ImageIcon(imagenEscalada); // Nuevo
	    

		

		for (int i = 0; i < cantidadCuadros && !juegoPausado; i++) {
			for (int j = 0; j < cantidadCuadros; j++) {
				g.setColor(Color.GRAY);
				if (padre.estaEncendida(i, j))	
					g.setColor(Color.YELLOW);
				
					
				if (cantidadCuadros + i * tamanioCuadro <= coordenadaX && coordenadaX < cantidadCuadros + i * tamanioCuadro + tamanioCuadro - 2 * cantidadCuadros) {
					if (espacio + j * tamanioCuadro <= coordenadaY && coordenadaY < espacio + j * tamanioCuadro + tamanioCuadro - 2 * espacio) {
						g.setColor(Color.white);
						
					}
				}
				g.fillRoundRect(espacio + i * tamanioCuadro, espacio + j * tamanioCuadro, tamanioCuadro - 2 * espacio, tamanioCuadro - 2 * espacio, 20, 20);
				//Le pongo borde bonitooo
				g.setColor(Color.black);
				g.drawRoundRect(espacio + i * tamanioCuadro, espacio + j * tamanioCuadro, tamanioCuadro - 2 * espacio, tamanioCuadro - 2 * espacio, 20, 20);
				
				//Le pongo la imagen! AL FIN!!
				g.drawImage(iconoBombillo.getImage(), espacio + i * tamanioCuadro, espacio + j * tamanioCuadro, this);
			}
		}
	}

	@Override
	//Obtener las coordenadas del click, y repintar la casilla
	public void mouseClicked(MouseEvent e) {
		int enX = e.getX();
		int enY = e.getY();
		int[] cells = getCoordenadaPosicion(enX, enY);
		if (!Arrays.equals(cells, new int[] { -1, -1 })) {
			padre.iniciarJuego(cells);
		}
		repaint();
	}

	//Obtener las coordenadas del mouse en una celda o light
	private int[] getCoordenadaPosicion(int coordX, int coordY) {
		for (int i = 0; i < cantidadCuadros; i++) {
			for (int j = 0; j < cantidadCuadros; j++) {
				if (espacio + i * tamanioCuadro <= coordX && coordX < espacio + i * tamanioCuadro + tamanioCuadro - 2 * espacio) {
					if (espacio + j * tamanioCuadro <= coordY && coordY < espacio + j * tamanioCuadro + tamanioCuadro - 2 * espacio) {
						return new int[] { i, j };
					}
				}
			}
		}
		return new int[] { -1, -1 };
	}

	//Saber donde esta el mouse
	@Override
	public void mouseMoved(MouseEvent e) {
		this.coordenadaX = e.getX();
		this.coordenadaY = e.getY();
		repaint();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	
}
