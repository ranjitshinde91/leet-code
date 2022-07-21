package sorting.algorithms.quick_sort.partitions;

public class HoarePartition {


    public int partition(int[] input, int low, int high, int p) {
        swap(input, low, p);
        int pivotElement = input[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (input[i] < pivotElement);
            do {
                j--;
            } while (input[j] > pivotElement);
            if (i >= j) {
                return j;
            }
            swap(input, i, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        System.out.println("swapping " + arr[i] + " with " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
