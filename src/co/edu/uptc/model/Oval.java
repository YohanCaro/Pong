package co.edu.uptc.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import co.edu.uptc.utilities.Constants;

public class Oval extends Thread {
	
	private int x, y, size;
	private Color backgroundColor, borderColor;
	private BasicStroke bs;
	private boolean isAvailable;
	
	public Oval(int x, int y, int size, Color backgroundColor, Color borderColor, BasicStroke bs) {
		this.backgroundColor = backgroundColor;
		this.borderColor = borderColor;
		this.bs = bs;
		this.x = x;
		this.y = y;
		this.size = size;
		isAvailable = true;
	}
	
	public void draw(Graphics2D g2) {
		g2.setColor(borderColor);
		g2.fillOval(x, y, size, size);
		g2.setStroke(bs);
		g2.setColor(backgroundColor);
	}
	
	@Override
	public void run() {
		boolean isX = true, isY = true;
		while (isAvailable) {
			x += isX?1:-1;
			y += isY?2:-2;
			if (x < 0) {
				isX = true;
			} 
			if (x > Constants.MAX_X) {
				isX = false;
			}
			if (y < 0) {
				isY = true;
			}
			if (y > Constants.MAX_Y) {
				isY = false;
			}
			
			try {
				sleep(15);
			} catch (InterruptedException e) {
				System.out.println("Hilo de la bolita se muri�");
			}
		}
	}
	
	/**
	 * Obtiene 
	 * @return isAvailable
	 */
	public boolean isAvailable() {
		return isAvailable;
	}	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Obtiene 
	 * @return size
	 */
	public int getSize() {
		return size;
	}

	public Color getColorFondo() {
		return backgroundColor;
	}

	public Color getColorBorde() {
		return borderColor;
	}	

}
