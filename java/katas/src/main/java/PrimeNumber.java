/**
 * PROBLEM
 * Given a number i return if it is prime.
 *
 * @author Mike Lowe
 */
public class PrimeNumber {

    // don't want instances
    private PrimeNumber() {
    }

    public static boolean isPrime(int i) {
        if (i <= 1) {
            return false;
        }
        int mid = i / 2;
        for (int j = 2; j <= mid; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

}