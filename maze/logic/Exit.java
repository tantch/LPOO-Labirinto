package maze.logic;

// TODO: Auto-generated Javadoc
/**
 * The Class Exit.
 */
public class Exit extends Entity{
	
	
	boolean closed;
	
	/**
	 * Instantiates a new exit.
	 */
	public Exit(){
		closed=true;
		token='S';
	}
	
	/**
	 * Gets the closed.
	 *
	 * @return the closed
	 */
	public boolean getClosed(){
		return closed;
	}
	
	/**
	 * Opens the exit.
	 */
	public void open(){
		invisible=false;
	}
	
	/**
	 * Interacts the exit with the rest of the game.
	 * @param gm the game
	 */
	public void interact(Game gm){
		if(gm.dragonsDead() && invisible==true){
			invisible=false;
			
		}
		
	}

}
