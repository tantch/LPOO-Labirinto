package maze.logic;

import java.io.Serializable;

/**
 * The Class Unit.
 */
public class Unit implements Serializable {

	private static final long serialVersionUID = 1L;
	
	Entity char1;
	
	Entity char2;
	
	Entity item;
	
	char trshToken1 = '.';
	
	char trshToken2 = '.';

	/**
	 * Instantiates a new unit.
	 *
	 * @param it the it entity
	 * @param gm the game
	 */
	Unit(Entity it, Game gm) {
		char1 = it;
		char2 = gm.EM;
		item = gm.EM;
	}

	/**
	 * Gets the char1.
	 *
	 * @return the char1
	 */
	public Entity getChar1() {
		return char1;
	}

	/**
	 * Sets the char1.
	 *
	 * @param char1 the new char1
	 */
	public void setChar1(Entity char1) {
		this.char1 = char1;
	}

	/**
	 * Gets the char2.
	 *
	 * @return the char2
	 */
	public Entity getChar2() {
		return char2;
	}

	/**
	 * Sets the char2.
	 *
	 * @param char2 the new char2
	 */
	public void setChar2(Entity char2) {
		this.char2 = char2;
	}

	/**
	 * Gets the item.
	 *
	 * @return the item
	 */
	public Entity getItem() {
		return item;
	}

	/**
	 * Sets the item.
	 *
	 * @param item the new item
	 */
	public void setItem(Entity item) {
		this.item = item;
	}

	/**
	 * Gets the trsh token1.
	 *
	 * @return the trsh token1
	 */
	public char getTrshToken1() {
		return trshToken1;
	}

	/**
	 * Sets the trsh token1.
	 *
	 * @param trshToken1 the new trsh token1
	 */
	public void setTrshToken1(char trshToken1) {
		this.trshToken1 = trshToken1;
	}

	/**
	 * Gets the trsh token2.
	 *
	 * @return the trsh token2
	 */
	public char getTrshToken2() {
		return trshToken2;
	}

	/**
	 * Sets the trshtoken2.
	 *
	 * @param trshToken2 the new trshtoken2
	 */
	public void setTrshToken2(char trshToken2) {
		this.trshToken2 = trshToken2;
	}

	
	
	/**
	 * Gets the token.
	 *
	 * @return the token
	 */
	public char getToken() {
		if (char1 instanceof Empty) {
			if (item instanceof Empty || item.invisible) {
				if (trshToken1 != '.') {
					return trshToken1;
				} else {
					return ' ';
				}
			} else {
				return item.token;
			}
		} else {
			return char1.token;
		}
	}
}
