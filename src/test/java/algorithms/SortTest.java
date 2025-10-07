package algorithms;

import metrics.Tracker;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class SortTest {

    @Test
    public void testEmpty() {
        int[] a = new int[0];
        SelectionSort.sort(a, new Tracker());
        assertArrayEquals(new int[0], a);
    }

    @Test
    public void testSingle() {
        int[] a = {42};
        SelectionSort.sort(a, new Tracker());
        assertArrayEquals(new int[]{42}, a);
    }

    @Test
    public void testSorted() {
        int[] a = {1,2,3,4,5};
        SelectionSort.sort(a, new Tracker());
        assertArrayEquals(new int[]{1,2,3,4,5}, a);
    }

    @Test
    public void testReversed() {
        int[] a = {5,4,3,2,1};
        SelectionSort.sort(a, new Tracker());
        assertArrayEquals(new int[]{1,2,3,4,5}, a);
    }

    @Test
    public void testDuplicates() {
        int[] a = {5,3,3,2,5,3};
        SelectionSort.sort(a, new Tracker());
        assertArrayEquals(new int[]{2,3,3,3,5,5}, a);
    }

    @Test
    public void testNegatives() {
        int[] a = {0, -1, 4, -3};
        SelectionSort.sort(a, new Tracker());
        assertArrayEquals(new int[]{-3, -1, 0, 4}, a);
    }

    @Test
    public void testRandomMany() {
        Random r = new Random(42);
        for (int iter = 0; iter < 20; iter++) {
            int n = 50;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = r.nextInt(1000);
            int[] expected = Arrays.copyOf(a, a.length);
            Arrays.sort(expected);
            SelectionSort.sort(a, new Tracker());
            assertArrayEquals(expected, a);
        }
    }

    @Test
    public void testNullThrows() {
        assertThrows(IllegalArgumentException.class, () -> SelectionSort.sort(null, new Tracker()));
    }

    @Test
    public void testPropertyBasedRandom() {
        Random r = new Random(123);
        for (int iter = 0; iter < 100; iter++) {
            int n = r.nextInt(200);
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = r.nextInt(1000) - 500; //
            }
            int[] expected = Arrays.copyOf(a, a.length);
            Arrays.sort(expected);

            SelectionSort.sort(a, new Tracker());
            assertArrayEquals(expected, a, "Fail on iteration " + iter);
        }
    }

}