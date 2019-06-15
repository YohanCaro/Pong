package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import co.edu.uptc.controller.ButtonsListener;
import co.edu.uptc.controller.Control;
import co.edu.uptc.controller.GameListener;
import co.edu.uptc.utilities.Constants;

public class MainWindow extends JFrame {
	
	private GamePanel gamePanel;
	private MenuWindow menuWindow;
//	private JPanel panelGroup;
	private Control control;
	private ButtonsListener buttonsListener;
	private boolean activar;
	
	public MainWindow() {	
		this.setTitle("Juego!");
		this.setSize(Constants.SIZE_WIDTH, Constants.SIZE_HEIGHT);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.getContentPane().setBackground(Color.WHITE);
		
		this.addKeyListener(buttonsListener);
		control = new Control();
		buttonsListener = new ButtonsListener(this);
		
		gamePanel = new GamePanel(buttonsListener);
		this.addKeyListener(GameListener.getInstanceOf(gamePanel));
		this.add(gamePanel);
		
		this.menuWindow = new MenuWindow(this);
		
//		this.init();
	}
	
	public void init() {
		
	}
			
	public boolean isActivar() {
		return activar;
	}

	public void setActivar(boolean activar) {
		this.activar = activar;
	}

	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public Control getControl() {
		return control;
	}

	/**
	 * Obtiene 
	 * @return menuWindow
	 */
	public MenuWindow getMenuWindow() {
		return menuWindow;
	}
	
	
	
}
