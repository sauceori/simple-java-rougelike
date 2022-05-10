/**
 * Class Wizard contains the methods needed to represent a Wizard object, a
 * hero of type "Wizard" who wields a staff
 * @author Ethan Hopkins
 *
 */
public class Wizard extends Hero {

	/**
	 * Constructor for a Wizard object, initializes the name and Staff as
	 * parameterized with the type "Wizard"
	 * @param theName the name of the wizard
	 * @param theStaff the Wizard's Staff
	 */
	public Wizard(String theName, Staff theStaff) {
		super(theName, "Wizard", theStaff);
	}

	/**
	 * Method getStaff is the accessor for the current Wizard's weapon,
	 * returned as a Staff
	 * @return the Staff belonging to the Wizard
	 */
	public Staff getStaff() {
		return (Staff) this.getWeapon();
	}

	/**
	 * Method equals returns true if the instance variables and Weapon of
	 * obj are the same as the current object, including those inherited
	 * from Hero
	 * @return true if obj is equal; else false
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Wizard) {
			return super.equals(obj);
		}
		return false;
	}
}
