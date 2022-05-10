import java.io.*;
import java.util.*;

/**
 * Class RandomNaming fetches pre-generated names from names.txt at random for
 * the purpose of naming enemies
 * @author Ethan Hopkins
 *
 */
public class RandomNaming {
	private ArrayList<String> names;	//list of the names in names.txt
	private Random r;			//object for random elements in the list

	/**
	 * Constructor RandomNaming instantiates the arraylist of names and
	 * populates it with the contents of names.txt, it also instantiates
	 * the random object used for getting names from the list
	 */
	public RandomNaming() {
		Scanner in;
		r = new Random();
		names = new ArrayList<>();

		try {
			in = new Scanner(new File("names.txt"));
			while(in.hasNext()) {
				names.add(in.next());
			}
			in.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method getName uses the random object to retrieve a name from the
	 * list at random
	 * @return a random string stored in the names arraylist
	 */
	public String getName() {
		int index = r.nextInt(names.size());
		return names.get(index);
	}
}
