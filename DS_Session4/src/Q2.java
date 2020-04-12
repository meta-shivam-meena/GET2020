import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Q2 {

	private static Map<String, Integer> cache = new TreeMap<>(
			String.CASE_INSENSITIVE_ORDER);

	public static int countUniqueCharacters(String string) {
		if (cache.containsKey(string)) {
			return cache.get(string);
		} else {
			Set<Character> uniqueCharacters = new HashSet<Character>();
			for (int i = 0; i < string.length(); i++) {
				uniqueCharacters.add(string.charAt(i));
			}
			cache.put(string, uniqueCharacters.size());
			return uniqueCharacters.size();
		}
	}

	public static void main(String[] args) {
		String string = "shivam";
		System.out.println(countUniqueCharacters(string));
		System.out.println("Cache Size: " + cache.size());
		string = "Shivam";
		System.out.println(countUniqueCharacters(string));
		System.out.println("Cache Size: " + cache.size());
		string = "metacube";
		System.out.println(countUniqueCharacters(string));
		System.out.println("Cache Size: " + cache.size());
	}
}
