package co.edu.uptc.view;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import co.edu.uptc.controller.Control;
import co.edu.uptc.controller.GameListener;
import co.edu.uptc.utilities.Constants;

public class MainWindow extends JFrame{
	
	private GamePanel panelJ;
	private Control control;
	private boolean activar;
	
	public MainWindow() {	
		this.setTitle("Juego!");
		this.setSize(Constants.SIZE_WIDTH, Constants.SIZE_HEIGHT);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.WHITE);
		
		control = new Control();		
				
		activar = false;
		
		this.addKeyListener(GameListener.getInstanceOf());
		
		panelJ = new GamePanel(this);
		panelJ.repaint();
		this.add(panelJ);
	}
	
	public boolean isActivar() {
		return activar;
	}

	public void setActivar(boolean activar) {
		this.activar = activar;
	}

	public GamePanel getPanelJ() {
		return panelJ;
	}

	public void setPanelJ(GamePanel panelJ) {
		this.panelJ = panelJ;
	}

	public Control getControl() {
		return control;
	}

	public void setControl(Control control) {
		this.control = control;
	}
		
}
