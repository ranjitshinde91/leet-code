package sorting.algorithms.quick_sort.partitions;

public class LomutoPartition {


    public int partition(int[] input, int low, int high, int p) {
        swap(input, p, high);
        return partition(input, low, high);
    }

    public int partition(int[] input, int low, int high) {
        int i = low - 1;
        int pivotElement = input[high];
        for (int j = low; j < high; j++) {
            if (input[j] <= pivotElement) {
                i++;
                swap(input, i, j);
            }
        }
        swap(input, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
