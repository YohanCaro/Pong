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
	private boolean isX, isY;
	
	public Oval(int x, int y, int size, Color backgroundColor, Color borderColor, BasicStroke bs) {
		this.backgroundColor = backgroundColor;
		this.borderColor = borderColor;
		this.bs = bs;
		this.x = x;
		this.y = y;
		this.size = size;
		isAvailable = true;
		
		isX = true;
		isY = true;
	}
	
	public void draw(Graphics2D g2) {
		g2.setColor(borderColor);
		g2.fillOval(x, y, size, size);
		g2.setStroke(bs);
		g2.setColor(backgroundColor);
	}
	
	@Override
	public void run() {
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
	
	public void intercept(MyRectangle rectangle) {
		Ellipse2D elipse = new Ellipse2D.Double(x, y, size, size);
		
		if (elipse.intersects(new Rectangle2D.Double(rectangle.getX(), rectangle.getY(), rectangle.getWidth(),
				rectangle.getHeight()))) {
			
			if (rectangle.getY() > elipse.getY()-1 || rectangle.getY()+rectangle.getHeight() < elipse.getY()+1) {
				if (isY) {
					isY = false;
				} else {
					isY = true;
				}
			} else {
				if (isX) {
					isX = false;
				} else {
					isX = true;
				}
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
