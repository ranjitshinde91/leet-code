package sorting.problems.minimum_difference_in_a_array;

import java.util.Arrays;

public class MinimumDifferenceInArray {


    public int diff(int[] input, int n) {
        Arrays.sort(input);

        int diff = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            if(input[i]-input[i-1] < diff){
                diff = input[i]-input[i-1];
            }
        }
        return diff;
    }
}
