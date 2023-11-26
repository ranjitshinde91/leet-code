package binary_search.median_of_two_sorted_arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MedianOfTwoSortedArraysTest {

  @Test
  void test() {

    var medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();

    double result = medianOfTwoSortedArrays.findMedianSortedArrays(new int[] {1, 3}, new int[] {2});

    assertThat(result).isEqualTo(2.0);
  }
}
