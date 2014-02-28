package maze.logic;

public class Dragon extends Entity {

	boolean slayn, sleeping, moving, overSword;

	public Dragon() {

		slayn = false;
		sleeping = true;
		moving = true;
		overSword = false;
	}

	void refresh() {

		if (slayn)
			token = '%';
		else if (sleeping)
			token = 'd';
		else if (overSword)
			token = 'F';
		else
			token = 'D';

	}

}
