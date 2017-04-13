package mwhelan;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Mike Lowe
 */
public class WordCounterTests {

    @Test(expected = NullPointerException.class)
    public void test_count_nullInput() {
        WordCounter.count(null);
    }

    @Test(expected = NullPointerException.class)
    public void test_count_nullDelimiter() {
        WordCounter.count("hello", null);
    }

    @Test
    public void test_count_emptyString() {
        // execution
        Map<String, Integer> result = WordCounter.count("");

        // verification
        assertEquals(1, result.size());
        wordAssertions(result, "", 1);
    }

    private void wordAssertions(Map<String, Integer> map, String word, int expectedOccurrences) {
        assertTrue(map.containsKey(word));
        assertEquals(expectedOccurrences, (int) map.get(word));
    }

    @Test
    public void test_count_singleWordReturnsMapWithOneEntry() {
        // execution
        Map<String, Integer> result = WordCounter.count("hello");

        // verification
        assertEquals(1, result.size());
        wordAssertions(result, "hello", 1);
    }

    @Test
    public void test_count_twoWordsReturnsMapWithTwoEntries() {
        // execution
        Map<String, Integer> result = WordCounter.count("hello,world");

        // verification
        assertEquals(2, result.size());
        wordAssertions(result, "hello", 1);
        wordAssertions(result, "world", 1);
    }

    @Test
    public void test_count_withRepeatingStrings() {
        // execution
        Map<String, Integer> result = WordCounter.count("hello,world,hello");

        // verification
        assertEquals(2, result.size());
        wordAssertions(result, "hello", 2);
        wordAssertions(result, "world", 1);
    }

    @Test
    public void test_count_customDelimiter() {
        // execution
        Map<String, Integer> result = WordCounter.count("hello;world;hello", ";");

        // verification
        assertEquals(2, result.size());
        wordAssertions(result, "hello", 2);
        wordAssertions(result, "world", 1);
    }

}