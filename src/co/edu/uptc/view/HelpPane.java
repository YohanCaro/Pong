/**
 * 
 */
package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import co.edu.uptc.utilities.Constants;

/**Clase HelpPane.java - 
 *
 * @author Yohan Caro
 * @version 1.0 - 15/06/2019
 */
public class HelpPane {
	
	/**
	 * 
	 */
	public HelpPane() {
		
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.drawString("AYUDA", Constants.MAX_X + 150, 50);
		g.setFont(new Font("Arial", 1, 20));
		g.drawString("ENTER -> Empezar juego!", Constants.MAX_X + 50, 90);
		g.drawString("SPACE -> Pausa/Despausa!", Constants.MAX_X + 50, 120);
		g.drawString("R -> Reiniciar!", Constants.MAX_X + 50, 150);
		g.drawString("(+) -> Aumenta la velocidad!", Constants.MAX_X + 50, 180);
		g.drawString("(-) -> Disminuye la velocidad!", Constants.MAX_X + 50, 210);
		g.drawString("ESCAPE - Salir!", Constants.MAX_X + 50, 240);
	}

}
