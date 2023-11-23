package two_pointer.container_with_most_water;

import java.util.LinkedList;

// leetcode-11 : Container With Most Water
public class ContainerWithMostWater {

  public int maxArea(int[] height) {

    int i = 0;
    int j = height.length - 1;

    int maxArea = 0;
    while (i < j) {
      maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
      if (height[i] < height[j]) {
        i++;
      } else {
        j--;
      }
    }
    return maxArea;
  }
}
