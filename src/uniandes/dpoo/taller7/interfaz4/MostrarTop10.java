package uniandes.dpoo.taller7.interfaz4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;

import uniandes.dpoo.taller7.modelo.RegistroTop10;


public class MostrarTop10 extends JDialog {

	JList<RegistroTop10> lista10;
	
	//Elegi una ventana scrollable
	
	public MostrarTop10(RegistroTop10[] listaTop10) {
		//Fondo color gris lindo clarito :3
		Color colorGris = new Color (242,242,242);
		
		
		JScrollPane ventanitaTop = new JScrollPane();
		// Establece un borde con título alrededor del JScrollPane -> parece como un titulito
		ventanitaTop.setBorder(BorderFactory.createTitledBorder("# Nombre"));
		
		
		//Ponerla en el centro de la ventana del programa
		getContentPane().add(ventanitaTop, BorderLayout.CENTER);

		//JLIST de mi top 10  -> muestra una lista de elementos del top 10
		lista10 = new JList<RegistroTop10>();
		lista10.setBackground(colorGris);
		lista10.setListData(listaTop10);
		
		//Vamos a personalizar -> mi parte fav
		lista10.setCellRenderer(new DefaultListCellRenderer() {	
			
			@Override
			public Component getListCellRendererComponent(JList<?> listaObjetos, Object valor, int indice, boolean esSeleccionado,
					boolean celdaL) {
				Component c = super.getListCellRendererComponent(listaObjetos, valor, indice, esSeleccionado, celdaL);
				
				//Ver si el valor actual es una instancia de RegistroTop10
				if (valor instanceof RegistroTop10) {
					//Castear a RegistroTop10
					RegistroTop10 enElTop = (RegistroTop10) valor;
					
					//Recorro los elementos de mi lista de top
					for (int i = 0; i < listaTop10.length; i++) {
						if (listaTop10[i].equals(enElTop)) {
							//Formateo 
							setText(String.format("%3d) %5s ..... %4d", i + 1, enElTop.darNombre(), enElTop.darPuntos()));
							setFont(new Font("Arial", Font.PLAIN, 15));
							setForeground(Color.BLACK);
							setBackground(Color.WHITE);
						}
					}

				}
				return c;
			}

		});
		
		//Esto es lo que quiero que muestre
		ventanitaTop.setViewportView(lista10);
		//Ajusta tamañoo
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
