package mwhelan;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author Mike Lowe
 */
public class PagerTests {

    private Pager pager;

    @Before
    public void setup() {
        pager = new Pager();
    }

    @Test
    public void test_update() {
        pager.update(10, 20, 0);
        assertEquals(10, pager.getNumberOfItems());
        assertEquals(20, pager.getItemsPerPage());
        assertEquals(0, pager.getOffset());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_update_negativeNumberOfItems() {
        pager.update(-1, 20, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_update_itemsPerPageLessThan1() {
        pager.update(10, 0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_update_negativeOffset() {
        pager.update(10, 20, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_update_offsetGreaterThanNumberOfItems() {
        pager.update(10, 20, 30);
    }

    @Test
    public void test_getNumberOfPages() {
        pager.update(0, 1, 0);
        assertEquals(1, pager.getNumberOfPages());

        pager.update(1, 1, 0);
        assertEquals(1, pager.getNumberOfPages());

        pager.update(10, 1, 0);
        assertEquals(10, pager.getNumberOfPages());

        pager.update(9, 10, 0);
        assertEquals(1, pager.getNumberOfPages());

        pager.update(10, 10, 0);
        assertEquals(1, pager.getNumberOfPages());

        pager.update(11, 10, 0);
        assertEquals(2, pager.getNumberOfPages());

        pager.update(20, 10, 0);
        assertEquals(2, pager.getNumberOfPages());

        pager.update(21, 10, 0);
        assertEquals(3, pager.getNumberOfPages());
    }

    @Test
    public void test_getCurrentPage() {
        pager.update(0, 1, 0);
        assertEquals(1, pager.getCurrentPage());

        pager.update(20, 10, 0);
        assertEquals(1, pager.getCurrentPage());

        pager.update(20, 10, 10);
        assertEquals(1, pager.getCurrentPage());

        pager.update(20, 10, 11);
        assertEquals(2, pager.getCurrentPage());

        pager.update(20, 10, 20);
        assertEquals(2, pager.getCurrentPage());

        pager.update(23, 11, 23);
        assertEquals(3, pager.getCurrentPage());
    }

    @Test
    public void test_isPrevVisible() {
        pager.update(0, 1, 0);
        assertFalse(pager.isPrevVisible());

        pager.update(10, 1, 1);
        assertFalse(pager.isPrevVisible());

        pager.update(10, 10, 10);
        assertFalse(pager.isPrevVisible());

        pager.update(10, 1, 2);
        assertTrue(pager.isPrevVisible());

        pager.update(100, 10, 91);
        assertTrue(pager.isPrevVisible());

        pager.update(100, 10, 100);
        assertTrue(pager.isPrevVisible());
    }

    @Test
    public void test_isNextVisible() {
        pager.update(0, 1, 0);
        assertFalse(pager.isNextVisible());

        pager.update(100, 10, 91);
        assertFalse(pager.isNextVisible());

        pager.update(100, 10, 100);
        assertFalse(pager.isNextVisible());

        pager.update(2, 1, 1);
        assertTrue(pager.isNextVisible());

        pager.update(100, 10, 50);
        assertTrue(pager.isNextVisible());
    }

    @Test
    public void test_getLinksToPrint() {
        pager.update(0, 1, 0);
        linksToPrintAssertions(pager.getLinksToPrint(), 1, 1);

        pager.update(1, 1, 1);
        linksToPrintAssertions(pager.getLinksToPrint(), 1, 1);

        pager.update(2, 1, 1);
        linksToPrintAssertions(pager.getLinksToPrint(), 2, 1, 2);

        pager.update(3, 1, 2);
        linksToPrintAssertions(pager.getLinksToPrint(), 3, 1, 2, 3);

        pager.update(3, 1, 3);
        linksToPrintAssertions(pager.getLinksToPrint(), 2, 2, 3);

        pager.update(100, 10, 50);
        linksToPrintAssertions(pager.getLinksToPrint(), 3, 4, 5, 6);
    }

    private void linksToPrintAssertions(Set<Integer> linksToPrint, int expectedSize, int... expectedLinks) {
        assertEquals(expectedSize, linksToPrint.size());
        for (int expectedLink : expectedLinks) {
            assertTrue(linksToPrint.contains(expectedLink));
        }
    }

}