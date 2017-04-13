package mwhelan;

/**
 * PROBLEM
 * Given a number i return:
 * - "Fizz" if i is divisible by 3
 * - "Buzz" if i is divisible by 5
 * - "mwhelan.FizzBuzz" if i is divisible by 3 and 5
 * - "Whizz" if i is a prime number
 * - "FizzWhizz" if i is divisible by 3 and a prime number (i.e. 3 itself)
 * - "BuzzWhizz" if i is divisible by 5 and a prime number (i.e. 5 itself)
 * - i as a string if i does not meet any of these conditions
 *
 * @author Mike Lowe
 */
public class FizzBuzzWhizz {

    public String evaluate(int i) {
        StringBuilder builder = new StringBuilder();

        boolean isDivisibleBy3 = i % 3 == 0;
        boolean isDivisibleBy5 = i % 5 == 0;
        boolean isPrime = isPrime(i);

        if (isDivisibleBy3) {
            builder.append("Fizz");
        }
        if (isDivisibleBy5) {
            builder.append("Buzz");
        }
        if (isPrime) {
            builder.append("Whizz");
        }
        if (!isDivisibleBy3 && !isDivisibleBy5 && !isPrime) {
            builder.append(i);
        }

        return builder.toString();
    }

    private boolean isPrime(int i) {
        if (i < 2) {
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