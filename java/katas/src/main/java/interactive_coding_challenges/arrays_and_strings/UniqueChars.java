package interactive_coding_challenges.arrays_and_strings;

import java.util.HashSet;
import java.util.Set;

/**
 * PROBLEM:
 * Implement an algorithm to determine if a string has all
 * unique characters.
 *
 * @author Mike Lowe
 */
public class UniqueChars {

    // don't want instances
    private UniqueChars() {
    }

    public static boolean hasUniqueChars(String input) {
        if (input == null) {
            return false;
        }
        Set<Character> foundChars = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (foundChars.contains(c)) {
                return false;
            } else {
                foundChars.add(c);
            }
        }
        return true;
    }

}