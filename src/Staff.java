/**
 * Class Staff contains the methods needed to represent a staff object, a
 * weapon of type "Staff" with a field for the magical force used in damage
 * calculation
 * @author Ethan Hopkins
 *
 */
public class Staff extends Weapon implements Magic
{
	private int magicForce;	//the magical force

	/**
	 * Constructor for a Staff object, initializes the Weapon type as a
	 * "Staff" with the specified strength and magical force
	 * @param theStrength the strength value for the Staff
	 * @param theForce the magical force value for the Staff
	 */
	public Staff(int theStrength, int theForce) {
		super("Staff", theStrength);
		this.magicForce = theForce;
	}

	/**
	 * Method getMagicalForce is the accesor for this instance of the magic
	 * force variable
	 * @return the Staff's magical force
	 */
	public int getMagicalForce() {
		return this.magicForce;
	}

	/**
	 * Method equals returns true if the instance variables of obj are the
	 * same as the current object, including the magicForce and those
	 * inherited from Weapon
	 * @return true if obj is equal; else false
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Staff)) {
			return false;
		}

		Staff other = (Staff) obj;

		if(this.getMagicalForce() == other.getMagicalForce()) {
			return super.equals(obj);
		}
		return false;
	}

	/**
	 * Method copy returns a new Staff object with the same instance 
	 * variables
	 * @return a copy of the Staff
	 */
	public Staff copy() {
		return new Staff(this.getStrength(), this.getMagicalForce());
	}
}
