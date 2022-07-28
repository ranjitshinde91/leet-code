package sorting.algorithms.index_based.count_sort;

public class CountSort {


    public void countSort(int[] input, int n) {
        countSort(input, n, 1);
    }

    public void countSort(int[] input, int n, int exp) {
        int k = maxOf(input, n);
        int l = minOf(input, n);
        System.out.println(l);
        int[] count = new int[k - l + 1];
        int[] output = new int[n];

        for (int i = 0; i <= k - l; i++) {
            count[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            int element = getElement(input[i], l, exp);
            count[element] = count[element] + 1;
        }
        for (int i = 1; i <= k - l; i++) {
            count[i] = count[i] + count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int element = getElement(input[i], l, exp);
            output[count[element] - 1] = input[i];
            count[element] = count[element] - 1;
        }

        for (int i = 0; i < n; i++) {
            input[i] = output[i];
        }
    }

    private int getElement(int input, int l, int exp) {
        return ((input - l) / exp) % 10;
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

    private int minOf(int[] input, int n) {
        int max = input[0];
        for (int i = 1; i < n; i++) {
            if (max > input[i]) {
                max = input[i];
            }
        }
        return max;
    }

    public static String countSort(String str)
    {
        StringBuilder output = new StringBuilder();
        int[] count = new int[25];

        for(int i=0;i<str.length();i++){
            int index = str.charAt(i)-97;
            count[index] = count[index]+1;
        }

        for(int i=0;i<25;i++){
            while(count[i]>0){
                char ch = (char)(i+97);
                output.append(ch);
                count[i] = count[i]-1;
            }
        }
        return output.toString();
    }

}
