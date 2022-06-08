package other.combination_sum_4;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private final Map<String, Integer> cache;

    public Solution() {
        this.cache = new HashMap<>();
    }

    public int combinationSum4(int[] nums, int target) {
        if (target < 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }
        String key = key(nums, target);
        if (this.cache.containsKey(key)) {
            return this.cache.get(key);
        }
        int total = 0;
        for (int num : nums) {
            total += combinationSum4(nums, target - num);
        }
        this.cache.put(key, total);
        return total;
    }

    private String key(int[] nums, int target) {
        StringBuilder key = new StringBuilder(String.valueOf(target));
        for (int num : nums) {
            key.append(":").append(num);
        }
        return key.toString();
    }
}