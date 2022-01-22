package hashing.union_of_two_arrays;

import java.util.HashSet;

class Solution {
    public static int doUnion(int[] a, int[] b) {
        HashSet<Integer> distinctElements = new HashSet<>();
        for (int element : a) {
            distinctElements.add(element);
        }
        for (int element : b) {
            distinctElements.add(element);
        }
        return distinctElements.size();
    }
}
