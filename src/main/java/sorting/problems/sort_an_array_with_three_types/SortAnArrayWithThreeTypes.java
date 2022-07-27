package sorting.problems.sort_an_array_with_three_types;

public class SortAnArrayWithThreeTypes {


    public void sort(int[] input, int n) {
        int low = 0, high = n - 1, mid = 0;
        while (mid <= high) {
            if (input[mid] == 0) {
                swap(input, low, mid);
                low++;
                mid++;
            } else if (input[mid] == 1) {
                mid++;
            } else {
                swap(input, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
