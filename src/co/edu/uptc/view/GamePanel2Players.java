package co.edu.uptc.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import co.edu.uptc.model.Oval;
import co.edu.uptc.utilities.Constants;
import co.edu.uptc.controller.ButtonsListener;
import co.edu.uptc.controller.GameListener;
import co.edu.uptc.model.MyRectangle;

public class GamePanel2Players extends JPanel implements Runnable {
	
	public int time;
	private static final long serialVersionUID = 1L;
	private MyRectangle rectangle, rectangle2;
	private Oval ball;
	private HelpPane helpPane;
	private boolean play, pause, dead;
	private byte pointsP1, pointsP2;
	
	public GamePanel2Players(ButtonsListener buttonsListener) {
		this.setLayout(null);
		this.setBounds(0, 20, Constants.SIZE_WIDTH, Constants.SIZE_HEIGHT);
		
		time = 14;
		ball = new Oval(300, 250, 30, new Color(7, 246, 94), Color.GREEN, new BasicStroke(2));
		rectangle = new MyRectangle(20, Constants.MAX_Y/2, 20, 100, new Color(2, 177, 255), Color.CYAN, new BasicStroke(2));
		rectangle2 = new MyRectangle(800, Constants.MAX_Y/2, 20, 100, new Color(2, 177, 255), Color.CYAN, new BasicStroke(2));
		helpPane = new HelpPane();
		
		pointsP1 = 0;
		pointsP2 = 0;
		
		inicializarBooleanos();
		start();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Constants.MAX_X + 30, Constants.MAX_Y + 30);
		g.setColor(Color.CYAN);
		g.drawRect(0, 0, Constants.MAX_X + 30, Constants.MAX_Y + 30);
				
		//Puntaje
		g.setFont(new Font("Arial Black", 1, 18));
		g.setColor(Color.WHITE);
		g.drawString("P1: " + pointsP1, 170, 60);
		g.drawString("P2: " + pointsP2, 570, 60);
		
		rectangle.draw((Graphics2D) g);
		rectangle2.draw((Graphics2D) g);
		
		ball.draw((Graphics2D) g);
		
		g.setColor(Color.WHITE);		
		g.setFont(new Font("Arial Black", 1, 20));
		g.drawString("PONG!", Constants.MAX_X/2, 40);
		
		if (!GameListener.enter && !play) {
			this.throwMessage("Press ENTER", (Graphics2D) g);
		} else {
			if (!play) {
				play = true;
			}
		}
		
		if (pause && play) {
			this.throwMessage("Pause", (Graphics2D) g);
		}		
		helpPane.draw((Graphics2D) g);
		g.setColor(Color.WHITE);
		this.throwMessage("Speed: " + time, (Graphics2D) g, 500, 600);
		this.getWin((Graphics2D) g);
	}
	
	public void start() {
		ball.setX(Constants.DEFAULT_X);
		ball.setY(Constants.DEFAULT_Y);
		ball.setLive(true);
		new Thread(this).start();
	}
	
	@Override
	public void run() {
		while (ball.isLive()) {
			this.repaint();
			if (play && !pause) {
				ball.intercept(rectangle);
				ball.intercept(rectangle2);
				this.move();
				ball.move();
			}
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void getWin(Graphics2D g) {
		if (!ball.isLive()) {
			play = false;
			if (ball.minorX()) {
				this.throwMessage("Player 2 WIN!", g);
				pointsP2++;
			} else if (ball.maxX()) {
				this.throwMessage("Player 1 WIN!", g);
				pointsP1++;
			}
		}
	}
		
	public void move() {
		rectangle.move(2);
		rectangle2.move(1);
	}
	
	public boolean isDead() {
		return !ball.isLive();
	}
		
	/**
	 * Metodos inicializadores!
	 */
	public void inicializarBooleanos() {
		play = false;
		pause = false;
		dead = false;
	}
	
	public void throwMessage(String message, Graphics2D g) {
		g.drawString(message, Constants.MAX_X/2, Constants.MAX_Y/2+20);
	}
	
	public void throwMessage(String message, Graphics2D g, int x, int y) {
		g.drawString(message, x, y);
	}
	
	/**
	 * Cambia 
	 * @param pause the pause to set
	 */
	public void setPause(boolean pause) {
		this.pause = pause;
	}
	
	/**
	 * Obtiene 
	 * @return pause
	 */
	public boolean isPause() {
		return pause;
	}
	
}
