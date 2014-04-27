package maze.gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import maze.logic.Dragon;
import maze.logic.Eagle;
import maze.logic.Empty;
import maze.logic.Entity;
import maze.logic.Exit;
import maze.logic.Hero;
import maze.logic.Sword;
import maze.logic.Unit;
import maze.logic.Wall;

public class GeneralPanel extends JPanel {

	MyFrame fram;
	int sqSize, stx = 0, sty = 0;
	Image hero;
	Image dragon;
	Image terrain;
	Image sword;
	Image heroArmed;
	Image eagle;
	float frame = 0;

	public GeneralPanel(JFrame fr) {

		this.fram = (MyFrame) fr;
		setLayout(null);
		setFocusable(true);
		setDoubleBuffered(true);
		ImageIcon itemp;
		itemp = new ImageIcon(this.getClass().getResource("images/hero.png"));
		hero = itemp.getImage();
		itemp = new ImageIcon(this.getClass().getResource("images/dragon.png"));
		dragon = itemp.getImage();
		itemp = new ImageIcon(this.getClass().getResource("images/floor.png"));
		terrain = itemp.getImage();
		itemp = new ImageIcon(this.getClass().getResource("images/sword.png"));
		sword = itemp.getImage();
		itemp = new ImageIcon(this.getClass().getResource(
				"images/heroArmed.png"));
		heroArmed = itemp.getImage();
		itemp = new ImageIcon(this.getClass().getResource("images/eagle.png"));
		eagle = itemp.getImage();

	}

	public void drawGame(Graphics g) {

		Unit[][] maze = fram.gm.getMaze();
		assert maze != null;

		for (int j = 0; j < fram.gm.getHeight(); j++) {
			for (int i = 0; i < fram.gm.getWidth(); i++) {
				Entity et1 = maze[j][i].getChar1();
				Entity et2 = maze[j][i].getChar2();
				Entity et3 = maze[j][i].getItem();

				if (et1 instanceof Wall) {
					drawWall(i * sqSize, j * sqSize, g);
				} else {
					drawEmpty(i * sqSize, j * sqSize, g);
				}
				if (et1 instanceof Exit) {
					if (!et1.getInvisible())
						drawExit(i, j, g);
					else
						drawWall(i * sqSize, j * sqSize, g);
				}

				if (maze[j][i].getTrshToken1() != '.'
						|| maze[j][i].getTrshToken2() != '.') {

					if (maze[j][i].getTrshToken1() == '%') {
						g.drawImage(dragon, stx + i * sqSize, sty + j * sqSize,
								stx + i * sqSize + sqSize, sty + j * sqSize
										+ sqSize, 181, 174, 222, 211, null);
					}
					if (maze[j][i].getTrshToken1() == '*') {
						g.drawImage(hero, stx + i * sqSize, sty + j * sqSize,
								stx + i * sqSize + sqSize, sty + j * sqSize
										+ sqSize, 65, 212, 98, 248, null);
					}
					if (maze[j][i].getTrshToken2() == '!') {
						g.drawImage(eagle, stx + i * sqSize, sty + j * sqSize,
								stx + i * sqSize + sqSize, sty + j * sqSize
										+ sqSize, 249, 652, 211, 693, null);
					}
					if (maze[j][i].getTrshToken1() == 'S') {
						drawExit(i, j, g);
					}

				}

				if (et3 instanceof Sword) {
					Sword swr = (Sword) et3;
					if (!swr.getInvisible())
						drawSword(i * sqSize, j * sqSize, g);
				}

				if (et1 instanceof Dragon) {
					Dragon dr = (Dragon) et1;
					int state = 0;
					if (dr.getSleeping())
						state = 1;

					drawDragon(i * sqSize, j * sqSize, g, dr.getDir(), state);
				}

				if (et2 instanceof Eagle) {
					Eagle ea = (Eagle) et2;
					if (!ea.getOnShoulder()) {
						int state = 0; // 0-normal, 1-com espada

						if (ea.getWithSword() && !ea.getOnJourney()
								&& !ea.getOnShoulder()) {
							state = 1;
						}

						drawEagle(i * sqSize, j * sqSize, g, ea.getDir(), state);
					}
				}
				if (et1 instanceof Hero) {
					Hero hr = (Hero) et1;

					if (hr.getArmed()) {
						drawHeroArmed(i * sqSize, j * sqSize, g, hr.getDir());
					} else {
						drawHero(i * sqSize, j * sqSize, g, hr.getDir());
					}

				}
			}

		}
	}

