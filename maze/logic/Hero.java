package maze.logic;

public class Hero extends Entity {

	boolean alive, armed;

	public Hero() {
		alive = true;
		armed = false;
	}

	void refresh() {
		if (!alive)
			token = '*';
		else if (armed)
			token = 'A';
		else
			token = 'H';

	}

}
