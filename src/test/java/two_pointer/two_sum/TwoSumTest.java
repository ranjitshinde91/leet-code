package two_pointer.two_sum;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TwoSumTest {

  @Test
  void test1() {
    var twoSum = new TwoSum();

    int[] ints = twoSum.twoSum(new int[] {2, 7, 11, 15}, 9);

    assertThat(ints[0]).isEqualTo(1);
    assertThat(ints[1]).isEqualTo(2);
  }

  @Test
  void test2() {
    var twoSum = new TwoSum();

    int[] ints = twoSum.twoSum(new int[] {2, 3, 4}, 6);

    assertThat(ints[0]).isEqualTo(1);
    assertThat(ints[1]).isEqualTo(3);
  }

  @Test
  void test3() {
    var twoSum = new TwoSum();

    int[] ints = twoSum.twoSum(new int[] {3, 3}, 6);

    assertThat(ints[0]).isEqualTo(1);
    assertThat(ints[1]).isEqualTo(2);
  }
}
