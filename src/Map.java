import java.util.Random;

/**
 * Class Map uses a 2d array of boolean values to represent locations of
 * obstacles on a grid, and contains methods pertaining to this array
 * @author Ethan Hopkins
 *
 */
public class Map {
	private boolean[][] grid;	//grid of obstacles
	private int[] player;		//the player's location in the grid
					//index 0 is the x coordinate
					//index 1 is the y coordinate

	/**
	 * Default constructor for Map objects, creates an 8x8 map with
	 * obstacles placed at random with a fixed "encounter rate" and the
	 * player starting at coordinate 0,0
	 */
	public Map() {
		this.grid = new boolean[8][8];
		Random r = new Random();
		for(int i = 0; i < this.grid.length; i++) {
			for(int j = 0; j < this.grid[i].length; j++) {
				if(r.nextInt(100) < 25) {
					this.grid[i][j] = true;
				}
				else {
					this.grid[i][j] = false;
				}
			}
		}
		if(this.hasObstacle(0, 0)) {
			this.clearObstacle(0, 0);
		}
		this.player = new int[]{0,0};
	}

	/**
	 * Parameterized constructor for Map objects
	 * @param array the grid to be used in the object
	 * @param x the x coordinate for the player's starting location
	 * @param y the y coordinate for the player's starting location
	 */
	public Map(boolean[][] array, int x, int y) {
		this.grid = new boolean[array.length][array[0].length];
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				this.grid[i][j] = array[i][j];
			}
		}
		this.player = new int[]{x,y};
	}

	/**
	 * Method maxNS returns the maximum number of spaces on the map in the
	 * north-south direction
	 * @return the height of the grid
	 */
	public int maxNS() {
		return this.grid.length;
	}

	/**
	 * Method maxEW returns the maximum number of spaces on the map in the
	 * east-west direction
	 * @return the width of the grid
	 */
	public int maxEW() {
		return this.grid[0].length;
	}

	/**
	 * Method hasObstacle determines whether there is an obstacle at the
	 * location specified by the parameters
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @return true if obstacle; else false
	 */
	public boolean hasObstacle(int x, int y) {
		return this.grid[x][y];
	}

	/**
	 * Method getObstacle receives a row and column number, and returns a
	 * default enemy if an obstacle exists
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @return default enemy if true; else false
	 */
	public Enemy getObstacle(int x, int y) {
		if(this.grid[x][y] == false) {
			//throw new RuntimeException("No obstacle at index " + x + " " + y + ".");
			throw new RuntimeException("No Obstacle");
		}
		return new Enemy();
	}

	/**
	 * Method clearObstacle removes the obstacle from the player's current
	 * position
	 */
	public void clearObstacle() {
		this.grid[player[0]][player[1]] = false;
	}

	/**
	 * Method clearObstacle receives a row and column and removes the
	 * obstacle at that location by flipping the boolean value if needed
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	public void clearObstacle(int x, int y) {
		this.grid[x][y] = false;
	}

	/**
	 * Method addObstacle receives a rown and column number and adds an
	 * obstacle to that location by flipping the boolean value if needed
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	public void addObstacle(int x, int y) {
		this.grid[x][y] = true;
	}

	/**
	 * Method displayMap displays the characters which represent the map,
	 * with "C" being the player, "_" being an empty space, and "X" being
	 * an obstacle
	 */
	public void displayMap() {
		System.out.print("\n");
		for(int i = 0; i < this.grid.length; i++) {
			for(int j = 0; j < this.grid[i].length; j++) {
				if((player[0] == j) && (player[1] == i)) {
					System.out.print("C ");
				}
				else if(this.hasObstacle(j, i)) {
					System.out.print("X ");
				}
				else if(!this.hasObstacle(j, i)) {
					System.out.print("_ ");
				}
			}
			System.out.print("\n");
		}
	}

	/**
	 * Method hasAnyObstacle checks the entire map for obstacles
	 * @return true if any obstacles are present; else false
	 */
	public boolean hasAnyObstacle() {
		for(int i = 0; i < this.grid.length; i++) {
			for(int j = 0; j < this.grid[i].length; j++) {
				if(this.hasObstacle(j, i)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Method move receives an input string for player movement, changes
	 * the value of player if possible, and displays a message regarding 
	 * whether the move was able to be made, movements are to be described
	 * with the cardinal directions (north, east, south, west) and
	 * movements are conducted one unit at a time
	 * @param direction a string describing the movement to be made
	 * @return 1 if move was unsuccessful, 0 if unsuccessful, -1 if player
	 * dies in battle
	 */
	public int move(String direction, Hero thePlayer) {
		direction = direction.toLowerCase();

		if((direction.equals("north")) && (this.player[1] > 0)) {
			this.player[1] = this.player[1] - 1;
			System.out.println("You move due north.");

			//commence battle if obstacle is present
			if(this.atObstacle()) {
				if(!Damage.battle(thePlayer)) {
					return -1;
				}
			}
			return 1;
		}
		else if((direction.equals("east")) && (this.player[0] < (grid.length - 1))) {
			this.player[0] = this.player[0] + 1;
			System.out.println("You move due east.");

			if(this.atObstacle()) {
				if(!Damage.battle(thePlayer)) {
					return -1;
				}
			}
			return 1;
		}
		else if((direction.equals("south")) && (this.player[1] < (grid[1].length -1))) {
			this.player[1] = this.player[1] + 1;
			System.out.println("You move due south.");

			if(this.atObstacle()) {
				if(!Damage.battle(thePlayer)) {
					return -1;
				}
			}
			return 1;
		}
		else if((direction.equals("west")) && (this.player[0] > 0)) {
			this.player[0] = this.player[0] - 1;
			System.out.println("You move due west.");

			if(this.atObstacle()) {
				if(!Damage.battle(thePlayer)) {
					return -1;
				}
			}
			return 1;
		}

		return 0;
	}

	/**
	 * Method atObstacle determines whether the player is standing on a
	 * tile with an obstacle
	 * @return true if obstacle; else false
	 */
	public boolean atObstacle() {
		if(this.hasObstacle(this.player[0], this.player[1])) {
			return true;
		}
		return false;
	}
}
