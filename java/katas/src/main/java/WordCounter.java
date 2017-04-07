import java.util.HashMap;
import java.util.Map;

/**
 * PROBLEM:
 * Create a simple word counter that takes in a string and returns a map
 * of unique words and the number of times each word occurs.
 * e.g. 'hello,world,hello' should return {hello: 2, world: 1}.
 * A custom delimiter may be used, a comma will be used as the default.
 *
 * @author Mike Lowe
 */
public class WordCounter {

    private static final String DEFAULT_DELIMITER = ",";

    public static Map<String, Integer> count(String input) {
        return count(input, DEFAULT_DELIMITER);
    }

    public static Map<String, Integer> count(String input, String delimiter) {
        Map<String, Integer> map = new HashMap<>();
        String[] split = input.split(delimiter);
        for (String string : split) {
            if (map.containsKey(string)) {
                map.put(string, map.get(string) + 1);
            } else {
                map.put(string, 1);
            }
        }
        return map;
    }

}