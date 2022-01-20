package hashing.two_arrays_are_equal_or_not;

import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
    //Function to check if two arrays are equal or not.
    public static boolean check(long[] a, long[] b, int n) {
        Map<Long, Integer> objectObjectLinkedHashMap = new LinkedHashMap<>();

        for (long element : a) {
            int count = 1;
            if (objectObjectLinkedHashMap.containsKey(element)) {
                count = objectObjectLinkedHashMap.get(element) + 1;
            }
            objectObjectLinkedHashMap.put(element, count);
        }
        for (long element : b) {
            if (!objectObjectLinkedHashMap.containsKey(element)) {
                return false;
            }
            objectObjectLinkedHashMap.put(element, objectObjectLinkedHashMap.get(element) - 1);
        }
        return objectObjectLinkedHashMap
                .values()
                .stream()
                .filter(it -> it != 0)
                .findFirst()
                .isEmpty();
    }
}

