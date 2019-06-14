package co.edu.uptc.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.Random;

import javax.swing.JPanel;

import co.edu.uptc.model.Oval;
import co.edu.uptc.utilities.Constants;
import co.edu.uptc.model.MyRectangle;

public class GamePanel extends JPanel implements Runnable {
	
	private MyRectangle rectangle, rectangle2;
	private Oval bola;
	private boolean play, pause, space;
	private MainWindow ventana;
	
	public GamePanel(MainWindow ventana) {
		this.ventana = ventana;
		this.setLayout(null);
		this.setBounds(0, 20, Constants.SIZE_WIDTH, Constants.SIZE_HEIGHT);
		
		bola = new Oval(300, 250, 30, new Color(7, 246, 94), Color.GREEN, new BasicStroke(2));
		rectangle = new MyRectangle(20, Constants.MAX_Y/2, 20, 100, new Color(2, 177, 255), Color.CYAN, new BasicStroke(2));
		rectangle2 = new MyRectangle(800, Constants.MAX_Y/2, 20, 100, new Color(2, 177, 255), Color.CYAN, new BasicStroke(2));
		
		inicializarBooleanos();
		this.start();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Constants.MAX_X + 30, Constants.MAX_Y + 30);
		g.setColor(Color.CYAN);
		g.drawRect(0, 0, Constants.MAX_X + 30, Constants.MAX_Y + 30);
				
		rectangle.draw((Graphics2D) g);
		rectangle2.draw((Graphics2D) g);
		
		bola.draw((Graphics2D) g);
		
		g.setColor(Color.WHITE);		
		g.setFont(new Font("Arial Black", 1, 20));
		g.drawString("PONG!", Constants.MAX_X/2, 50);
				
	}
	
	public void start() {
		bola.start();
		this.actThreads();
		new Thread(this).start();
	}
	
	@Override
	public void run() {
		while (true) {
			this.repaint();
		}
	}
	
	public void actThreads() {
//		if (!play) {
			this.rectangle.start();
			this.rectangle2.start();
//		}
	}
	
	/**
	 * Metodos inicializadores!
	 */
	
	public void inicializarBooleanos() {
		play = false;
		pause = false;
		space = false;
	}
	

}
