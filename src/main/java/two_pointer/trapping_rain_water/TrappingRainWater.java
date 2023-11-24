package two_pointer.trapping_rain_water;

// leetcode-42: Trapping Rain Water
public class TrappingRainWater {

  public int trap1(int[] height) {
    int maxLeft = 0;
    int trappedWater = 0;

    int[] rightMax = new int[height.length];
    rightMax[height.length - 1] = 0;
    int maxRight = height[height.length - 1];
    for (int i = height.length - 2; i >= 0; i--) {
      rightMax[i] = maxRight;
      if (height[i] > maxRight) {
        maxRight = height[i];
      }
    }

    for (int i = 0; i < height.length - 1; i++) {
      int trappedAtIndex = Math.min(maxLeft, rightMax[i]) - height[i];
      trappedWater = trappedWater + Math.max(trappedAtIndex, 0);

      if (maxLeft < height[i]) {
        maxLeft = height[i];
      }
    }
    return trappedWater;
  }

  public int trap(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int leftMax = height[left];
    int rightMax = height[right];
    int res = 0;

    while (left < right) {
      if (leftMax < rightMax) {
        left++;
        leftMax = Math.max(leftMax, height[left]);
        res = res + leftMax - height[left];
      } else {
        right--;
        rightMax = Math.max(rightMax, height[right]);
        res = res + rightMax - height[right];
      }
    }
    return res;
  }
}
