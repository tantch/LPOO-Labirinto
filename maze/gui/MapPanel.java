package maze.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import maze.logic.*;

public class MapPanel extends GeneralPanel {
	Unit[][] labi;
	int modo;
	int currentEnemy = 0;
	int currentHero = 0;
	int currentFood = 0;
	int currentExit = 0;
	JMenu file;
	JMenu action;
	JMenuBar menubar;
	JMenuItem saveItem;
	JCheckBoxMenuItem wallItem;
	JCheckBoxMenuItem heroItem;
	JCheckBoxMenuItem enemyItem;
	JCheckBoxMenuItem foodItem;
	JCheckBoxMenuItem exitItem;

	public MapPanel(JFrame framm) {

		super(framm);
		setLayout(null);
		setFocusable(true);
		addMouseListener(new MapClicks());
		setDoubleBuffered(true);
		setBackground(Color.LIGHT_GRAY);
		setOptions();
		modo = 0;
	}

	private void setOptions() {

		menubar = new JMenuBar();

		file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		action = new JMenu("Action");
		action.setMnemonic(KeyEvent.VK_A);

		JMenuItem eMenuItem = new JMenuItem("Exit");
		eMenuItem.setMnemonic(KeyEvent.VK_E);
		eMenuItem.setToolTipText("Exit application");
		eMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				fram.reset();
				fram.toStart();
			}
		});

		saveItem = new JMenuItem("Save");
		saveItem.setToolTipText("Save map");
		saveItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if (currentEnemy == fram.gm.getDRnum() && currentHero == 1
						&& currentFood == 1 && currentExit == 1) {

					int sve = 0;
					fram.gm.place(fram.gm.getEA(), 2, fram.gm.getHR().getX(),
							fram.gm.getHR().getY());
					SaveLoad sv = new SaveLoad();
					try {

						sve = sv.save(fram.gm);

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (sve == 0) {
						fram.reset();
						fram.toStart();
					}
				}
				else{
					JOptionPane.showMessageDialog(getRootPane(), "Componentes insufcientes");
				}
			}
		});

		wallItem = new JCheckBoxMenuItem("Wall");
		wallItem.setState(true);
		wallItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				modo = 0;
				uncheckThem(modo);
			}
		});

		heroItem = new JCheckBoxMenuItem("Hero");
		heroItem.setState(false);
		heroItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				modo = 1;
				uncheckThem(modo);
			}
		});

		enemyItem = new JCheckBoxMenuItem("Enemy");
		enemyItem.setState(false);
		enemyItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				modo = 2;
				uncheckThem(modo);
			}
		});

		foodItem = new JCheckBoxMenuItem("Food");
		foodItem.setState(false);
		foodItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				modo = 3;
				uncheckThem(modo);
			}
		});

		exitItem = new JCheckBoxMenuItem("Exit");
		exitItem.setState(false);
		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				modo = 4;
				uncheckThem(modo);
			}
		});

		action.add(wallItem);
		action.add(heroItem);
		action.add(enemyItem);
		action.add(foodItem);
		action.add(exitItem);

		file.add(saveItem);
		file.add(eMenuItem);

		menubar.add(file);
		menubar.add(action);
	}

	private void uncheckThem(int modo) {

		wallItem.setState(false);
		exitItem.setState(false);
		enemyItem.setState(false);
		foodItem.setState(false);
		heroItem.setState(false);

		switch (modo) {
		case 0:
			wallItem.setState(true);
			break;

		case 1:
			heroItem.setState(true);
			break;
		case 2:
			enemyItem.setState(true);
			break;
		case 3:
			foodItem.setState(true);
			break;
		case 4:
			exitItem.setState(true);
			break;
		default:
			break;
		}
	}

	void StartMapping() {
		requestFocusInWindow();
		fram.setResizable(true);
		fram.gm.startBase();
		labi = fram.gm.getMaze();
		fram.setJMenuBar(menubar);
		currentEnemy = 0;
		currentHero = 0;
		currentFood = 0;
		currentExit = 0;
		modo = 0;
		uncheckThem(0);
	}

	public void paint(Graphics g) {

		setDimensions();
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		drawGame(g2d);
	}

	private int getX(int x) {

		return (x - stx) / sqSize;

	}

	private int getY(int y) {

		return (y - sty) / sqSize;

	}

	private class MapClicks implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			int x = getX(arg0.getX());
			int y = getY(arg0.getY());
			if (x < 0 || x >= fram.gm.getWidth() || y < 0
					|| y >= fram.gm.getHeight()) {
				return;
			}
			System.out.println(modo);
			switch (modo) {

			case 0:
				if (fram.gm.unitEmpty(x, y)) {
					labi[y][x].setChar1(fram.gm.getWL());
				} else if (labi[y][x].getChar1() instanceof Wall && y > 0
						&& y < (fram.gm.getHeight() - 1) && x > 0
						&& x < (fram.gm.getWidth() - 1)) {
					labi[y][x].setChar1(fram.gm.getEM());
				}
				break;
			case 1:
				if (currentHero < 1) {
					if (fram.gm.place(fram.gm.getHR(), 1, x, y)) {
						currentHero++;
					}
				} else if (labi[y][x].getChar1() instanceof Hero) {
					fram.gm.unplace(fram.gm.getHR(), 1, x, y);
					currentHero--;

				}
				break;
			case 2:
				if (currentEnemy < fram.gm.getDRnum()
						&& fram.gm.unitEmpty(x, y) || currentEnemy == 0) {
					System.out.println("curent enemy = " + currentEnemy);

					if (fram.gm.place(fram.gm.getDR(currentEnemy), 1, x, y)) {
						currentEnemy++;
					}
				} else if (labi[y][x].getChar1() == fram.gm
						.getDR(currentEnemy - 1)) {
					fram.gm.unplace(fram.gm.getDR(currentEnemy - 1), 1, x, y);
					currentEnemy--;

				}
				break;
			case 3:
				if (currentFood < 1) {
					if (fram.gm.place(fram.gm.getSW(), 3, x, y)) {
						currentFood++;
					}
				} else if (labi[y][x].getItem() instanceof Sword) {
					fram.gm.unplace(fram.gm.getSW(), 3, x, y);
					currentFood--;

				}
				break;
			case 4:
				if (currentExit < 1) {
					if (fram.gm.place(fram.gm.getEX(), 1, x, y)) {
						currentExit++;
					}
				} else if (labi[y][x].getChar1() instanceof Exit) {
					fram.gm.unplace(fram.gm.getEX(), 1, x, y);
					currentExit--;

				}
				break;
			default:
				break;

			}
			repaint();

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

}
