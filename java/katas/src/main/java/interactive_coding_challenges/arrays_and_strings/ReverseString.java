package interactive_coding_challenges.arrays_and_strings;

/**
 * PROBLEM:
 * Implement a function to reverse a string.
 *
 * @author Mike Lowe
 */
public class ReverseString {

    // don't want instances
    private ReverseString() {
    }

    public static String reverse(String input) {
        if (input == null || input.isEmpty() || input.length() == 1) {
            return input;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            builder.append(input.charAt(i));
        }
        return builder.toString();
    }

}