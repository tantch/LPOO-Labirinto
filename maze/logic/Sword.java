package maze.logic;

/**
 * The Class Sword.
 */
public class Sword extends Entity {

	boolean pickedUp, onEagle;

	/**
	 * Instantiates a new sword.
	 */
	public Sword() {
		pickedUp = false;
		onEagle = false;
		token = 'E';
	}

	/**
	 *  Interacts the sword with the rest of the game
	 * 
	 * @param gm the game
	 */
	public void interact(Game gm) {

		if (pickedUp) {
			return;
		}
		if (gm.onTop(x, y, Empty.class, 1)) {
			pickedUp = false;
			invisible = false;

		}
		if (!invisible) {

			if (gm.onTop(x, y, Eagle.class, 2)) {
				invisible = true;
				onEagle = true;
			}
			if (gm.onTop(x, y, Hero.class, 1)) {
				pickedUp = true;
				invisible = true;

			}

		}
	}

	/**
	 * Moves the sword alongside the eagle or hero, depending on which one has it.
	 *
	 * @param gm the game
	 */
	public void move(Game gm) {
		if (onEagle) {
			gm.MAZE[y][x].item = gm.EM;
			x = gm.EA.x;
			y = gm.EA.y;
			gm.MAZE[y][x].item = this;
			return;
		}
		if (pickedUp) {
			gm.MAZE[y][x].item = gm.EM;
			x = gm.HR.x;
			y = gm.HR.y;
			gm.MAZE[y][x].item = this;
			return;
		}
	}

	/**
	 * Gets the pickedUp boolean value.
	 *
	 * @return the picked up
	 */
	public boolean getPickedUp(){
		return pickedUp;
	}
	
	/**
	 * Gets the onEagle boolean value.
	 *
	 * @return the on eagle
	 */
	public boolean getOnEagle(){
		return onEagle;
	}
}

