package hashing.intersection_of_two_arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    // Function to return the count of the number of elements in
    // the intersection of two arrays.
    public int numberofElementsInIntersection(int[] a, int[] b, int n, int m) {

        Set<Integer> occurrence = Arrays.stream(a).boxed().collect(Collectors.toSet());
        int intersectedElementCount = 0;

        for (int i = 0; i < m; i++) {
            if (occurrence.contains(b[i])) {
                intersectedElementCount++;
                occurrence.remove(b[i]);
            }
        }
        return intersectedElementCount;

    }
}



