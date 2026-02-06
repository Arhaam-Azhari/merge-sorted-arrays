package com.example.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SortedArrayMergerTest {

    @Test
    void mergesTwoSortedArrays() {
        int[] a = {1, 3, 5};
        int[] b = {2, 4, 6};

        int[] result = SortedArrayMerger.mergeSorted(a, b);

        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, result);
    }

    @Test
    void handlesDuplicates() {
        int[] a = {1, 2, 2};
        int[] b = {2, 3};

        int[] result = SortedArrayMerger.mergeSorted(a, b);

        assertArrayEquals(new int[]{1, 2, 2, 2, 3}, result);
    }

    @Test
    void worksWhenOneArrayEmpty() {
        int[] result =
                SortedArrayMerger.mergeSorted(new int[]{}, new int[]{1, 2, 3});

        assertArrayEquals(new int[]{1, 2, 3}, result);
    }
}
