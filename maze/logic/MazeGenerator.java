package maze.logic;

import java.util.Random;
import java.util.Stack;

public class MazeGenerator {
	boolean saida, dragao, espada, heroi;
	public Game gm;

	public MazeGenerator(int x, int y, int mode) {
		gm = new Game(x, y);
		saida = false;
		dragao = false;
		espada = false;
		heroi = false;
	}

	public int createMap() {

		Random rd = new Random();

		int si = 0, sj = 0, ti = 0, tj = 0;

		for (int j = 0; j < gm.WIDTH; j++) {
			for (int i = 0; i < gm.LENGHT; i++) {
				if (i == 0 || j == 0 || i == gm.LENGHT - 1 || j == gm.WIDTH - 1) {
					gm.MAZE[j][i] = 'X';
				} else
					gm.MAZE[j][i] = '.';
			}
		}

		do {
			switch (rd.nextInt(4)) {

			case 0:
				si = 0;
				sj = rd.nextInt(gm.WIDTH);
				break;
			case 1:
				si = gm.LENGHT - 1;
				sj = rd.nextInt(gm.WIDTH);
				break;
			case 2:
				sj = 0;
				si = rd.nextInt(gm.LENGHT);
				break;
			case 3:
				sj = gm.WIDTH - 1;
				si = rd.nextInt(gm.LENGHT);
				break;
			default:
				break;
			}
			if (camAberto(si, sj)) {
				gm.MAZE[sj][si] = 'S';
				saida = true;
			
			}

		} while (!saida);

		createPath(sj, si);

		do {
			ti = rd.nextInt(gm.LENGHT - 1) + 1;
			tj = rd.nextInt(gm.WIDTH - 1) + 1;
			if (gm.MAZE[tj][ti] == ' ')

				heroi = true;
			else

				heroi = false;

		} while (!heroi
				|| (Math.abs(ti - si) < gm.LENGHT / 2 && Math.abs(tj - sj) < gm.WIDTH / 2));

		
		gm.HR.x = ti;
		gm.HR.y =  tj;
		for(int i=0;i < gm.DRnum;i++){
		do {
			ti = rd.nextInt(gm.LENGHT - 1) + 1;
			tj = rd.nextInt(gm.WIDTH - 1) + 1;
			if (gm.MAZE[tj][ti] == ' ')

				dragao = true;
			else

				dragao = false;

		} while (!dragao
				|| (Math.abs(ti - gm.HR.x) < gm.LENGHT / 6 && Math.abs(tj - gm.HR.y) < gm.WIDTH / 6));
		
		gm.dragons[i].x = ti;
		gm.dragons[i].y = tj;
		}

		do {
			ti = rd.nextInt(gm.LENGHT - 1) + 1;
			tj = rd.nextInt(gm.WIDTH - 1) + 1;
			if (gm.MAZE[tj][ti] == ' ')
				espada = true;
			else
				espada = false;

		} while (!espada
				|| (Math.abs(ti - gm.HR.x) < gm.LENGHT / 3 && Math.abs(tj - gm.HR.y) < gm.WIDTH / 3));
		
		gm.SW.x=ti;
		gm.SW.y=tj;
		return 0;

	}

	boolean camAberto(int tx, int ty) {

		if (cpLim(ty - 1, tx, '.')) {
			return true;
		}

		if (cpLim(ty + 1, tx, '.')) {
			return true;
		}
		if (cpLim(ty, tx + 1, '.')) {
			return true;
		}
		if (cpLim(ty, tx - 1, '.')) {
			return true;
		}

		return false;
	}

	boolean cpLim(int tj, int ti, char eq) {

		if (tj >= 0 && tj < gm.WIDTH && ti >= 0 && ti < gm.LENGHT)
			if (gm.MAZE[tj][ti] == eq) {
				return true;
			}

		return false;

	}

