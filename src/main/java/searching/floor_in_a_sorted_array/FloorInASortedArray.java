package searching.floor_in_a_sorted_array;

class Solution {

    static int findFloor(long[] input, int n, long x) {
        int low = 0;
        int high = input.length - 1;
        int floor = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (input[mid] > x) {
                high = mid - 1;
            } else if (input[mid] <= x) {
                floor = mid;
                low = mid + 1;
            }
        }
        return floor;
    }
}
