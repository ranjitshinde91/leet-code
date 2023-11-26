package binary_search.find_minimum_in_rotated_sorted_array;

// leetcode-153: Find Minimum in Rotated Sorted Array
public class FindMinimumInRotatedSortedArray {
  public int findMin(int[] nums) {
    int low = 0;
    int high = nums.length - 1;
    int min = Integer.MAX_VALUE;

    while (low <= high) {
      if (nums[low] <= nums[high]) {
        return Math.min(min, nums[low]);
      }
      int mid = low + (high - low) / 2;
      if (nums[low] <= nums[mid]) {
        min = Math.min(min, nums[low]);
        low = mid + 1;
      } else {
        min = Math.min(min, nums[mid]);
        low = low + 1;
      }
    }
    return min;
  }
}
