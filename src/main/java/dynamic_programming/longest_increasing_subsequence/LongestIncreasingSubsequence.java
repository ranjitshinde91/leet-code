package dynamic_programming.longest_increasing_subsequence;

public class LongestIncreasingSubsequence {

    public int binarySearchTreeBased(int[] input) {
        return _binarySearchTreeBased(input, input.length);
    }

    private int _binarySearchTreeBased(int[] input, int m) {
        int[] tail = new int[m];
        int tailIndex = 1;
        tail[0] = input[0];
        for (int i = 1; i < m; i++) {
            if (input[i] > tail[tailIndex - 1]) {
                tail[tailIndex] = input[i];
                tailIndex = tailIndex + 1;
            } else {
                int ceilIndex = ceilIndex(tail, 0, tailIndex - 1, input[i]);
                tail[ceilIndex] = input[i];
            }
        }
        return tailIndex;
    }


    private int ceilIndex(int[] lis, int start, int end, int value) {
        int l = start;
        int r = end;
        while (r > l) {
            int mid = (r - l) / 2;
            if (lis[mid] >= value) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    public int tabulation(int[] input) {
        return tabulation(input, input.length);
    }

    private int tabulation(int[] input, int m) {
        int[] lis = new int[m];
        lis[0] = 1;

        for (int i = 1; i < m; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (input[j] < input[i]) {
                    lis[i] =  Math.max(lis[i], lis[j]+1);
                }
            }
        }

        int longestIncreasingSequence = lis[0];
        for (int i = 1; i < lis.length; i++) {
            longestIncreasingSequence = Math.max(longestIncreasingSequence, lis[i]);
        }
        return longestIncreasingSequence;
    }
}
