/**
 * Class HitPoints is used to represent a character with Hit Points, and
 * contains methods which set, alter, and retrieve that value
 * @author Ethan Hopkins
 *
 */
public abstract class HitPoints {
	private int hp = 0;	//the character's hit points

	/**
	 * Constructor for an object with HitPoints, initializes the HP as the
	 * character's level times 10
	 * @param theLevel the character's level
	 */
	public HitPoints(int theLevel) {
		this.setHP(theLevel * 10);
	}

	/**
	 * Method setHP is the mutator for this instance of the hp variable
	 * @param newHP the new hp value
	 */
	public void setHP(int newHP) {
		this.hp = newHP;
		if(this.hp < 0) {
			this.hp = 0;
		}
	}

	/**
	 * Method getHP is the accessor for this instance of the hp variable
	 * @return the current hp value
	 */
	public int getHP() {
		return this.hp;
	}

	/**
	 * Method loseHP subtracts from the current hp value and sets the
	 * result
	 * @param loss the number to subtract the hp by
	 */
	public void loseHP(int loss) {
		this.setHP(this.getHP() - loss);
	}

	/**
	 * Method isAlive returns determines whether or not the character with
	 * HitPoints is alive based on the hp value
	 * @return false if 0; else true
	 */
	public boolean isAlive() {
		if(this.getHP() <= 0) {
			return false;
		}
		return true;
	}
}
