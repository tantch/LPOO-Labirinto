package maze.gui;

import maze.logic.*;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.io.IOException;

import javax.swing.SwingConstants;

public class MyFrame extends JFrame {
	JPanel cards;
	StartPanel startPanel;
	BoardPanel boardPanel;
	OptionsPanel optionsPanel;
	MapPanel mapPanel;
	Game gm;
	int opHeight,opWidth,opNum,opDif;
 
	
	public void reset() {
		gm = new Game(opHeight, opWidth, opNum);
	}

	public MyFrame() {
		setTitle("Sea Dungeon");
		opHeight=10;
		opWidth=10;
		opNum=1;
		opDif=2;
		gm = new Game(opHeight, opWidth, opNum);
		setSize(840, 525);
		getContentPane().setLayout(new BorderLayout(0, 0));

		boardPanel = new BoardPanel(this);
		startPanel = new StartPanel(this);
		optionsPanel = new OptionsPanel(this);
		mapPanel = new MapPanel(this);
		cards = new JPanel(new CardLayout());
		cards.add(startPanel,"start");
		cards.add(boardPanel,"board");
		cards.add(optionsPanel,"options");
		cards.add(mapPanel,"map");
		getContentPane().add(cards);
		startPanel.start();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	
	
	public void toStart(){
		CardLayout c1 = (CardLayout) cards.getLayout();
		c1.show(cards, "start");
		startPanel.start();
		setSize(840, 525);
	}
	public void toOptions(){
		CardLayout c1 = (CardLayout) cards.getLayout();
		c1.show(cards, "options");
		optionsPanel.start();
		setSize(840, 525);
	}
	public void toBoard(){
		CardLayout c1 = (CardLayout) cards.getLayout();
		c1.show(cards, "board");
		
		setSize(800, 600);
	}
	public void toMap(){
		CardLayout c1 = (CardLayout) cards.getLayout();
		c1.show(cards, "map");
		setSize(800, 600);
		mapPanel.StartMapping();
		
	}
	
	
	
}
