package mwhelan;

/**
 * PROBLEM:
 * Given a number i return the mwhelan.Fibonacci number at this
 * position.
 *
 * @author Mike Lowe
 */
public class Fibonacci {

    /*
     * Non-recursive solution.
     */

    public static int calculate(int i) {
        if (i == 0) {
            return 0;
        } else if (i == 1) {
            return 1;
        } else {
            int total = 1;
            int prev1 = 1;
            int prev2 = 0;
            for (int j = 2; j <= i; j++) {
                total = prev1 + prev2;
                prev2 = prev1;
                prev1 = total;
            }
            return total;
        }
    }

    /*
     * Recursive solution (not as efficient).
     */

//    public static int calculate(int i) {
//        if (i == 0) {
//            return 0;
//        } else if (i == 1) {
//            return 1;
//        } else {
//            return calculate(i - 1) + calculate(i - 2);
//        }
//    }

}