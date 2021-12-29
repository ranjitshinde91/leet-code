package combination_sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    private final Map<String, List<List<Integer>>> cache;

    Solution() {
        cache = new HashMap<>();
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        String key = key(nums, target);
        if (this.cache.containsKey(key)) {
            return this.cache.get(key);
        }
        List<List<Integer>> combinations = new ArrayList<>();
        for (int num : nums) {
            if (target - num == 0) {
                List<Integer> objects = new ArrayList<>();
                objects.add(num);
                combinations.add(objects);
                return combinations;
            } else if (target - num > 0) {
                var temp = combinationSum(nums, target - num);
                for (var combination : temp) {
                    combination.add(num);
                    if (!contains(combinations, combination)) {
                        combinations.add(combination);
                    }
                }
            }
        }
        this.cache.put(key, combinations);
        return combinations;
    }

    private boolean contains(List<List<Integer>> lists2, List<Integer> element) {
        for (var item : lists2) {
            if (item.containsAll(element)) {
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