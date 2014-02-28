package maze.logic;

public class Sword extends Entity {

	boolean pickedUp;

	void refresh() {

		if (pickedUp)
			token = 'e';
		else
			token = 'E';

	}

}
