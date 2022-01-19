package hashing.positive_negative_pair;


import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    //Function to return list containing all the pairs having both
    //negative and positive values of a number in the array.
    public ArrayList<Integer> findPairs(int[] arr, int n) {

        ArrayList<Integer> pairs = new ArrayList<>();
        HashSet<Integer> uniqueElements = new HashSet<>();

        for (int element : arr) {
            if (uniqueElements.contains(element * -1)) {
                pairs.add(element);
                pairs.add(element * -1);
            } else {
                uniqueElements.add(element);
            }
        }
        return pairs;
    }
}
