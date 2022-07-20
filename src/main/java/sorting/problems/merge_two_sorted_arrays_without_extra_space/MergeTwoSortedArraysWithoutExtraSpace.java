package sorting.problems.merge_two_sorted_arrays_without_extra_space;

public class MergeTwoSortedArraysWithoutExtraSpace {

    public static void merge(long[] input1, long[] input2, int n, int m) {
        int firstIndex = 0;

        while (firstIndex < n) {

            if (input1[firstIndex] <= input2[0]) {
                firstIndex++;
            } else {
                long temp = input1[n - 1];

                for (int i = n - 1; i > firstIndex; i--) {
                    input1[i] = input1[i - 1];
                }
                input1[firstIndex] = input2[0];
                for (int i = 1; i < m; i++) {
                    if (temp < input2[i]) {
                        input2[i - 1] = temp;
                        break;
                    } else {
                        input2[i - 1] = input2[i];
                    }
                }
            }
        }
    }
}
