package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import co.edu.uptc.controller.ButtonsListener;
import co.edu.uptc.utilities.Constants;

/** Clase MenuWindow.java - 
 *
 * @author Yohan Caro
 * @version 1.0 - 15/06/2019
 */
public class MenuWindow extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private JLabel titleLabel;
	private JButton newGameButton,twoPlayersButton, multiplayerButton, aboutButton, leftButton;
	private ButtonsListener buttonsListener;
	
	/**
	 * Constructor
	 */
	public MenuWindow(MainWindow mainWindow) {
		this.buttonsListener = new ButtonsListener(mainWindow);
		titleLabel = new JLabel("      PONG!!");
		newGameButton = new JButton("New Game");
		twoPlayersButton = new JButton("Two Players");
		multiplayerButton = new JButton("Multiplayer");
		aboutButton = new JButton("About...");
		leftButton = new JButton("Exit");
		init();
	}
	
	private void init() {
		this.setLayout(new BorderLayout());
		this.setUndecorated(true);
		this.add(Box.createRigidArea(new Dimension(150, 10)), BorderLayout.WEST);
		this.add(Box.createRigidArea(new Dimension(150, 10)), BorderLayout.EAST);
		this.getContentPane().setBackground(Color.DARK_GRAY);
		pushTitle();
		panelButtons();
		
		newGameButton.setActionCommand(Constants.ACTION_NEW_GAME);
		newGameButton.addActionListener(buttonsListener);
		twoPlayersButton.setActionCommand(Constants.ACTION_TWO_PLAYERS);
		twoPlayersButton.addActionListener(buttonsListener);
		multiplayerButton.setActionCommand(Constants.ACTION_MULTIPLAYER);
		multiplayerButton.addActionListener(buttonsListener);
		aboutButton.setActionCommand(Constants.ACTION_ABOUT);
		aboutButton.addActionListener(buttonsListener);
		leftButton.setActionCommand(Constants.ACTION_CLOSE_MENU_WINDOW);
		leftButton.addActionListener(buttonsListener);
		
		this.setSize(500, 600);
		this.setLocation((this.getX()+this.getWidth()-50), (this.getSize().height+this.getY())/10);
		this.setTitle("MENU PONG");
		this.setVisible(true);
	}
	
	private void pushTitle() {
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("Arial-black", 1, 70));
		this.add(titleLabel, BorderLayout.NORTH);
	}
	
	private void panelButtons() {
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(new GridLayout(9, 1));
		panel.add(newGameButton);
		panel.add(Box.createRigidArea(new Dimension(0, 1)));
		panel.add(twoPlayersButton);
		panel.add(Box.createRigidArea(new Dimension(0, 1)));
		panel.add(multiplayerButton);
		panel.add(Box.createRigidArea(new Dimension(0, 1)));
		panel.add(aboutButton);
		panel.add(Box.createRigidArea(new Dimension(0, 1)));
		panel.add(leftButton);
		
		this.add(panel, BorderLayout.CENTER);
	}

}
