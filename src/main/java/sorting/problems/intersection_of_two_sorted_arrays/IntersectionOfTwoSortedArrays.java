package sorting.problems.intersection_of_two_sorted_arrays;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoSortedArrays {

    static ArrayList<Integer> printIntersection(int[] arr1, int[] arr2, int n, int m) {
        ArrayList<Integer> intersection = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            if (i > 0 && arr1[i] == arr1[i - 1]) {
                i++;
                continue;
            }
            if (arr1[i] == arr2[j]) {
                intersection.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
        if (intersection.isEmpty()) {
            return new ArrayList<>(List.of(-1));
        }
        return intersection;
    }

}
