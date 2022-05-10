/**
 * Class Halfling contains the fields and methods needed to represent a Hero
 * character with a Sword Weapon and a hunger mechanic
 * @author Ethan Hopkins
 *
 */
public class Halfling extends Hero
{
	private int hunger;	//the Halfling's hunger

	/**
	 * Constructor for a Halfling object, initializes the Hero's name and
	 * Sword as parameterized, the type as "Halfling", and the hunger as 20
	 * @param theName the Halfling's name
	 * @param theSword the Halfling's Sword
	 */
	public Halfling(String theName, Sword theSword) {
		super(theName, "Halfling", theSword);
		this.hunger = 20;
	}

	/**
	 * Method getSword is the accessor for the Halfling's weapon, and 
	 * returns it as a Sword
	 * @return the Halfling's Sword
	 */
	public Sword getSword() {
		return (Sword) this.getWeapon();
	}

	/**
	 * Method getHunger is the accessor for the Halfling's hunger value
	 * @return the Halfling's hunger value
	 */
	public int getHunger() {
		return this.hunger;
	}

	/**
	 * Method eat reduces the Halfling's hunger value by half, rounded down
	 */
	public void eat() {
		this.hunger = this.hunger / 2;
	}

	/**
	 * Method gainXP calls the gainXP in the superclass and then increases
	 * the Halfling's hunger level by half
	 * @param moreXP the experience points to be gained
	 */
	public void gainXP(int moreXP) {
		super.gainXP(moreXP);
		this.hunger += this.getHunger() / 2;
	}

	/**
	 * Method equals returns true if the instance variables of obj are the
	 * same as the current object, including those inherited from Hero but
	 * not the hunger value
	 * @return true if obj is equal; else false
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Halfling) {
			return super.equals(obj);
		}
		return false;
	}
}
