/**
 * Class Lic contains the fields and methods needed to represent an Enemy with
 * a Staff weapon
 * @author Ethan Hopkins
 *
 */
public class Lich extends Enemy {

	/**
	 * Constructor for a Lich object, initializes the Lich's name and staff
	 * as parameterized, and the type as "Lich"
	 * @param theName the Lich's name
	 * @param theSword the Lich's Staff
	 */
	public Lich(String theName, Staff theStaff) {
		super(theName, "Lich", 9, theStaff);
	}
}
