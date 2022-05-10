import java.util.Random;

/**
 * Class Bow contains the methods needed to represent a Bow object, a weapon of
 * type "Bow" with a field for the number of arrows equipped alongside the Bow
 * @author Ethan Hopkins
 *
 */
public class Bow extends Weapon
{
	private int arrows;	//current number of arrows

	/**
	 * Constructor for a Bow object, initializes the Weapon type as a "Bow"
	 * with the specified strength and 10 arrows
	 * @param theStrength the strength value for the Bow
	 */
	public Bow(int theStrength) {
		super("Bow", theStrength);
		this.setNumArrows(10);
	}

	/**
	 * Overloaded Constructor for a Bow object, provides a parameter to set
	 * as the number of arrows for the current object
	 * @param theStrength the strength value for the Bow
	 * @param theArrows the number of arrows for the Bow
	 */
	public Bow(int theStrength, int theArrows) {
		super("Bow", theStrength);
		if(theArrows >= 0) {
			this.setNumArrows(theArrows);
		}
		else {
			this.setNumArrows(10);
		}
	}

	/**
	 * Method numArrows is the accessor for this instance of the arrows
	 * variable
	 * @return the number of arrows
	 */
	public int numArrows() {
		return this.arrows;
	}

	/**
	 * Method setNumArrows is the mutator for this instance of the arrows
	 * variable
	 * @param num the new number of arrows
	 */
	private void setNumArrows(int num) {
		this.arrows = num;
	}

	/**
	 * Method useArrow checks if there are any arrows, and if so removes
	 * one from the stockpile and returns true, else returns false
	 * @return true if arrow removed; else false
	 */
	public boolean useArrow() {
		//return false if no arrows
		if(this.numArrows() < 1) {
			return false;
		}

		//else decrement arrows and return true
		this.setNumArrows(this.numArrows() - 1);
		//System.out.println("You lose 1 arrow.");
		return true;
	}

	/**
	 * Method craftArrow adds an arrow to the current stockpile
	 */
	public void craftArrow() {
		this.setNumArrows(this.numArrows() + 1);
	}

	/**
	 * Method findArrows adds a random number of arrows to the current
	 * stockpile, ranging 0 to 3
	 */
	public void findArrows() {
		Random r = new Random();
		int moreArrows = r.nextInt(3);
		this.setNumArrows(this.numArrows() + moreArrows);
		//System.out.println("You've found " + moreArrows + " arrows, for a total of " + this.numArrows() + " in your quiver.");
	}

	/**
	 * Method equals returns true if the instance variables of obj are the
	 * same as the current object, including the fields inherited from
	 * Weapon but not the number of arrows
	 * @return true if obj is equal; else false
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Bow) {
			return super.equals(obj);
		}
		return false;
	}

	/**
	 * Method copy returns a new Bow object with the same instance 
	 * variables as the current object
	 * @return a copy of the Bow
	 */
	public Bow copy() {
		return new Bow(this.getStrength(), this.numArrows());
	}
}
