package binary_search.search;

// leetcode-704: Binary Search
public class BinarySearch {

  public int binarySearch(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }
}
