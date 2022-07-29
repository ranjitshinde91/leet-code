package sorting.problems.count_inversions_in_array;

public class CountInversionsInArray {

    static long inversionCount(long[] arr, long n) {
        return _inversionCount(arr, 0, (int) n - 1);
    }

    private static long _inversionCount(long[] arr, int low, int high) {
        long res = 0;
        if (low < high) {
            int mid = (high + low) / 2;
            res += _inversionCount(arr, low, mid);
            res += _inversionCount(arr, mid + 1, high);
            res += _inversionCountAndMerge(arr, low, mid, high);
        }
        return res;
    }

    private static long _inversionCountAndMerge(long[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        long[] temp1 = new long[n1];
        long[] temp2 = new long[n2];

        for (int p = 0; p < n1; p++) {
            temp1[p] = arr[low + p];
        }
        for (int p = 0; p < n2; p++) {
            temp2[p] = arr[mid + 1 + p];
        }
        int k = low;
        long res = 0;
        int i = 0;
        int j = 0;

        while (i < n1 && j < n2) {
            if (temp2[j] < temp1[i]) {
                arr[k++] = temp2[j];
                j++;
                res = res + (n1 - i);
            } else {
                arr[k++] = temp1[i];
                i++;
            }
        }
        for (; i < n1; i++) {
            arr[k++] = temp1[i];
        }
        for (; j < n2; j++) {
            arr[k++] = temp2[j];
        }
        return res;
    }
}
