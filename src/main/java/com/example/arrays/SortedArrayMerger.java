package com.example.arrays;

/**
 * Merges two sorted arrays into one sorted array.
 */
public final class SortedArrayMerger {

    private SortedArrayMerger() {}

    public static int[] mergeSorted(int[] a, int[] b) {

        if (a == null || b == null) {
            throw new IllegalArgumentException("Arrays cannot be null");
        }

        int[] merged = new int[a.length + b.length];

        int i = 0; // pointer for first array
        int j = 0; // pointer for second array
        int k = 0; // pointer for merged array

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                merged[k++] = a[i++];
            } else {
                merged[k++] = b[j++];
            }
        }

        while (i < a.length) {
            merged[k++] = a[i++];
        }

        while (j < b.length) {
            merged[k++] = b[j++];
        }

        return merged;
    }
}
