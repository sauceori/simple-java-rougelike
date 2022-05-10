/**
 * Class Sword contains the methods needed to represent a Sword object, a 
 * weapon of type "Sword"
 * @author Ethan Hopkins
 *
 */
public class Sword extends Weapon
{
	/**
	 * Constructor for a sword object, initializes the Weapon type as a 
	 * "Sword" with the specified strength
	 * @param theStrength the strength value for the Sword
	 */
	public Sword(int theStrength) {
		super("Sword", theStrength);
	}

	/**
	 * Method equals returns true if the instance variables of obj are the
	 * same as the current object, as inherited from Weapon
	 * @return true if obj is equal; else false
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Sword)
			return super.equals(obj);
		return false;
	}

	/**
	 * Method copy returns a copy of the current sword object
	 * @return a copy of the sword
	 */
	public Sword copy() {
		return new Sword(this.getStrength());
	}
}
