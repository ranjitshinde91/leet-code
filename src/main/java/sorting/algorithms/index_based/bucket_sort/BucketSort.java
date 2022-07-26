package sorting.algorithms.index_based.bucket_sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    public void bucketSort(int[] input, int n, int k) {

        int max = maxOf(input, n) + 1;
        List<List<Integer>> buckets = new ArrayList<>();

        for (int i = 0; i <= k; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int bucketId = (k * input[i]) / max;
            buckets.get(bucketId).add(input[i]);
        }
        for (int i = 0; i <= k; i++) {
            Collections.sort(buckets.get(i));
        }
        int index = 0;
        for (int i = 0; i <= k; i++) {
            for (int e : buckets.get(i)) {
                input[index++] = e;
            }
        }
    }

    private int maxOf(int[] input, int n) {
        int max = input[0];
        for (int i = 1; i < n; i++) {
            if (max < input[i]) {
                max = input[i];
            }
        }
        return max;
    }
}

