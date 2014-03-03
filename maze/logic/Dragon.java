package maze.logic;

public class Dragon extends Entity {

	public boolean slayn, sleeping, overSword;

	public Dragon() {

		slayn = false;
		sleeping = false;	
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
