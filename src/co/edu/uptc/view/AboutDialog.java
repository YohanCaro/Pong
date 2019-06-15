package co.edu.uptc.view;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/** Clase AboutDialog - 
 *
 * @author Yohan Caro
 * @version 1.0 - 15/06/2019
 */
public class AboutDialog extends JDialog {
	
	private JTextArea infoTextArea;
	private JScrollPane scrollPane;
	private String message;
	
	/**
	 * Constructor
	 */
	public AboutDialog() {
		this.setSize(370, 450);
		this.setLocationRelativeTo(null);
		this.setTitle("About..");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		infoTextArea = new JTextArea();
		scrollPane = new JScrollPane();
		this.init();
		
		this.setVisible(true);
	}
	
	private void init() {
		this.setMessage();
		infoTextArea.setText(message);
		infoTextArea.setEditable(false);
		scrollPane.setViewportView(infoTextArea);
		this.add(scrollPane);
	}
	
	public void setMessage() {
		message = "		V 0.3\n"
				+ "	* Opcion de reinicio\n"
				+ "	* Adicion de muertes\n\n"
				+ "		V 0.2.1\n"
				+ "	* Ventana de about\n"
				+ "	* Cuadros de indicaciones\n"
				+ "	* Bug fixes\n"
				+ "	  - Choques laterales de la bola y rectagulos\n"
				+ "	  - Botón de pausa\n\n"
				+ "		V 0.2\n"
				+ "	* Colores oscuros\n"
				+ "	* Rebotes mejorados\n"
				+ "	* Opcion de play\n"
				+ "	* Opcion de pausa\n"
				+ "	* Ventana de menú de opciones\n"
				+ "	* Movimiento de rectangulos por teclas\n"
				+ "	* Bug fixes\n"
				+ "	  - Movimiento de la bola\n"
				+ "	  - Repintado\n\n"
				+ "		V 0.1\n"
				+ "	* Rebotes básicos\n"
				+ "	* Bolita en movimiento\n"
				+ "	* Movimiento de rectangulos por hilos\n"
				+ "	* Ventana de juego\n"
				+ "	* Botón de iniciar";
	}
}
