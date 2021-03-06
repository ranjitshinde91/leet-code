package searching.searching_in_an_infinite_sorted_array;


//unbounded binary search
class Solution {

    int searchInSorted(int[] arr, int element) {
        if (arr[0] == element) {
            return 0;
        }
        int i = 1;
        while (arr[i] < element) {
            i = i * 2;
        }
        if (arr[i] == element) {
            return i;
        }
        return binarySearch(arr, i / 2, i - 1, element);
    }

    private int binarySearch(int[] arr, int low, int high, int element) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (element == arr[mid]) {
            return mid;
        } else if (element > arr[mid]) {
            return binarySearch(arr, mid + 1, high, element);
        }
        return binarySearch(arr, low, mid - 1, element);
    }
}
