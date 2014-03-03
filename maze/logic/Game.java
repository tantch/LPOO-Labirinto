package maze.logic;

import java.util.Random;

public class Game {

	public char MAZE[][];
	public int WIDTH, LENGHT, DRnum;
	Dragon[] dragons;
	Sword SW;
	Hero HR;

	public Game(int w, int l) {
		WIDTH = w;
		LENGHT = l;

		MAZE = new char[WIDTH][LENGHT];
		DRnum = 5;
		dragons = new Dragon[DRnum];
		for (int i = 0; i < DRnum; i++)
			dragons[i] = new Dragon();
		SW = new Sword();
		HR = new Hero();

	}

	public void refresh() {

		SW.refresh();
		MAZE[SW.y][SW.x] = SW.token;

		for (int i = 0; i < DRnum; i++) {
			dragons[i].refresh();
			MAZE[dragons[i].y][dragons[i].x] = dragons[i].token;
		}
		HR.refresh();
		MAZE[HR.y][HR.x] = HR.token;

	}

	public int action(String st) {
		int t = 0;
		moveDragons();
		switch (st) {

		case "a":
			t = moverPlr(-1, 0);

			break;
		case "s":
			t = moverPlr(0, 1);

			break;
		case "d":
			t = moverPlr(1, 0);

			break;
		case "w":
			t = moverPlr(0, -1);

			break;
		case "c":
			t = moverPlr(0, 0);

			break;
		case "p":
			return 0;

		default:

			break;
		}

		if (t == 1)
			return 0;
		return 1;
	}

	public int moverPlr(int dx, int dy) {

		int plrx = HR.x + dx, plry = HR.y + dy;
		MAZE[HR.y][HR.x] = ' ';
		if (MAZE[plry][plrx] == 'S' && HR.armed)
			return 1;

		if (MAZE[plry][plrx] == 'X'
				|| (MAZE[plry][plrx] == 'S' && !HR.armed || MAZE[plry][plrx] == 'd')) {
			return 0;
		}
		if (MAZE[plry][plrx] == 'E') {
			HR.armed = true;
			SW.pickedUp = true;
		}

		if (nearDragon(plrx, plry)) {
			if (HR.armed)
				killDragon(plrx, plry);
			else if (killHero(plrx, plry))
				return 1;

		}

		HR.x = plrx;
		HR.y = plry;

		return 0;
	}

	public boolean nearDragon(int x, int y) {

		for (int i = 0; i < DRnum; i++) {
			if (x == dragons[i].x && y - 1 == dragons[i].y)
				return true;
			if (x == dragons[i].x && y + 1 == dragons[i].y)
				return true;
			if (x + 1 == dragons[i].x && y == dragons[i].y)
				return true;
			if (x - 1 == dragons[i].x && y == dragons[i].y)
				return true;
			if (x == dragons[i].x && y == dragons[i].y)
				return true;
		}
		return false;
	}

	public boolean killHero(int x, int y) {
		for (int i = 0; i < DRnum; i++) {
			if (x == dragons[i].x && y - 1 == dragons[i].y
					&& !dragons[i].sleeping) {
				HR.alive = false;
				return true;
			}
			if (x == dragons[i].x && y + 1 == dragons[i].y
					&& !dragons[i].sleeping) {
				HR.alive = false;
				return true;
			}
			if (x + 1 == dragons[i].x && y == dragons[i].y
					&& !dragons[i].sleeping) {
				HR.alive = false;
				return true;
			}
			if (x - 1 == dragons[i].x && y == dragons[i].y
					&& !dragons[i].sleeping) {
				HR.alive = false;
				return true;
			}

		}
		return false;

	}

	public int killDragon(int x, int y) {
		for (int i = 0; i < DRnum; i++) {
			if (x == dragons[i].x && y - 1 == dragons[i].y)
				dragons[i].slayn = true;
			if (x == dragons[i].x && y + 1 == dragons[i].y)
				dragons[i].slayn = true;
			if (x + 1 == dragons[i].x && y == dragons[i].y)
				dragons[i].slayn = true;
			if (x - 1 == dragons[i].x && y == dragons[i].y)
				dragons[i].slayn = true;
			if (x == dragons[i].x && y == dragons[i].y)
				dragons[i].slayn = true;
		}
		return 1;
	}

	public int moveDragons() {
		Random rd = new Random();
		int dx, dy;
		boolean moved = false;
		for (int i = 0; i < DRnum; i++) {
			moved = false;

			MAZE[dragons[i].y][dragons[i].x] = ' ';

			if (!dragons[i].slayn && !dragons[i].sleeping) {

				do {
					dx = rd.nextInt(3) - 1;
					dy = rd.nextInt(3) - 1;

					if (dx != 0 && dy != 0) {
						if (rd.nextInt(2) == 1)
							dx = 0;
						else
							dy = 0;
					}

					if (!(MAZE[dragons[i].y + dy][dragons[i].x + dx] == 'X'
							|| MAZE[dragons[i].y + dy][dragons[i].x + dx] == 'S' || (dragons[i].x
							+ dx == dragons[i].x && dragons[i].y + dy == dragons[i].y)))
						moved = true;

					if (dx == 0 && dy == 0)
						moved = false;

				} while (!moved);

				dragons[i].x = dragons[i].x + dx;
				dragons[i].y = dragons[i].y + dy;
			}
		}
		return 0;

	}

}
