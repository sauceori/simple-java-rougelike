/**
 * Class Hero contains the fields and methods needed to represent the hero
 * character
 * @author Ethan Hopkins
 *
 */
public abstract class Hero extends HitPoints {
	private String name;	//hero name
	private String type;	//character type
	private int level;	//hero level
	private int xp;		//experience points
	private Weapon weapon;	//hero's weapon

	/**
	 * Default constructor for the Hero class, assigns default values to
	 * the instance variables
	 */
	public Hero() {
		super(1);
		this.name = "Hero";
		this.type = "Humanoid";
		this.level = 1;
		this.xp = 0;
		this.weapon = new Weapon();
	}

	/**
	 * Parameterized constructor for the Hero class
	 * @param theName hero name
	 * @param theType hero type
	 * @param theWeapon hero weapon
	 */
	public Hero(String theName, String theType, Weapon theWeapon) {
		super(1);
		this.name = StringHelper.capitalize(theName);
		this.type = StringHelper.capitalize(theType);
		this.level = 1;
		this.xp = 0;
		this.weapon = theWeapon.copy();
	}

	/**
	 * Method getName is the accessor for this instance of the name
	 * variable
	 * @return name the hero name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Method getType is the accessor for this instance of the type
	 * variable
	 * @return type the hero type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Method getLevel is the accessor for this instance of the level
	 * variable
	 * @return level the hero's level
	 */
	public int getLevel() {
		return this.level;
	}

	/**
	 * Method getXP is the accessor for this instance of the XP variable
	 * @return XP the hero's experience points
	 */
	public int getXP() {
		return this.xp;
	}

	/**
	 * Method getWeapon returns a copy of the weapon object belonging to
	 * this instance of the Hero object
	 * @return a copy of the current weapon
	 */
	public Weapon getWeapon() {
		return this.weapon.copy();
	}

	/**
	 * Method useWeapon calls the accessor for the strength variable of the
	 * weapon object belonging to this instance of hero and returns its
	 * output
	 * @return the strength value of the current system
	 */
	public int useWeapon() {
		return this.weapon.getStrength();
	}

	/**
	 * Method rename receives a String for the new name of the Hero,
	 * capitalizes it and updates the instance variable
	 * @param theName the new name for the Hero
	 */
	public void rename(String theName) {
		this.name = StringHelper.capitalize(theName);
	}

	/**
	 * Method levelUp increments the instance variable representing the
	 * Hero's level and restores their HP to maximum
	 */
	public void levelUp() {
		this.level += 1;
		System.out.println("Your level has increased to " + this.getLevel() + "!");
		this.setHP(this.getLevel() * 10);	//restore health
		this.powerUpWeapon();
	}

	/**
	 * Method gainXP receives an amount to increase the Hero's experience
	 * points and calls the levelUp method as long as the player has enough
	 * experience to level up
	 * @param theXP the amount of experience points to be gained
	 */
	public void gainXP(int theXP) {
		if(theXP >= 0) {
			System.out.println("You gain " + theXP + " experience points!");
			this.xp += theXP;	//sum the experience gain
		}

		//level up while there is sufficient xp
		while(this.getXP() >= (this.getLevel() * 100)) {
			levelUp();
			this.xp = 0;
		}
	}

	/**
	 * Method powerUpWeapon calls the powerUp method of the current
	 * instance of the weapon object
	 */
	public void powerUpWeapon() {
		this.weapon.powerUp();
	}

	/**
	 * Method equals returns a boolean value based on whether the current
	 * weapon is equal to the parameterized object
	 * @param obj the object to be compared with this instance of Hero
	 * @return true if the two heroes are the same; else false
	 */
	public boolean equals(Object obj) {
		if(!(obj instanceof Hero)) {
			return false;	//argument is not hero
		}

		Hero other = (Hero) obj;	//cast

		if(!this.name.equals(other.getName()))
			return false;	//different name
		else if(!this.type.equals(other.getType()))
			return false;	//different type
		else if(!this.weapon.equals(other.getWeapon()))
			return false;	//different weapon
		return true;	//objects are equal
	}

	/**
	 * Method toString returns a string containing the values of the
	 * instance variables type and strength
	 * @return the string with the weapon info
	 */
	public String toString() {
		return "Level " + this.getLevel() + " " + this.getType() + " " + this.getName() + " with " + this.weapon.toString() + "\nHP: " + this.getHP();
	}
}
