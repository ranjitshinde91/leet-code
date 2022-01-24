package searching.find_a_peak_element;

class Solution {

    public long findPeak(int[] input) {
        int low = 0;
        int high = input.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (
                    (mid == 0 || input[mid - 1] <= input[mid]) &&
                            (mid == input.length - 1 || input[mid + 1] <= input[mid])
            ) {
                return mid;
            }
            if (mid > 0 && input[mid - 1] >= input[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
