package two_pointer.two_sum;

// leetcode-167: Two Sum II - Input Array Is Sorted
class TwoSum {

  public int[] twoSum(int[] numbers, int target) {

    int i = 0;
    int j = numbers.length - 1;

    while (i <= j) {
      if (numbers[i] + numbers[j] == target) {
        return new int[] {i + 1, j + 1};
      }
      if (numbers[i] + numbers[j] > target) {
        j--;
      } else {
        i++;
      }
    }
    return new int[] {};
  }
}
