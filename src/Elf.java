/**
 * Class Elf contains the fields and methods needed to represent a hero
 * character with a bow weapon and magic force
 * @author Ethan Hopkins
 *
 */
public class Elf extends Hero implements Magic
{
	private int magicForce;	//the magical force

	/**
	 * Constructor for an Elf object, initializes the character's name, bow
	 * and magical force as is parameterized, and the type as "Elf"
	 * @param theName the Elf's name
	 * @param theBow the Elf's Bow
	 * @param theForce the Elf's magical force
	 */
	public Elf(String theName, Bow theBow, int theForce) {
		super(theName, "Elf", theBow);
		this.magicForce = theForce;
	}

	/**
	 * Method getBow is the accessor for the current Elf's weapon, and
	 * returns it as a Bow
	 * @return the Elf's Bow
	 */
	public Bow getBow() {
		return (Bow) this.getWeapon();
	}

	/**
	 * Method getMagicalForce is the accessor for this instance of the magic
	 * force variable
	 * @return the Elf's magical force
	 */
	public int getMagicalForce() {
		return this.magicForce;
	}

	/**
	 * Method equals returns true if the instance variables of obj are the
	 * same as the current object, including the magicForce, Bow, and
	 * others inherited from Hero
	 * @return true if obj is equal; else false
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Elf)) {
			return false;
		}

		Elf other = (Elf) obj;

		if(this.getBow().equals(other.getBow())) {
			return super.equals(obj);
		}
		return false;
	}
}
