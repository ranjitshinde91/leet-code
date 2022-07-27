package sorting.problems.sort_an_array_with_two_types;

public class SortAnArrayWithTwoTypes {


    public void sort(int[] input, int n) {
        int i = -1;
        int j = n;
        while (true) {
            do {
                i++;
            }
            while (input[i] == 0);
            do {
                j--;
            }
            while (input[j] == 1);
            if (i >= j) {
                break;
            }
            swap(input, i, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
