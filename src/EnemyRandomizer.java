import java.util.Random;

/**
 * Class EnemyRandomizer, when instantiated is used to produce random enemy 
 * objects
 * @author Ethan Hopkins
 *
 */
public class EnemyRandomizer {
	Enemy theEnemy;
	RandomNaming names;
	Random r;

	/**
	 * Method EnemyRandomizer is the constructor for an EnemyRandomizer
	 * object
	 */
	public EnemyRandomizer() {
		this.names = new RandomNaming();
		this.r = new Random();
	}

	/**
	 * Method getEnemy uses the Random object to return an enemy object of
	 * a random type; Goblins are much more common than Trolls, and Trolls
	 * are more common than the rarer Lich enemy
	 * @return a randomized enemy object
	 */
	public Enemy getEnemy() {
		int prob = r.nextInt(100);

		if(prob > 85) {
			this.theEnemy = new Lich(names.getName(), new Staff(10, 10));
		}
		else if(prob > 60) {
			this.theEnemy = new Troll(names.getName(), new Bow(10));
		}
		else {
			this.theEnemy = new Goblin(names.getName(), new Sword(5));
		}

		return theEnemy;
	}
}			
