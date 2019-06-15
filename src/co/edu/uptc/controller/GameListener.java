/**
 * 
 */
package co.edu.uptc.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**Clase GameListener.java - 
 *
 * @author Yohan Caro
 * @version 1.0 - 14/06/2019
 */
public class GameListener extends KeyAdapter {
	
	public static boolean up, down, w, s;
	private static GameListener gameListener;
	
	private GameListener() {
		
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
	}
	
	public static GameListener getInstanceOf() {
		if (gameListener == null) {
			gameListener = new GameListener();
		}
		return gameListener;
	}

}
