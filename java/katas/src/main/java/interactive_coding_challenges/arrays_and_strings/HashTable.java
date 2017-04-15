package interactive_coding_challenges.arrays_and_strings;

import java.util.NoSuchElementException;

/**
 * PROBLEM:
 * Implement a simple hash table with set, get, and remove methods.
 *
 * @author Mike Lowe
 */
public final class HashTable {

    private final int size;
    private final String[] array;

    public HashTable(int size) {
        this.size = size;
        this.array = new String[this.size];
    }

    private int getHashCode(int key) {
        return key % size;
    }

    public void set(int key, String value) {
        array[getHashCode(key)] = value;
    }

    public String get(int key) {
        String value = array[getHashCode(key)];
        if (value == null) {
            throw new NoSuchElementException("No value at " + key);
        }
        return value;
    }

    public void remove(int key) {
        int hashCode = getHashCode(key);
        String value = array[hashCode];
        if (value == null) {
            throw new NoSuchElementException("No value at " + key);
        }
        array[hashCode] = null;
    }

}