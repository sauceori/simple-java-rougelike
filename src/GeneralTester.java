/**
 * Class GeneralTester contains methods used to test new features added for
 * Part 4 on a class-by-class basis, the following classes are either new or 
 * have been changed significantly and thus have tests:
 * - HitPoints
 * - RandomNaming
 * - EnemyRandomizer
 * - Damage
 * - Map
 * @author Ethan Hopkins
 *
 */

public class GeneralTester {
	//main calls to the encapsulated class testers
	public static void main(String[] args) {
		System.out.println("===== Project 4 Testing Suite =====\n");
		testHitPoints();
		testRandomNaming();
		testEnemyRandomizer();
		testDamage();
		testMap();
	}

	//tester for HitPoints.java
	private static void testHitPoints() {
		System.out.println("----- Test HitPoints -----");
		System.out.println("Instantiates objects with HitPoints and checks if they are given the correct number of default HP.");

		//heroes start at level 1, so 10 hp
		int expected1 = 10;
		Hero actual1 = new Wizard("Name", new Staff(1, 1));
		System.out.println(actual1.getType() + " of level " + actual1.getLevel() + " actual HP: " + actual1.getHP() + " Expected: " + expected1);

		//goblins currently have a fixed level of 3, so 30 hp
		int expected2 = 30;
		Enemy actual2 = new Goblin("Name", new Sword(1));
		System.out.println(actual2.getType() + " of level " + actual2.getLevel() + " actual HP: " + actual2.getHP() + " Expected: " + expected2);

		//trolls currently have a fixed level of 6, so 60 hp
		int expected3 = 60;
		Enemy actual3 = new Troll("Name", new Bow(10));
		System.out.println(actual3.getType() + "  of level " + actual3.getLevel() + " actual HP: " + actual3.getHP() + " Expected: " + expected3);

		System.out.println("");
	}

	//tester for RandomNaming.java
	private static void testRandomNaming() {
		System.out.println("----- Test RandomNaming -----");
		System.out.println("Instantiates a RandomNaming object and prints 10 names at random, names are picked from a list so there may be duplicates as long as they are inconsistent.");

		RandomNaming names = new RandomNaming();

		for(int i = 0; i < 10; i++) {
			System.out.println(names.getName());
		}

		System.out.println("");
	}

	//tester for EnemyRandomizer.java
	private static void testEnemyRandomizer() {
		System.out.println("----- Test EnemyRandomizer -----");
		System.out.println("Instantiates an EnemyRandomizer Object and creates 10 random enemies, Goblins should be much more common than Trolls, and Trolls should be more common than the rare Lich type.");

		EnemyRandomizer enemies = new EnemyRandomizer();
		Enemy actual;

		for(int i = 0; i < 10; i++) {
			actual = enemies.getEnemy();
			System.out.println(actual.getType());
		}

		System.out.println("");
	}

	//tester for Damage.java
	private static void testDamage() {
		System.out.println("----- Test Damage -----");
		System.out.println("Runs the battle script on the three different Hero types, testing this class is a bit wonky as the helpers would make for better tests than the battle itself, but those methods are private. Battles have random elements, but should always have a clear victor no matter the result and bow users should never miss.");

		Hero obj;

		//test for halfling
		obj = new Halfling("Name", new Sword(15));
		Damage.battle(obj);
		System.out.println("");

		//test for elf
		obj = new Elf("Name", new Bow(13), 0);
		Damage.battle(obj);
		System.out.println("");

		//test for Wizard
		obj = new Wizard("Name", new Staff(12, 12));
		Damage.battle(obj);
		System.out.println("");
	}

	//tester for the new features in Map.java
	private static void testMap() {
		System.out.println("----- Test Map -----");
		System.out.println("Tests the new default Map constructor, which creates 8x8 map grids with random obstacles places throughout, displays the map with the displayMap function therein and calls hasAnyObstacle which is used in-game to determine if the player has reached the win-state (won all enemy encounters triggered by obstacles).");

		Map map;

		for(int i = 0; i < 3; i++) {
			map = new Map();
			System.out.println("Map " + (i+1) + ":");
			map.displayMap();
			System.out.println("hasAnyObstacle result: " + map.hasAnyObstacle());
			System.out.println("");
		}
	}
}
