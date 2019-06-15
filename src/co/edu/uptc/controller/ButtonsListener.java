package co.edu.uptc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.uptc.utilities.Constants;
import co.edu.uptc.view.MainWindow;

/** Clase ButtonsListener - 
 *
 * @author Yohan Caro
 * @version 1.0 - 15/06/2019
 */
public class ButtonsListener implements ActionListener {
	
	private MainWindow mainWindow;
	
	/**
	 * Constructor
	 */
	public ButtonsListener(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		switch (command) {
		case Constants.ACTION_NEW_GAME:

			break;
		case Constants.ACTION_TWO_PLAYERS:
			mainWindow.setVisible(true);
			mainWindow.getMenuWindow().setVisible(false);
			break;
		case Constants.ACTION_MULTIPLAYER:
			
			break;
		case Constants.ACTION_ABOUT:
			
			break;
		case Constants.ACTION_CLOSE_MENU_WINDOW:
			System.exit(0);
			break;
		default:
			break;
		}
	}
	
		
}
