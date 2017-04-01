/**
 * When sorting file names in various projects, I have found it useful to create comparators
 * to take into account numbers at the end of file names and sort as such. This is a more
 * generic implementation that compares strings and not just files.
 */

import java.math.BigInteger;
import java.util.Comparator;

/**
 * {@code AlphanumericComparator} instances are used to compare {@link String}s
 * where the numeric value of digits is taken into account.
 * <p>
 * When calling {@link String#compareTo(String)} the value of the character is used.
 * So for example, "string10" is evaluated to be less than "string2". If we take into
 * account the numeric values at the end of the strings using {@code AlphanumericComparator}
 * however, we will find that "string10" is evaluated to be greater than "string2".
 * <p>
 * Note that leading zeros will be truncated so "string0000001" will be equivalent to
 * "string1".
 *
 * @author Mike Lowe
 */
public final class AlphanumericComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        // separate strings into chunks for comparison
        String[] s1Chunks = getChunks(s1);
        String[] s2Chunks = getChunks(s2);

        // will stop IndexOutOfBoundsException
        int comparisonsToMake = Math.min(s1Chunks.length, s2Chunks.length);
        for (int i = 0; i < comparisonsToMake; i++) {
            String s1Chunk = s1Chunks[i];
            String s2Chunk = s2Chunks[i];

            // determine the comparison value ensuring that digits are not evaluated as strings
            int comparisonValue;
            DigitParseResult s1Result = parseDigits(s1Chunk);
            DigitParseResult s2Result = parseDigits(s2Chunk);
            if (s1Result.isDigits && s2Result.isDigits) {
                comparisonValue = s1Result.digits.compareTo(s2Result.digits);
            } else {
                comparisonValue = s1Chunk.compareTo(s2Chunk);
            }

            if (comparisonValue != 0) {
                // chunks are different so return comparison value
                return comparisonValue;
            }
        }

        // STRINGS ARE ALPHANUMERICALLY EQUIVALENT UP TO THIS POINT

        // if either string is longer then the longer string is determined to be greater
        if (s1Chunks.length > s2Chunks.length) {
            return 1;
        } else if (s2Chunks.length > s1Chunks.length) {
            return -1;
        } else {
            // strings are the same length and alphanumerically equivalent
            return 0;
        }
    }

    /*
     * Splits string into chunks of characters and numeric characters.
     * e.g. "1-name.1:0.txt" will be split into ["1", "-name.", "1", ":", "0", ".txt"]
     */
    private static String[] getChunks(String str) {
        return str.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
    }

    /*
     * Determine if the string contains digits and store this along with the value.
     */
    private static DigitParseResult parseDigits(String str) {
        try {
            return new DigitParseResult(true, new BigInteger(str));
        } catch (NumberFormatException e) {
            return new DigitParseResult(false, BigInteger.ZERO);
        }
    }

    private static class DigitParseResult {

        private boolean isDigits;
        private BigInteger digits;

        private DigitParseResult(boolean isDigits, BigInteger digits) {
            this.isDigits = isDigits;
            this.digits = digits;
        }

    }

}
