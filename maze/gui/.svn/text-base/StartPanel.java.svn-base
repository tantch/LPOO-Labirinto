package maze.gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;

import maze.logic.Game;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class StartPanel extends JPanel {

	MyFrame fram;
	JButton startButton;
	JButton optionsButton;
	JButton loadButton;
	JButton mapButton;
	private JMenuBar startBar;
	private JMenu file;
	private JMenuItem exit;
	Image fundo;
	int xstart;

	
	public StartPanel(final MyFrame fram) {
		this.fram = fram;
		setBackground(Color.BLACK);

		xstart = 460;
		setLayout(null);
		setButtons();
		startBar = new JMenuBar();
		ImageIcon itemp = new ImageIcon(this.getClass().getResource(
				"images/fundo.png"));
		fundo = itemp.getImage();
	
		
		file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);

		exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});

		file.add(exit);
		startBar.add(file);
		setOpaque(true);
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(fundo, 0, 0, getWidth(), getHeight(), this);

	}

	private void setButtons() {

		// Start game button
		startButton = new JButton("New Game");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed

				fram.toBoard();
				fram.boardPanel.startNewGame(fram.gm, false);
			}
		});
		startButton.setSize(140, 50);
		startButton.setLocation(xstart, 120);
		startButton.setVisible(true);

		mapButton = new JButton("Costum Map");
		mapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				fram.toMap();
			}
		});
		mapButton.setSize(140, 50);
		mapButton.setLocation(xstart, 200);
		mapButton.setVisible(true);
		// Options menu button
		optionsButton = new JButton("Options");
		optionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				fram.toOptions();

			}
		});
		optionsButton.setSize(140, 50);
		optionsButton.setLocation(xstart, 360);
		optionsButton.setVisible(true);
		loadButton = new JButton("Load");
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				fram.toBoard();
				try {
					fram.boardPanel.loadGame();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		loadButton.setSize(140, 50);
		loadButton.setLocation(xstart, 280);
		loadButton.setVisible(true);
		addButtons();

	}
	private void addButtons(){
		add(optionsButton);
		add(startButton);
		add(loadButton);
		add(mapButton);
	}

	public void start() {
		requestFocusInWindow();
		fram.setResizable(false);
		fram.setJMenuBar(startBar);

	}

}
