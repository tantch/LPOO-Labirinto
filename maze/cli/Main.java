package maze.cli;

import java.util.Scanner;

import maze.logic.Game;

public class Main {

	private static Game gm;

	public static void main(String[] args) {

		String inp;
		int o = 1;

		Scanner sc = new Scanner(System.in);

		System.out.println("Inserir altura do labirinto.");
		
		while (!sc.hasNextInt()) {
			sc.next();
		}

		int a = sc.nextInt();
		
		System.out.println("Inserir largura do labirinto.");
		
		while (!sc.hasNextInt()) {
			sc.next();
		}	
		int b = sc.nextInt();
		
		System.out.println("Inserir numero de dragoes.");
		
		while (!sc.hasNextInt()) {
			sc.next();
		}	
		int nd = sc.nextInt();
		
		
		gm= new Game(a,b,nd);

		gm.start();

		do {

			inp = sc.nextLine();

			o = gm.action(inp);

			gm.print();

		} while (o == 1);

		sc.close();

	}

	

	

}
