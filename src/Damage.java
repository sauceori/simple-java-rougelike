import java.util.*;

/**
 * Class Damage is a helper class containing methods which determine hit 
 * probability and damage dealt by weapons
 * @author Ethan Hopkins
 *
 */
public class Damage {
	/**
	 * Method battle takes the player (Hero) object and conducts a 
	 * turn-based battle between it and an enemy object, the player always
	 * moves first
	 * @param thePlayer the object representing the player character
	 * @return true if the player wins; else false
	 */
	public static boolean battle(Hero thePlayer) {
		EnemyRandomizer randomizer = new EnemyRandomizer();
		Enemy theEnemy = randomizer.getEnemy();

		System.out.println("A " + theEnemy.getType() + " named " + theEnemy.getName() + " approaches for a fight!");

		int damage;
		while((thePlayer.isAlive()) && (theEnemy.isAlive())) {
			//calculate player's damage
			damage = damageCalc(thePlayer.getWeapon(), thePlayer.getLevel());
			if(damage >= 0) {
				System.out.println("You attack with your " + thePlayer.getWeapon().getType() + ", dealing " + damage + " damage.");
				theEnemy.loseHP(damage);
			}
			else {
				System.out.println("You attack with your " + thePlayer.getWeapon().getType() + ", but miss!");
			}

			//if bow, use arrow
			if(thePlayer.getWeapon() instanceof Bow) {
				Bow bowObj = (Bow) thePlayer.getWeapon();
				bowObj.useArrow();
			}

			//calculate enemy's damage
			if(theEnemy.isAlive()) {
				damage = damageCalc(theEnemy.getWeapon(), theEnemy.getLevel());

				if(damage >= 0) {
					System.out.println(theEnemy.getName() + " attacks with a " + theEnemy.getWeapon().getType() + ", dealing " + damage + " damage to you.");
					thePlayer.loseHP(damage);
				}
				else {
					System.out.println(theEnemy.getName() + " attacks with a " + theEnemy.getWeapon().getType() + ", but misses!");
				}
			}
		}

		if(!theEnemy.isAlive()) {
			System.out.println("You've dealt a killing blow to the " + theEnemy.getType() + "!");
			thePlayer.gainXP(theEnemy.getLevel() * 5);
			//if elf, find some arrows
			if(thePlayer.getWeapon() instanceof Bow) {
				Bow bowObj = (Bow) thePlayer.getWeapon();
				bowObj.findArrows();
			}
			return true;
		}
		else if(!thePlayer.isAlive()) {
			System.out.println("You've been dealt a killing blow by the " + theEnemy.getType() + "!");
		}
		return false;
	}

	/**
	 * Method hitProb determines the type of the weapon passed as parameter
	 * and returns a boolean value chosen at random to determine whether an
	 * attack lands, the chance for an attack to land scales slightly with
	 * level
	 * @param theWeapon the user's weapon
	 * @param theLevel the level of the attacker
	 */
	private static boolean hitProb(Weapon theWeapon, int theLevel) {
		if(theWeapon instanceof Bow) {
			return true; //bows never miss but need arrows
		}

		Random r = new Random();
		int accuracy;

		if(theWeapon instanceof Sword) {
			accuracy = 50 + (theLevel * 3);
			if(r.nextInt(100) <= accuracy) {
				return true;	//swords can miss but dont need arrows
			}
			return false;
		}
		else if(theWeapon instanceof Staff) {
			accuracy = 35 + (theLevel * 2);
			if(r.nextInt(100) <= accuracy) {
				return true;
			}
			return false;	//staves deal much more damage but miss much more often
		}
		return false;
	}

	/**
	 * Method damageCalc determines the type of the weapon passed as
	 * parameter and returns a damage value calculated with the weapon's
	 * strength (or magic power) and the level of the user, returns -1 in
	 * the event of a miss
	 * @param theWeapon the user's weapon
	 * @param theLevel the level of the attacker
	 */
	private static int damageCalc(Weapon theWeapon, int theLevel) {
		if(((theWeapon instanceof Sword) || (theWeapon instanceof Bow)) && hitProb(theWeapon, theLevel)) {
			return (theWeapon.getStrength() + (theLevel / 2));
		}
		else if(theWeapon instanceof Staff && hitProb(theWeapon, theLevel)) {
			Staff staffObj = (Staff) theWeapon;
			return (staffObj.getStrength() + staffObj.getMagicalForce() + (theLevel / 4));
		}
		return -1;	//miss
	}
}
