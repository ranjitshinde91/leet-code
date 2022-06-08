package other.combination_sum;

import java.util.*;

class Solution {

    private final Map<String, List<List<Integer>>> cache;

    Solution() {
        cache = new HashMap<>();
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        if (target == 0) {
            List<List<Integer>> combinations = new ArrayList<>();
            combinations.add(new ArrayList<>());
            return combinations;
        }
        String key = key(nums, target);
        if (this.cache.containsKey(key)) {
            return copy(this.cache.get(key));

        }
        List<List<Integer>> combinations = new ArrayList<>();
        for (int num : nums) {
            if (target - num >= 0) {
                var temp = combinationSum(nums, target - num);
                for (var combination : temp) {
                    combination.add(num);
                    if (!contains(combinations, combination)) {
                        combinations.add(combination);
                    }
                }
            }
        }
        this.cache.put(key, copy(combinations));
        return combinations;
    }

    private List<List<Integer>> copy(List<List<Integer>> lists) {
        List<List<Integer>> temp = new ArrayList<>();
        for (var item : lists) {
            temp.add(new ArrayList<>(item));
        }
        return temp;
    }

    private boolean contains(List<List<Integer>> lists, List<Integer> element) {
        for (var item : lists) {
            if (item.size() == element.size()
                    && item.containsAll(element)
                    && element.containsAll(item)) {
                return true;
            }
        }
        return false;
    }


    private String key(int[] nums, int target) {
        StringBuilder key = new StringBuilder(String.valueOf(target));
        for (int num : nums) {
            key.append(":").append(num);
        }
        return key.toString();
    }
}