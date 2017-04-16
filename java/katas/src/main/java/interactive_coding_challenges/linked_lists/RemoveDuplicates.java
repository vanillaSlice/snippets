package interactive_coding_challenges.linked_lists;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * PROBLEM:
 * Remove duplicates from a linked list.
 *
 * @author Mike Lowe
 */
public class RemoveDuplicates {

    // don't want instances
    private RemoveDuplicates() {
    }

    public static <E> void remove(LinkedList<E> list) {
        Set<E> seen = new HashSet<>();

        Iterator<E> iterator = list.iterator();
        while (iterator.hasNext()) {
            E element = iterator.next();
            if (seen.contains(element)) {
                iterator.remove();
            } else {
                seen.add(element);
            }
        }
    }

}