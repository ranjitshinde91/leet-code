package two_pointer.three_sum;

import java.util.*;

// leetcode-15: 3Sum
public class ThreeSum {

  public List<List<Integer>> threeSumNaive(int[] nums) {

    Map<String, List<Integer>> triplets = new HashMap<>();
    for (int i = 0; i < nums.length - 2; i++) {
      for (int j = i + 1; j < nums.length - 1; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          if (nums[i] + nums[j] + nums[k] == 0) {
            ArrayList<Integer> value = new ArrayList<>();
            value.add(nums[i]);
            value.add(nums[j]);
            value.add(nums[k]);
            triplets.putIfAbsent(getKey(nums[i], nums[j], nums[k]), value);
          }
        }
      }
    }
    return new ArrayList<>(triplets.values());
  }

  private static String getKey(int i, int j, int k) {
    return Arrays.stream(new int[] {i, j, k})
        .sorted()
        .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
        .toString();
  }

  public List<List<Integer>> threeSum(int[] nums) {

    Arrays.sort(nums);

    List<List<Integer>> triplets = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int j = i + 1;
      int k = nums.length - 1;
      int target = -nums[i];
      while (j < k) {
        if (nums[j] + nums[k] == target) {
          List<Integer> triplet = new ArrayList<>();
          triplet.add(nums[i]);
          triplet.add(nums[j]);
          triplet.add(nums[k]);
          triplets.add(triplet);

          j++;
          k--;
          while (j < k && nums[j] == nums[j - 1]) {
            j++;
          }
          while (j < k && nums[k] == nums[k + 1]) {
            k--;
          }
        } else if (nums[j] + nums[k] > target) {
          k--;
        } else {
          j++;
        }
      }
    }
    return triplets;
  }
}
