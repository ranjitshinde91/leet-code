package searching.searching_an_element_in_a_sorted_array;

class Solution {
    int searchInSorted(int[] arr, int element) {
        if (_searchInSorted(arr, 0, arr.length-1, element)) {
            return 1;
        }
        return -1;
    }

    boolean _searchInSorted(int[] arr, int low, int high, int element) {
        System.out.printf(" low=%d high=%d mid=%d \n", low, high, (low + high) / 2);
        if (low > high) {
            return false;
        }
        int mid = (low + high) / 2;
        if (element == arr[mid]) {
            return true;
        } else if (element > arr[mid]) {
            return _searchInSorted(arr, mid + 1, high, element);
        }
        return _searchInSorted(arr, low, mid - 1, element);
    }
}