import java.util.Scanner;

/**
 * Class Driver contains the game loop in it's main method, the player is
 * prompted to create a character from the set of Hero classes, then takes
 * turns moving across the map until either he or she falls in battle or all
 * enemies are defeated
 * @author Ethan Hopkins
 *
 */
public class Driver {
	public static void main(String[] args) {
		Map map = new Map();			//the map to be played on
		Scanner in = new Scanner(System.in);	//scanner for user input

		boolean gamestate = true;	//game loop runs while game state is true
		String str;			//the input string
		int moveInt;			//the integer returned from a call to move in map

		Hero pc = characterCreation(in);	//player creates a player character

		map.displayMap();
		System.out.print(pc.toString() + "\n");

		while(gamestate == true) {
			System.out.println("\nIn which direction would you like to move?");
			str = in.next();
			str = str.toLowerCase();

			if(str.equals("north") || str.equals("east") || str.equals("south") || str.equals("west")) {
				moveInt = map.move(str, pc);

				if(moveInt == 0) {
					System.out.println("You cannot move in that direction.");
				}
				else if(moveInt < 0) {
					System.out.println("Alas, you have fallen in battle!\nGame Over.");
					gamestate = false;
				}
				else if(moveInt > 0) {
					//remove fallen enemy
					if(map.atObstacle()) {
						map.clearObstacle();
					}
					map.displayMap();
					System.out.print(pc.toString() + "\n");
				}
			}
			else {
				System.out.println("Try using the cardinal directions: North, East, South, and West");
			}

			if(!map.hasAnyObstacle()) {
				System.out.println("You have rid the land of all evil.\nYou Win!");
				gamestate = false;
			}
		}
		in.close();
	}

	/**
	 * Method characterCreation defines the Hero object based on the user's
	 * choice of Name and whether they want to play as a Halfling, Elf, or
	 * Wizard
	 */
	private static Hero characterCreation(Scanner in) {
		boolean input = false;	//becomes true on correct input

		System.out.println("What is your name, traveller?");
		
		String name = in.next();

		System.out.println("I see, so your name is " + name + ". Are you a Halfling, an Elf, or a Wizard?");
		String type;
		while(input == false) {
			type = in.next();
			type = type.toLowerCase();

			if(type.equals("halfling")) {
				input = true;
				return new Halfling(name, new Sword(15));
			}
			else if(type.equals("elf")) {
				input = true;
				return new Elf(name, new Bow(13), 0);
			}
			else if(type.equals("wizard")) {
				input = true;
				return new Wizard(name, new Staff(12, 12));
			}
			System.out.println("I didn't quite catch that. Are you a Halfling, an Elf, or a Wizard?");
		}
		return new Halfling("Frodo", new Sword(15));
	}
}
