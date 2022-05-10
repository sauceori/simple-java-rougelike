//package proj2;

/**
 * Class Enemy contains the fields and methods needed to represent an enemy 
 * character
 * @author Ethan Hopkins
 *
 */
public class Enemy extends HitPoints{
	private String name;	//enemy name
	private String type;	//enemy type
	private int level;	//enemy level
	private Weapon weapon;	//enemy's weapon
	
	/**
	 * Default constructor for the Enemy class, assigns default values to
	 * the instance variables
	 */
	public Enemy() {
		super(1);
		this.name = "Gerald";
		this.type = "Monster";
		this.level = 1;
		this.weapon = new Weapon();
	}
	
	/**
	 * Parameterized constructor for the Enemy class
	 * @param theName enemy name
	 * @param theType enemy type
	 * @param theLevel enemy level
	 * @param theWeapon enemy weapon
	 */
	public Enemy(String theName, String theType, int theLevel, Weapon theWeapon) {
		super(theLevel);
		this.name = StringHelper.capitalize(theName);
		this.type = StringHelper.capitalize(theType);
		this.level = theLevel;
		this.weapon = theWeapon.copy();
		if(theLevel < 1)
			this.level = 1;
	}
	
	/**
	 * Method getName is the accessor for this instance of the name
	 * variable
	 * @return name the enemy name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Method getType is the accessor for this instance of the type
	 * variable
	 * @return type the enemy type
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Method getLevel is the accessor for this instance of the level
	 * variable
	 * @return level the enemy level
	 */
	public int getLevel() {
		return this.level;
	}
	
	/**
	 * Method getWeapon returns a copy of the weapon object belonging to 
	 * this instance of the Enemy object
	 * @return a copy of the current weapon
	 */
	public Weapon getWeapon() {
		return this.weapon.copy();
	}
	
	/**
	 * Method useWeapon calls the accessor for the strength variable of
	 * the weapon object belonging to this instance of enemy and returns its 
	 * output
	 * @return the strength value of the current weapon
	 */
	public int useWeapon() {
		return this.weapon.getStrength();
	}
	
	/**
	 * Method toString returns a string detailing the instance variables of
	 * the current enemy object
	 * @return the string containing the values of the instance variables
	 */
	@Override
	public String toString() {
		return "Level " + this.getLevel() + " " + this.getType() + " " + this.getName() + " with " + this.weapon.toString();
	}
}
