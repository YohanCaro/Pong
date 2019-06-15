package co.edu.uptc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.uptc.utilities.Constants;
import co.edu.uptc.utilities.Utilities;
import co.edu.uptc.view.AboutDialog;
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
			Utilities.showMessageInfo("Comming soon...", "Está en proceso!");
			break;
		case Constants.ACTION_TWO_PLAYERS:
			mainWindow.setVisible(true);
			mainWindow.getMenuWindow().setVisible(false);
			break;
		case Constants.ACTION_MULTIPLAYER:
			Utilities.showMessageInfo("Comming soon...", "En un futuro");
			break;
		case Constants.ACTION_ABOUT:
			new AboutDialog();
			break;
		case Constants.ACTION_CLOSE_MENU_WINDOW:
			System.exit(0);
			break;
		default:
			break;
		}
	}
	
		
}
