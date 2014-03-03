package maze.cli;

import java.util.Scanner;

import maze.logic.MazeGenerator;

public class Main {

	private static MazeGenerator mg;

	public static void main(String[] args) {

		String inp;
		int o = 1;

		Scanner sc = new Scanner(System.in);

		while (!sc.hasNextInt()) {
			sc.next();
		}

		int a = sc.nextInt();
		int b = sc.nextInt();
		mg = new MazeGenerator(a, b, 0);

		mg.createMap();

		do {

			inp = sc.nextLine();

			o = mg.gm.action(inp);

			print();

		} while (o == 1);

		sc.close();

	}

	public static void print() {

		mg.gm.refresh();
		
		for (int j = 0; j < mg.gm.WIDTH; j++) {
			for (int i = 0; i < mg.gm.LENGHT; i++) {
				System.out.print(mg.gm.MAZE[j][i] + " ");
			}
			System.out.println();
		}

	}

}
