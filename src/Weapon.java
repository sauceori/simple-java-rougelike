//package proj2;

/**
 * Class Weapon contains the fields and methods used to represent the weapons
 * used by Enemy and Hero objects
 * @author Ethan Hopkins
 *
 */
public class Weapon {
	
	private String type;	//the weapon type
	private int strength;	//the weapon strength
	
	/**
	 * Default contstructor for a Weapon object, assigns default values to
	 * the instance variables
	 */
	public Weapon() {
		this.type = "Bare Hands";
		this.strength = 25;
	}
	
	/**
	 * Parameterized constructor for a Weapon object, assigns the instance
	 * variables with the parameters
	 * @param theType weapon type
	 * @param theStrength weapon strength
	 */
	public Weapon(String theType, int theStrength) {
		this.type = StringHelper.capitalize(theType);
		this.strength = theStrength;
		if(theStrength < 1) {
			this.strength = 25;
		}
	}
	
	/**
	 * Method getType is the accessor for this instance of the type
	 * variable
	 * @return the weapon type
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Method getStrength is the accessor for this instance of the strength
	 * variable
	 * @return the weapon strength
	 */
	public int getStrength() {
		return this.strength;
	}
	
	/**
	 * Method powerUp increases the weapon's strength by a quarter of its
	 * current value
	 */
	public void powerUp() {
		this.strength += this.strength / 4;
	}
	
	/**
	 * Method equals returns a boolean value based on whether the current
	 * weapon is equal to the parameterized object
	 * @param obj the object to be compared to this instance of weapon
	 * @return true if the two weapons are the same; else false
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Weapon)) {
			return false;	//wrong type
		}

		Weapon other = (Weapon) obj;	//cast

		if(this.getStrength() != other.getStrength())
			return false;	//strength differs
		else if(!this.type.equals(other.getType()))
			return false;	//type differs
		return true;	//equal weapons
	}
	
	/**
	 * Method toString returns a string containing the values of the
	 * instance variables type and strength
	 * @return the string with the weapon info
	 */
	@Override
	public String toString() {
		return this.getType() + " of strength " + this.getStrength();
	}
	
	/**
	 * Method copy returns a copy of the current weapon object
	 * @return a copy of the weapon
	 */
	public Weapon copy() {
		return new Weapon(this.getType(), this.getStrength());
	}
}
