package recursion.subset_sum;

public class SubsetSum {

    public int sum(int[] input, int sum) {
        return countSubset(input, input.length, sum);
    }

    private int countSubset(int[] arr, int n, int sum) {
        if (n == 0) {
            return sum == 0 ? 1 : 0;
        }
        return countSubset(arr, n - 1, sum) +
                countSubset(arr, n - 1, sum - arr[n - 1]);
    }
}
