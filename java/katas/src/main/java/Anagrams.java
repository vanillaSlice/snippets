import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * PROBLEM:
 * Write a method to generate all anagrams for an input string.
 *
 * @author Mike Lowe
 */
public class Anagrams {

    // don't want instance
    private Anagrams() {
    }

    public static Set<String> get(String input) {
        if (input == null) {
            return Collections.emptySet();
        } else if (input.length() <= 1) {
            return Collections.singleton(input);
        }

        Set<String> anagrams = new HashSet<>();

        for (int i = 0, length = input.length(); i < length; i++) {
            char leadingChar = input.charAt(i);
            String substringWithoutLeadingChar = input.substring(0, i) + input.substring(i + 1, length);
            Set<String> subAnagrams = get(substringWithoutLeadingChar);
            for (String subAnagram : subAnagrams) {
                anagrams.add(leadingChar + subAnagram);
            }
        }

        return anagrams;
    }

}