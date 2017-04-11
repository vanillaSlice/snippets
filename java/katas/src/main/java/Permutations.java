import java.util.HashMap;
import java.util.Map;

/**
 * PROBLEM:
 * Determine if a string is a permutation of another string.
 *
 * @author Mike Lowe
 */
public class Permutations {

    // don't want instances
    private Permutations() {
    }

    public static boolean isPermutation(String s1, String s2) {
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty() || s1.length() != s2.length()) {
            return false;
        } else if (s1.equals(s2)) {
            return true;
        }

        Map<Character, Integer> s1CharCount = countChars(s1);
        Map<Character, Integer> s2CharCount = countChars(s2);
        for (char c : s1CharCount.keySet()) {
            if (s1CharCount.get(c) != s2CharCount.get(c)) {
                return false;
            }
        }
        return true;
    }

    private static Map<Character, Integer> countChars(String s) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charCount.containsKey(c)) {
                charCount.put(c, charCount.get(c) + 1);
            } else {
                charCount.put(c, 1);
            }
        }

        return charCount;
    }

}