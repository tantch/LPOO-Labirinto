package maze.gui;

import javax.swing.JPanel;

import maze.logic.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BoardPanel extends GeneralPanel implements ActionListener {

	private static int animationTimer = 100;
	private boolean started = false;
	private boolean end = true;
	private Timer tim;
	private Thread t;
	private boolean heroRest = false, firstmove = false;
	private int heroDelay = 0, timeT = 0;
	int upKey, downKey, leftKey, rightKey, eagleKey;
	private JMenuBar boardBar;
	private JMenu file;
	private JMenu help;
	private JMenuItem save;
	private JMenuItem showhelp;
	private JMenuItem exit;

	public BoardPanel(JFrame fr) {

		super(fr);
		addKeyListener(new GameAdapter());
		t = new Thread(new Painting(this));
		t.start();
		upKey = KeyEvent.VK_UP;
		downKey = KeyEvent.VK_DOWN;
		leftKey = KeyEvent.VK_LEFT;
		rightKey = KeyEvent.VK_RIGHT;
		eagleKey = KeyEvent.VK_F;
		setBar();
	}

	private void setBar() {
		boardBar = new JMenuBar();

		file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);

		save = new JMenuItem("Save and Exit");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int sve = 0;
				SaveLoad sv = new SaveLoad();
				try {
					tim.stop();
					sve = sv.save(fram.gm);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (sve == 0) {
					started = false;
					fram.reset();
					firstmove = false;
					fram.toStart();

					return;
				} else {
					tim.start();
				}
			}
		});

		exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				started = false;
				fram.reset();
				tim.stop();
				firstmove = false;
				fram.toStart();
				return;
			}
		});
		file.add(save);
		file.add(exit);
		showhelp = new JMenuItem("Help");
		showhelp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				final JFrame helpframe = new JFrame("Help");
				JLabel helptext = new JLabel(
						"<html>Game Instructions <br>"
								+ "<br>"
								+ "<br>"
								+ "You are a Hero in a Sea Dungeon, you must defeat<br>"
								+ "all the enemies but for that you need to eat first<br>"
								+ "if you face an enemy while hungry you will die<br>"
								+ "you can use your helpfull cook that can run across the water<br>"
								+ "to get the food safer or faster<br>"
								+ "once you defeat everyone the bridge will be lowered and you can leave.<br>"
								+ "<br>"
								+ "Default keys: <br>"
								+ "up - up Key<br>"
								+ "down - down Key<br>"
								+ "left - left arrow<br>"
								+ "right - right arrow<br>"
								+ "send eagle - f key<br>"
								+ ""
								+ "All this keys may be switched in the options through the Main menu<br>"
								+ "as well as many other options ingame<br><br><br></html>");

				helptext.setBounds(40, 40, 700, 500);
				helpframe.getContentPane().add(helptext);
				helpframe.getContentPane().setLayout(null);
				helpframe.setSize(800, 600);
				helpframe.setResizable(false);
				helpframe.setLocationRelativeTo(null);
				helpframe.setVisible(true);
				tim.stop();

				JButton cont = new JButton("Continue");
				cont.setBounds(300, 450, 120, 20);
				cont.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						helpframe.dispose();
						tim.start();
					}

				});
				helpframe.getContentPane().add(cont);
			}
		});
		help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		help.add(showhelp);
		boardBar.add(file);
		boardBar.add(help);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == tim) {
			timeT++;
			if (heroRest) {
				if (heroDelay == 1) {
					heroRest = false;
					heroDelay = 0;
				} else {
					heroDelay++;
				}
			}

			if (timeT % 10 == 0 && firstmove) {
				fram.gm.moveSeconds();
				tryEnd();
			}
		}

	}

	public void startNewGame(Game gm, boolean loaded) {
		end = false;
		setBackground(Color.BLACK);
		requestFocusInWindow();
		this.fram.gm = gm;
		if (!loaded) {
			fram.gm.start();
			fram.gm.setDificulty(fram.opDif);
		}
		fram.setResizable(true);
		setDimensions();
		fram.gm.getEX().setInvisible(true);
		started = true;
		tim = new Timer(50, (ActionListener) this);
		tim.start();
		fram.setJMenuBar(boardBar);

	}

	private class GameAdapter extends KeyAdapter {
		public void keyPressed(KeyEvent e) {

			int key = e.getKeyCode();
			if (end)
				return;
			int rsp = 1;
			if (!firstmove)
				firstmove = true;
			if (!heroRest) {
				heroRest = true;
				if (key == leftKey) {
					rsp = fram.gm.action("a");
				} else if (key == downKey) {
					rsp = fram.gm.action("s");
				} else if (key == rightKey) {
					rsp = fram.gm.action("d");
				} else if (key == upKey) {
					rsp = fram.gm.action("w");
				} else if (key == eagleKey) {
					rsp = fram.gm.action("f");
				}

				tryEnd();
			}
		}
	}

	private void tryEnd() {
		if (fram.gm.end()) {
			tim.stop();
			end = true;
			String msg = "Game finished";
			JOptionPane.showMessageDialog(getRootPane(), msg);
			firstmove = false;
			started = false;
			fram.reset();

			fram.toStart();

		}
	}

	public void paint(Graphics g) {

		if (!started)
			return;
		setDimensions();
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		drawGame(g2d);
	}

	private static class Painting implements Runnable, ActionListener {
		Timer timer;
		BoardPanel panel;
		double time;

		public Painting(BoardPanel p) {
			panel = p;
		}

		public void actionPerformed(ActionEvent e) {

			panel.repaint();
			time++;
			if (time % 1 == 0) {
				panel.frame++;
				if (panel.frame > 59)
					panel.frame = 0;
			}

		}

		public void run() {

			timer = new Timer(animationTimer, (ActionListener) this);
			timer.setInitialDelay(0);
			timer.start();

		}
	}

	public boolean isReady() {
		if (started && !end)
			return true;
		return false;
	}

	public void loadGame() throws ClassNotFoundException, IOException {

		setBackground(Color.BLACK);

		SaveLoad sv = new SaveLoad();
		Game gtemp = (Game) sv.load();
		if (gtemp == null) {
			String msg = "Load file invalid";
			JOptionPane.showMessageDialog(getRootPane(), msg);
			fram.reset();

			fram.toStart();
			return;
		}
		fram.gm = gtemp;
		startNewGame(gtemp, true);

	}
}
