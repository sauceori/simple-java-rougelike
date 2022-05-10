/**
 * Interface Magic is implemented for Weapons or Heroes that factor magical
 * force into damage calculation
 * @author Ethan Hopkins
 *
 */

public interface Magic {

	/**
	 * Abstract Method getMagicalForce, when implemented, is an accessor
	 * for the magic-based damage of certain heroes or weapons
	 * @return the magical force
	 */
	public abstract int getMagicalForce();
}
