package interactive_coding_challenges.arrays_and_strings;

import java.util.HashSet;
import java.util.Set;

/**
 * PROBLEM:
 * Find the single different char between two strings.
 *
 * @author Mike Lowe
 */
public class DifferentChar {

    // don't want instances
    private DifferentChar() {
    }

    public static char findDiff(String s1, String s2) {
        notNull(s1, "s1");
        notNull(s2, "s2");

        String longest;
        String shortest;
        if (s1.length() > s2.length()) {
            longest = s1;
            shortest = s2;
        } else {
            longest = s2;
            shortest = s1;
        }

        Set<Character> seen = new HashSet<>();
        for (int i = 0; i < shortest.length(); i++) {
            seen.add(shortest.charAt(i));
        }
        for (int i = 0; i < longest.length(); i++) {
            if (!seen.contains(longest.charAt(i))) {
                return longest.charAt(i);
            }
        }

        return '\0';
    }

    private static void notNull(String string, String name) {
        if (string == null) {
            throw new NullPointerException(name + " cannot be null");
        }
    }

}