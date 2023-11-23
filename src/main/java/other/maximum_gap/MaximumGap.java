package other.maximum_gap;

public class MaximumGap {
  public int maximumGap(int[] nums) {

    if (nums.length < 2) {
      return 0;
    }

    int minElement = nums[0];
    int maxElement = nums[0];

    for (int i = 1; i < nums.length; i++) {
      minElement = Math.min(nums[i], minElement);
      maxElement = Math.max(nums[i], maxElement);
    }
    int bucketSize = (int) Math.ceil((maxElement - minElement) / (double) (nums.length - 1));

    Bucket[] buckets = new Bucket[nums.length - 1];

    for (int num : nums) {
      if (num == minElement || num == maxElement) {
        continue;
      }
      int bucketNumber = (num - minElement) / bucketSize;
      Bucket bucket = buckets[bucketNumber];
      if (bucket == null) {
        buckets[bucketNumber] = new Bucket(num);
      } else {
        bucket.min = Math.min(num, bucket.min);
        bucket.max = Math.max(num, bucket.max);
      }
    }

    int maxGap = -1;
    for (Bucket bucket : buckets) {
      System.out.println(bucket);
      if (bucket == null) {
        continue;
      }
      maxGap = Math.max(maxGap, bucket.min - minElement);
      minElement = bucket.max;
    }
    return Math.max(maxGap, maxElement - minElement);
  }
}

class Bucket {
  public int min;
  public int max;

  Bucket(int value) {
    this.min = value;
    this.max = value;
  }

  @Override
  public String toString() {
    return "Bucket{" +
            "min=" + min +
            ", max=" + max +
            '}';
  }
}
