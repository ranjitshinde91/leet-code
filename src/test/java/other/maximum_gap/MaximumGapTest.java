package other.maximum_gap;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MaximumGapTest {

  @ParameterizedTest
  @MethodSource("inputs")
  void test1(int[] input, int expected) {
    var maximumGap = new MaximumGap();

    int maxGap = maximumGap.maximumGap(input);

    assertThat(maxGap).isEqualTo(expected);
  }

  private static Stream<Arguments> inputs() {
    return Stream.of(
        Arguments.of(new int[] {3, 6, 9, 1}, 3),
        Arguments.of(new int[] {21, 9, 25, 3, 37, 43, 49, 29}, 12),
        Arguments.of(new int[] {100, 3, 2, 1}, 97),
        Arguments.of(new int[] {2, 99999999}, 99999997));
  }
}
