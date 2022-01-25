package searching.subarray_with_given_sum;

import java.util.ArrayList;


class Solution {

    static ArrayList<Integer> subarraySum(int[] input, int s) {
        ArrayList<Integer> indices = new ArrayList<>();
        int startIndex = -1;
        int sum = 0;

        for (int i = 0; i < input.length; i++) {
            if (startIndex == -1) {
                startIndex = i;
            }

            if (sum + input[i] > s) {
                while (sum + input[i] > s) {
                    sum = sum - input[startIndex];
                    startIndex++;
                }
            }
            sum = sum + input[i];
            if (sum == s) {
                indices.add(startIndex + 1);
                indices.add(i + 1);
                return indices;
            }
        }
        indices.add(-1);
        return indices;
    }
}
