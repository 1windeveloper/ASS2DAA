package test.java.algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SelectionSortTest {

    @Test
    public void testSort() {
        int[] array = {5, 2, 9, 1, 5, 6};
        SelectionSort.sort(array);
        assertArrayEquals(new int[]{1, 2, 5, 5, 6, 9}, array);
    }

    @Test
    public void testEarlyTermination() {
        int[] array = {1, 2, 3, 4, 5};
        SelectionSort.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    public void testEmptyArray() {
        int[] array = {};
        SelectionSort.sort(array);
        assertArrayEquals(new int[]{}, array);
    }

    @Test
    public void testSingleElement() {
        int[] array = {1};
        SelectionSort.sort(array);
        assertArrayEquals(new int[]{1}, array);
    }
}
