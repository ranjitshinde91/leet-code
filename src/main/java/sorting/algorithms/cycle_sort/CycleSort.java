package sorting.algorithms.cycle_sort;

public class CycleSort {

    public void cycleSort(int[] input, int n) {

        for (int cs = 0; cs < n-1; cs++) {
            int item = input[cs];
            int pos = cs;
            for (int j = cs + 1; j < n; j++) {
                if (input[j] < item) {
                    pos++;
                }
            }
            if (pos != cs) {
                //Swap item with input[pos]
                int temp = input[pos];
                input[pos] = item;
                item = temp;
            }
            while (pos != cs) {
                pos = cs;
                for (int j = cs + 1; j < n; j++) {
                    if (input[j] < item) {
                        pos++;
                    }
                }
                //Swap item with input[pos]
                int temp = input[pos];
                input[pos] = item;
                item = temp;
            }
        }
    }
}
