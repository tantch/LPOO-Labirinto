package maze.logic;

public class Game {

	public char MAZE[][];
	int WIDTH, LENGHT;
	Dragon DR;
	Sword SW;

	Hero HR;

	public Game(int w, int l) {
		WIDTH = w;
		LENGHT = l;

		MAZE = new char[WIDTH][LENGHT];

		DR = new Dragon();
		SW = new Sword();
		HR = new Hero();

	}

	public Game(int n) {
		WIDTH = n;
		LENGHT = n;

		MAZE = new char[WIDTH][LENGHT];

		DR = new Dragon();
		SW = new Sword();
		HR = new Hero();

	}

	

}