	void createPath(int sj, int si) {

		Stack<Par> caminho = new Stack<Par>();

		int j = sj, i = si;
		Random rd = new Random();
		boolean moved = false;

		do {

			if (hasPath(j, i)) {

				do {

					switch (rd.nextInt(4)) {

					case 0:
						if (cpLim(j - 1, i, '.')) {

							gm.MAZE[j - 1][i] = ' ';
							gm.MAZE[j - 1][i - 1] = 'X';
							gm.MAZE[j - 1][i + 1] = 'X';
							j = j - 1;
							
							caminho.push(new Par(i, j));
							moved = true;

							if (cpLim(j - 1, i, '.')) {

								gm.MAZE[j - 1][i] = ' ';
								if (cpLim(j - 1, i + 2, ' '))
									if (rd.nextInt(8) != 0)
										gm.MAZE[j - 1][i + 1] = 'X';
								if (cpLim(j - 1, i - 2, ' '))
									if (rd.nextInt(8) != 0)
										gm.MAZE[j - 1][i - 1] = 'X';

								j = j - 1;
								
								caminho.push(new Par(i, j));

							}

						}
						break;
					case 1:
						if (cpLim(j + 1, i, '.')) {

							gm.MAZE[j + 1][i] = ' ';
							gm.MAZE[j + 1][i - 1] = 'X';
							gm.MAZE[j + 1][i + 1] = 'X';
							j = j + 1;
							

							caminho.push(new Par(i, j));
							moved = true;

							if (cpLim(j + 1, i, '.')) {

								gm.MAZE[j + 1][i] = ' ';
								if (cpLim(j + 1, i + 2, ' '))
									if (rd.nextInt(8) != 0)
										gm.MAZE[j + 1][i + 1] = 'X';
								if (cpLim(j + 1, i - 2, ' '))
									if (rd.nextInt(8) != 0)
										gm.MAZE[j + 1][i - 1] = 'X';

								j = j + 1;
							
								caminho.push(new Par(i, j));

							}

						}
						break;

					case 2:
						if (cpLim(j, i + 1, '.')) {

							gm.MAZE[j][i + 1] = ' ';
							gm.MAZE[j - 1][i + 1] = 'X';
							gm.MAZE[j + 1][i + 1] = 'X';
							
							i = i + 1;
							caminho.push(new Par(i, j));
							moved = true;

							if (cpLim(j, i + 1, '.')) {

								gm.MAZE[j][i + 1] = ' ';
								if (cpLim(j - 2, i + 1, ' '))
									if (rd.nextInt(8) != 0)
										gm.MAZE[j - 1][i + 1] = 'X';
								if (cpLim(j + 2, i + 1, ' '))
									if (rd.nextInt(8) != 0)
										gm.MAZE[j + 1][i + 1] = 'X';

								
								i = i + 1;
								caminho.push(new Par(i, j));

							}

						}
						break;
					case 3:
						if (cpLim(j, i - 1, '.')) {

							gm.MAZE[j][i - 1] = ' ';
							gm.MAZE[j - 1][i - 1] = 'X';
							gm.MAZE[j + 1][i - 1] = 'X';
							
							i = i - 1;
							caminho.push(new Par(i, j));
							moved = true;

							if (cpLim(j, i - 1, '.')) {

								gm.MAZE[j][i - 1] = ' ';
								if (cpLim(j - 2, i - 1, ' '))
									if (rd.nextInt(8) != 0)
										gm.MAZE[j - 1][i - 1] = 'X';
								if (cpLim(j + 2, i - 1, ' '))
									if (rd.nextInt(8) != 0)
										gm.MAZE[j + 1][i - 1] = 'X';

								
								i = i - 1;
								caminho.push(new Par(i, j));

							}

						}
						break;

					}
				} while (!moved);

			} else {

				caminho.pop();
				if (!caminho.empty()) {
					i = caminho.peek().getx();
					j = caminho.peek().gety();

				}

			}
			moved = false;
		} while (!caminho.empty());

		boolean side = true;
		char check;

		if (gm.MAZE[1][1] == ' ')
			check = 'X';
		else
			check = ' ';

		for (int a = 2; a < gm.LENGHT - 1; a++) {
			if (gm.MAZE[1][a] == check) {
				if (check == ' ')
					check = 'X';
				else
					check = ' ';
			}

			else
				side = false;

		}
		if (side == true) {

			for (int a = 1; a < gm.WIDTH - 1; a++) {

				if (gm.MAZE[1][a - 1] == ' ' && gm.MAZE[1][a + 1] == ' '
						&& gm.MAZE[2][a] == ' ' && rd.nextInt(4) != 1) {
					gm.MAZE[1][a] = ' ';
					gm.MAZE[2][a] = 'X';

				}

			}

		}

		side = true;

		if (gm.MAZE[gm.WIDTH - 2][1] == ' ')
			check = 'X';
		else
			check = ' ';

		for (int a = 2; a < gm.LENGHT - 2; a++) {
			if (gm.MAZE[gm.WIDTH - 2][a] == check) {
				if (check == ' ')
					check = 'X';
				else
					check = ' ';
			}

			else
				side = false;

		}
		if (side == true) {

			for (int a = 1; a < gm.LENGHT - 2; a++) {

				if (gm.MAZE[gm.WIDTH - 2][a - 1] == ' '
						&& gm.MAZE[gm.WIDTH - 2][a + 1] == ' '
						&& gm.MAZE[gm.WIDTH - 3][a] == ' '
						&& rd.nextInt(4) != 1) {
					gm.MAZE[gm.WIDTH - 2][a] = ' ';
					gm.MAZE[gm.WIDTH - 3][a] = 'X';

				}

			}

		}
		side = true;

		if (gm.MAZE[1][1] == ' ')
			check = 'X';
		else
			check = ' ';

		for (int a = 2; a < gm.WIDTH - 1; a++) {
			if (gm.MAZE[a][1] == check) {
				if (check == ' ')
					check = 'X';
				else
					check = ' ';
			}

			else
				side = false;

		}
		if (side == true) {

			for (int a = 1; a < gm.WIDTH - 1; a++) {

				if (gm.MAZE[a - 1][1] == ' ' && gm.MAZE[a + 1][1] == ' '
						&& gm.MAZE[a][2] == ' ' && rd.nextInt(4) != 1) {
					gm.MAZE[a][1] = ' ';
					gm.MAZE[a][2] = 'X';

				}

			}

		}
		side = true;

		if (gm.MAZE[1][gm.LENGHT - 2] == ' ')
			check = 'X';
		else
			check = ' ';

		for (int a = 2; a < gm.WIDTH - 1; a++) {
			if (gm.MAZE[a][gm.LENGHT - 2] == check) {
				if (check == ' ')
					check = 'X';
				else
					check = ' ';
			}

			else
				side = false;

		}
		if (side == true) {

			for (int a = 1; a < gm.WIDTH - 1; a++) {

				if (gm.MAZE[a - 1][gm.LENGHT - 2] == ' '
						&& gm.MAZE[a + 1][gm.LENGHT - 2] == ' '
						&& gm.MAZE[a][gm.LENGHT - 3] == ' '
						&& rd.nextInt(4) != 1) {
					gm.MAZE[a][gm.LENGHT - 2] = ' ';
					gm.MAZE[a][gm.LENGHT - 3] = 'X';

				}

			}

		}

	}

	boolean hasPath(int j, int i) {

		if (cpLim(j - 1, i, '.'))
			return true;

		if (cpLim(j + 1, i, '.'))
			return true;

		if (cpLim(j, i + 1, '.'))
			return true;

		if (cpLim(j, i - 1, '.'))
			return true;

		return false;

	}

}
