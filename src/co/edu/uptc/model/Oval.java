package co.edu.uptc.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import co.edu.uptc.utilities.Constants;

public class Oval {
	
	private int x, y, size;
	private Color backgroundColor, borderColor;
	private BasicStroke bs;
	private boolean isLive;
	private boolean isX, isY;
	
	public Oval(int x, int y, int size, Color backgroundColor, Color borderColor, BasicStroke bs) {
		this.backgroundColor = backgroundColor;
		this.borderColor = borderColor;
		this.bs = bs;
		this.x = x;
		this.y = y;
		this.size = size;
		isLive = true;
		
		isX = true;
		isY = true;
	}
	
	public void draw(Graphics2D g2) {
		g2.setColor(borderColor);
		g2.fillOval(x, y, size, size);
		g2.setStroke(bs);
		g2.setColor(backgroundColor);
	}
	
	public void move() {
		x += isX?1:-1;
		y += isY?2:-2;
		
		if (minorX() || maxX()) {
			isLive = false;
		}
		
		if (y < 0) {
			isY = true;
		}
		if (y > Constants.MAX_Y) {
			isY = false;
		}
	}
	
	public boolean minorX() {
		return (x < 0);
	}
	
	public boolean maxX() {
		return (x > Constants.MAX_X);
	}
	
	public void intercept(MyRectangle rectangle) {
		Ellipse2D elipse = new Ellipse2D.Double(x, y, size, size);
		
		if (elipse.intersects(new Rectangle2D.Double(rectangle.getX(), rectangle.getY(), rectangle.getWidth(),
				rectangle.getHeight()))) {
			
			if (rectangle.getY() > elipse.getY()+size-10 || rectangle.getY()+rectangle.getHeight() < elipse.getY()+size-10) {
				isY = !isY;
			} else {
				isX = !isX;
			}

		} 
	}
	
	/**
	 * Obtiene 
	 * @return isAvailable
	 */
	public boolean isLive() {
		return isLive;
	}	
	
	/**
	 * Cambia 
	 * @param isLive the isLive to set
	 */
	public void setLive(boolean isLive) {
		this.isLive = isLive;
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
