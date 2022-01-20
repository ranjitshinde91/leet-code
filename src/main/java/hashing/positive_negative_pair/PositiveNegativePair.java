package hashing.positive_negative_pair;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    //Function to return list containing all the pairs having both
    //negative and positive values of a number in the array.
    public ArrayList<Integer> findPairs(int[] arr, int n) {

        HashMap<Integer, Boolean> uniqueElements = new LinkedHashMap<>();

        for (int element : arr) {
            if (uniqueElements.containsKey(element * -1)) {
                uniqueElements.put(element * -1, true);
            } else {
                uniqueElements.put(element, false);
            }
        }
        return (ArrayList<Integer>) uniqueElements
                .entrySet()
                .stream()
                .filter(Map.Entry::getValue)
                .flatMap(it -> Stream.of(it.getKey(), it.getKey() * -1))
                .collect(Collectors.toList());
    }
}
