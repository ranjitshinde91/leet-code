package sorting.algorithms.quick_sort.partitions;

public class NaivePartition {

    public int partition(int[] input, int low, int high, int p) {
        int[] temp = new int[high - low + 1];
        int res;
        int index = 0;
        for (int i = low; i <= high; i++) {
            if (input[i] < input[p]) {
                temp[index++] = input[i];
            }
        }
        for (int i = low; i <= high; i++) {
            if (input[i] == input[p]) {
                temp[index++] = input[i];
            }
        }
        res = low + index - 1;
        for (int i = low; i <= high; i++) {
            if (input[i] > input[p]) {
                temp[index++] = input[i];
            }
        }
        index = 0;
        for (int i = low; i <= high; i++) {
            input[i] = temp[index++];
        }
        return res;
    }
}
