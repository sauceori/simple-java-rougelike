/**
 * Class Goblin contains the fields and methods needed to represent an Enemy
 * with a Sword weapon
 * @author Ethan Hopkins
 *
 */
public class Goblin extends Enemy {

	/**
	 * Constructor for a Goblin object, initializes the Goblin's name and
	 * knife as parameterized, and the type as "Goblin" 
	 * @param theName the Goblin's name
	 * @param theSword the Goblin's sword
	 */
	public Goblin(String theName, Sword theSword) {
		super(theName, "Goblin", 3, theSword);
	}
}	
