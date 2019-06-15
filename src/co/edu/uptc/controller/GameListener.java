package co.edu.uptc.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

import co.edu.uptc.view.GamePanel;

/** Clase GameListener.java - 
 *
 * @author Yohan Caro
 * @version 1.0 - 14/06/2019
 */
public class GameListener extends KeyAdapter {
	
	public static boolean up, down, w, s, enter, space;
	private GamePanel gamePanel;
	private static GameListener gameListener;
	
	private GameListener(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_UP) {
			up = true;
		}
		
		if (key == KeyEvent.VK_DOWN) {
			down = true;
		}
		
		if (key == KeyEvent.VK_W) {
			w = true;
		}
		
		if (key == KeyEvent.VK_S) {
			s = true;
		}
		
		if (key == KeyEvent.VK_ENTER) {
			enter = true;
		}
		
		if (key == KeyEvent.VK_SPACE){
			gamePanel.setPause(!gamePanel.isPause());
		}
		
		if (key == KeyEvent.VK_ESCAPE) {
			gamePanel.setPause(true);
			Object [] opciones ={"Aceptar","Cancelar"};
			int eleccion = JOptionPane.showOptionDialog(null, "¿Desea salir del juego?","Mensaje de Confirmacion!",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
			if (eleccion == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
		
		if (key == KeyEvent.VK_R) {
			if (gamePanel.isDead()) {
				gamePanel.start();
			}
		}
		
		if (key == KeyEvent.VK_PLUS) {
			if (gamePanel.time > 6) {
				gamePanel.time--;
			}
		}
		
		if (key == KeyEvent.VK_MINUS) {
			if (gamePanel.time < 17) {
				gamePanel.time++;
			}
		}

	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_UP) {
			up = false;
		}
		
		if (key == KeyEvent.VK_DOWN) {
			down = false;
		}
		
		if (key == KeyEvent.VK_W) {
			w = false;
		}
		
		if (key == KeyEvent.VK_S) {
			s = false;
		}
		
		if (key == KeyEvent.VK_ENTER) {
			enter = false;
		}
		
	}
	
	public static GameListener getInstanceOf(GamePanel gamePanel) {
		if (gameListener == null) {
			gameListener = new GameListener(gamePanel);
		}
		return gameListener;
	}

}
