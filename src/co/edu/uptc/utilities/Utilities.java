/**
 * 
 */
package co.edu.uptc.utilities;

import javax.swing.JOptionPane;

/**Clase Utilities.java - 
 *
 * @author Yohan Caro
 * @version 1.0 - 15/06/2019
 */
public class Utilities {
	
	public static void showMessageError(String title, String message) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
	}
	
	public static void showMessageInfo(String title, String message) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void showMessageWarning(String title, String message) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
	}

}
