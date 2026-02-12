package com.example.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for SortedArrayMerger.
 *
 * These tests verify correct merging behavior for normal cases,
 * edge cases, and invalid input scenarios.
 */
class SortedArrayMergerTest {

    /**
     * Tests merging of two normal sorted arrays.
     */
    @Test
    void mergesTwoSortedArrays() {
        int[] a = {1, 3, 5};
        int[] b = {2, 4, 6};

        int[] result = SortedArrayMerger.mergeSorted(a, b);

        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, result);
    }

    /**
     * Tests that duplicate values are handled correctly.
     */
    @Test
    void handlesDuplicates() {
        int[] a = {1, 2, 2};
        int[] b = {2, 3};

        int[] result = SortedArrayMerger.mergeSorted(a, b);

        assertArrayEquals(new int[]{1, 2, 2, 2, 3}, result);
    }

    /**
     * Tests behavior when the first array is empty.
     */
    @Test
    void worksWhenFirstArrayEmpty() {
        int[] result =
                SortedArrayMerger.mergeSorted(new int[]{}, new int[]{1, 2, 3});

        assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    /**
     * Tests behavior when the second array is empty.
     */
    @Test
    void worksWhenSecondArrayEmpty() {
        int[] result =
                SortedArrayMerger.mergeSorted(new int[]{1, 2, 3}, new int[]{});

        assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    /**
     * Tests merging when both arrays are empty.
     */
    @Test
    void worksWhenBothArraysEmpty() {
        int[] result =
                SortedArrayMerger.mergeSorted(new int[]{}, new int[]{});

        assertArrayEquals(new int[]{}, result);
    }

    /**
     * Tests merging arrays containing negative numbers.
     */
    @Test
    void handlesNegativeNumbers() {
        int[] a = {-10, -3, 0, 2};
        int[] b = {-5, -4, 7};

        int[] result = SortedArrayMerger.mergeSorted(a, b);

        assertArrayEquals(new int[]{-10, -5, -4, -3, 0, 2, 7}, result);
    }

    /**
     * Tests that null inputs throw an IllegalArgumentException.
     */
    @Test
    void throwsExceptionWhenAnyArrayIsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> SortedArrayMerger.mergeSorted(null, new int[]{1}));

        assertThrows(IllegalArgumentException.class,
                () -> SortedArrayMerger.mergeSorted(new int[]{1}, null));
    }
}