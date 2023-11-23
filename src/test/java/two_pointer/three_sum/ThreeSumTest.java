package two_pointer.three_sum;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class ThreeSumTest {

  @Test
  void test1() {
    var threeSum = new ThreeSum();

    List<List<Integer>> triplets = threeSum.threeSum(new int[] {-1, 0, 1, 2, -1, -4});

    assertThat(triplets)
        .containsExactlyInAnyOrderElementsOf(List.of(List.of(-1, -1, 2), List.of(-1, 0, 1)));
  }

  @Test
  void test2() {
    var threeSum = new ThreeSum();

    List<List<Integer>> triplets = threeSum.threeSum(new int[] {-2, 0, 0, 2, 2});

    assertThat(triplets).containsExactlyInAnyOrderElementsOf(List.of(List.of(-2, 0, 2)));
  }

  @Test
  void test3() {
    var threeSum = new ThreeSum();

    List<List<Integer>> triplets = threeSum.threeSum(new int[] {3, 0, -2, -1, 1, 2});

    assertThat(triplets)
        .containsExactlyInAnyOrderElementsOf(
            List.of(List.of(-2, -1, 3), List.of(-2, 0, 2), List.of(-1, 0, 1)));
  }
}
