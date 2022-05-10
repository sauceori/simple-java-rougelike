//package proj2;

/**
 * To help capitalize strings nicely.
 * @author Prof. Givens
 *
 */
public class StringHelper {
	
	/**
	 * Creates a String with every word capitalized, separated by 
	 * spaces.
	 * @param str String to capitalize
	 * @return the capitalized String
	 */
	public static String capitalize(String str) {
		String result = "";
		
		if(str.trim().equals(result)) {
			return result;
		}
		
		String[] words = str.toLowerCase().split("\\p{Space}+");
		
		for(String word: words) {
			word = "" + Character.toUpperCase(word.charAt(0)) + word.substring(1);
			result += word + " ";
		}
		
		return result.trim();
	}
	
	public static void main(String[] args) {
		System.out.println(capitalize("this is a test!!    ok?	 	right-o"));
	}

}
