package other.first_and_last_position;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1 && nums[0] == target) {
            return new int[]{0, 0};
        }
        int i = 0;
        int j = nums.length - 1;
        int firstPosition = -1;

        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                if (i == j) {
                    firstPosition = mid;
                    break;
                }
                j = mid;
            }
            if (nums[mid] > target) {
                j = mid - 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            }
        }
        if (firstPosition != -1) {
            int lastPosition = firstPosition;
            for (int k = firstPosition; (k < nums.length && nums[k] == target); k++) {
                lastPosition = k;
            }
            return new int[]{firstPosition, lastPosition};
        }

        return new int[]{-1, -1};

    }
}