	public void drawWall(int cx, int cy, Graphics g) {
		g.drawImage(terrain, stx + cx, sty + cy, stx + cx + sqSize, sty + cy
				+ sqSize, 100, 0, 130, 31, null);

	}

	public void drawEmpty(int cx, int cy, Graphics g) {
		g.drawImage(terrain, stx + cx, sty + cy, stx + cx + sqSize, sty + cy
				+ sqSize, 67, 0, 97, 31, null);

	}

	public void drawExit(int i, int j, Graphics g) {
		int xi = 0, yi = 0, xf = 0, yf = 0;

		if (j == 0) {
			xi = 0;
			yi = 33;
			xf = 31;
			yf = 64;
		} else if (i == 0) {
			xi = 100;
			yi = 31;
			xf = 130;
			yf = 64;
		} else if (i == fram.gm.getWidth() - 1) {
			xi = 100;
			yi = 31;
			xf = 130;
			yf = 64;
		} else {
			xi = 0;
			yi = 33;
			xf = 31;
			yf = 64;
		}

		g.drawImage(terrain, stx + i * sqSize, sty + j * sqSize, stx + i
				* sqSize + sqSize, sty + j * sqSize + sqSize, xi, yi, xf, yf,
				null);

	}

	public void drawHero(int cx, int cy, Graphics g, String dir) {
		int xi = 0, xf = 0, yi = 0, yf = 0;

		if (dir.equals("down")) {
			yi = 0;
			yf = 40;

		} else if (dir.equals("up")) {
			yi = 80;
			yf = 120;

		} else if (dir.equals("right")) {
			yi = 120;
			yf = 160;

		} else if (dir.equals("left")) {
			yi = 40;
			yf = 80;

		}

		if (frame % 5 == 0) {
			xi = 0;
			xf = 40;

		}

		else if (frame % 5 == 1) {
			xi = 40;
			xf = 80;

		} else if (frame % 5 == 2) {
			xi = 80;
			xf = 120;

		} else if (frame % 5 == 3) {
			xi = 120;
			xf = 160;

		} else if (frame % 5 == 4) {
			xi = 160;
			xf = 200;

		}
		g.drawImage(hero, stx + cx, sty + cy - (sqSize / 2), stx + cx + sqSize,
				sty + cy + sqSize - (sqSize / 2), xi, yi, xf, yf, null);

	}

	public void drawHeroArmed(int cx, int cy, Graphics g, String dir) {
		int xi = 0, xf = 0, yi = 0, yf = 0;

		if (dir.equals("down")) {
			yi = 8;
			yf = 215;

		} else if (dir.equals("up")) {
			yi = 455;
			yf = 663;

		} else if (dir.equals("right")) {
			yi = 673;
			yf = 880;

		} else if (dir.equals("left")) {
			yi =223;
			yf = 432;

		}

		if (frame % 5 == 0) {
			xi = 138;
			xf = 365;

		}

		else if (frame % 5 == 1) {
			xi = 367;
			xf = 584;

		} else if (frame % 5 == 2) {
			xi = 584;
			xf = 806;

		} else if (frame % 5 == 3) {
			xi = 806;
			xf = 1027;

		} else if (frame % 5 == 4) {
			xi = 1027;
			xf = 1255;

		}
		g.drawImage(heroArmed, stx + cx, sty + cy - (sqSize / 2), stx + cx + sqSize,
				sty + cy + sqSize - (sqSize / 2), xi, yi, xf, yf, null);

	}

