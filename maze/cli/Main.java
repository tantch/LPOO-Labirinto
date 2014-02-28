package maze.cli;

import maze.logic.MazeGenerator;

public class Main {

	public static void main(String[] args) {
		
		MazeGenerator mg= new MazeGenerator(15,15,0);
		
		mg.createMap();
		
		
		
		
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				System.out.print(mg.gm.MAZE[j][i] + " ");
			}
			System.out.println();
		}
		
		

	}

}
