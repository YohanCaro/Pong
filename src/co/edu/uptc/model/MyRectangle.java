package co.edu.uptc.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import co.edu.uptc.controller.GameListener;
import co.edu.uptc.utilities.Constants;
import co.edu.uptc.view.GamePanel;

/**
 * Clase MyRectangle - 
 *
 * @author Yohan Caro
 * @version 1.0 - 14/06/2019
 */
public class MyRectangle extends Thread {

	private int x, y, width, height;
	private Color backgroundColor, borderColor;
	private BasicStroke bs;
	private boolean isLife;
	
	public MyRectangle(int x, int y, int width, int height, Color backgroundColor, Color borderColor, BasicStroke bs) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.backgroundColor = backgroundColor;
		this.borderColor = borderColor;
		this.bs = bs;
		this.isLife = true;
	}
	
	public void draw(Graphics2D g) {
		 g.setPaint(backgroundColor);
	     g.fillRect(x, y, width, height);
	     g.setStroke(bs);
	     g.setPaint(borderColor);
	     g.drawRect(x, y, width, height);
	}
	
	@Override
	public void run() {
		boolean enter = true;
		while (this.isLife) {
			if (y > Constants.MAX_Y-70) {
				enter = false;
			} 
			if (y < 0) {
				enter = true;
			}
			y += (enter)?2:-2;
			try {
				sleep(8);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
	public void move(int n) {
		if (n==1) {
			if (GameListener.up && y > 0) {
				y -= 1;
			} else if (GameListener.down && y < Constants.MAX_Y-70) {
				y += 1;
			}
		} else {
			if (GameListener.w && y > 0) {
				y -= 1;
			} else if (GameListener.s && y < Constants.MAX_Y-70) {
				y += 1;
			}
		}
	}
	
	public boolean isLife() {
		return this.isLife;
	}
	
	public void setIsLife(boolean life) {
		this.isLife = life;
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
	 * @return width
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Obtiene 
	 * @return height
	 */
	public int getHeight() {
		return height;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	
}