	public void drawDragon(int cx, int cy, Graphics g, String dir, int state) {
		// state : 0- acordado, 1-dormir
		int xi = 0, xf = 0, yi = 0, yf = 0;
		if (state == 0) {
			if (dir.equals("down")) {
				yi = 12;
				yf = 52;

			} else if (dir.equals("up")) {
				yi = 92;
				yf = 132;

			} else if (dir.equals("right")) {
				yi = 132;
				yf = 172;

			} else if (dir.equals("left")) {
				yi = 52;
				yf = 92;

			}

			if (frame % 5 == 0) {
				xi = 20;
				xf = 60;

			}

			else if (frame % 5 == 1) {
				xi = 60;
				xf = 100;

			} else if (frame % 5 == 2) {
				xi = 100;
				xf = 140;

			} else if (frame % 5 == 3) {
				xi = 140;
				xf = 180;

			} else if (frame % 5 == 4) {
				xi = 180;
				xf = 220;

			}
		} else if (state == 1) {
			xi = 683;
			yi = 88;
			xf = 722;
			yf = 128;
		}

		g.drawImage(dragon, stx + cx, sty + cy - (sqSize / 2), stx + cx
				+ sqSize, sty + cy + sqSize - (sqSize / 2), xi, yi, xf, yf,
				null);

	}

	public void drawEagle(int cx, int cy, Graphics g, String dir, int state) {
		int xi = 0, xf = 0, yi = 0, yf = 0;
		if (state == 0) { // 0-normal, 1-com espada
			if (dir.equals("down")) {
				yi = 290;
				yf = 330;

			} else if (dir.equals("up")) {
				yi = 370;
				yf = 410;

			} else if (dir.equals("right")) {
				yi = 410;
				yf = 450;

			} else if (dir.equals("left")) {
				yi = 330;
				yf = 370;

			}

			if (frame % 5 == 0) {
				xi = 0;
				xf = 40;

			}

			else if (frame % 5 == 1) {
				xi = 40;
				xf = 80;

			} else if (frame % 5 == 2) {
				xi = 80;
				xf = 120;

			} else if (frame % 5 == 3) {
				xi = 120;
				xf = 160;

			} else if (frame % 5 == 4) {
				xi = 160;
				xf = 200;

			}
		} else if (state == 1) {
			xi = 325;
			yi = 697;
			xf = 360;
			yf = 737;
		}
		g.drawImage(eagle, stx + cx, sty + cy - (sqSize / 2),
				stx + cx + sqSize, sty + cy + sqSize - (sqSize / 2), xi, yi,
				xf, yf, null);

	}

	public void drawSword(int cx, int cy, Graphics g) {

		g.drawImage(sword, stx + cx, sty + cy, stx + cx + sqSize, sty + cy
				+ sqSize, 0, 0, sword.getWidth(null), sword.getHeight(null),
				null);

	}

	public void setDimensions() {
		boolean ok = false;

		if (fram.gm.getHeight() < fram.gm.getWidth()) {
			sqSize = getWidth() / (fram.gm.getWidth());

			if (sqSize * fram.gm.getHeight() < getHeight()) {
				ok = true;
			}
			if (!ok) {
				sqSize = getHeight() / (fram.gm.getHeight());
				ok = true;
			}

		} else {
			sqSize = getHeight() / (fram.gm.getHeight());

			if (sqSize * fram.gm.getWidth() < getWidth()) {
				ok = true;
			}
			if (!ok) {
				sqSize = getWidth() / (fram.gm.getWidth());
				ok = true;
			}
		}

		stx = (getWidth() - fram.gm.getWidth() * sqSize) / 2;
		sty = (getHeight() - fram.gm.getHeight() * sqSize) / 2;

	}

}
