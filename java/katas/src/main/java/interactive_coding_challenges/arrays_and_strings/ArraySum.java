package interactive_coding_challenges.arrays_and_strings;

import java.util.HashMap;
import java.util.Map;

/**
 * PROBLEM:
 * Given an array, find the two indices that sum to a specific value.
 *
 * @author Mike Lowe
 */
public class ArraySum {

    // don't want instances
    private ArraySum() {
    }

    public static int[] twoSum(int[] input, int sum) {
        if (input == null) {
            throw new NullPointerException("input cannot be null");
        } else if (input.length < 2) {
            throw new IllegalArgumentException("input contains less than 2 ints");
        }

        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            int num = input[i];
            if (cache.containsKey(num)) {
                return new int[]{cache.get(num), i};
            } else {
                cache.put(sum - num, i);
            }
        }

        return new int[]{-1, -1};
    }

}