/**
 * Class Troll contains the fields and methods needed to represent an Enemy
 * with a Bow weapon
 * @author Ethan Hopkins
 *
 */
public class Troll extends Enemy {

	/**
	 * Constructor for a Troll object, initializes the Troll's name and bow
	 * as parameterized, and the type as "Troll"
	 * @param theName the Troll's name
	 * @param theBow the Troll's bow
	 */
	public Troll(String theName, Bow theBow) {
		super(theName, "Troll", 6, theBow);
	}
}
