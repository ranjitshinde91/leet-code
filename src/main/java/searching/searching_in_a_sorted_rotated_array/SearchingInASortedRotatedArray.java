package searching.searching_in_a_sorted_rotated_array;


class Solution {

    int searchInSortedRotated(int[] arr, int element) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == element) {
                return mid;
            }
            if (arr[low] < arr[mid]) {
                if (element >= arr[low] && element < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (element > arr[mid] && element <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
