package two_pointer.container_with_most_water;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ContainerWithMostWaterTest {

  @ParameterizedTest
  @MethodSource("inputs")
  void test1(int[] input, int expected) {

    var containerWithMostWater = new ContainerWithMostWater();

    int maxArea = containerWithMostWater.maxArea(input);

    assertThat(maxArea).isEqualTo(expected);
  }

  public static Stream<Arguments> inputs() {
    return Stream.of(
        Arguments.of(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
        Arguments.of(new int[] {1, 1}, 1),
        Arguments.of(new int[] {1, 0, 8, 1, 8}, 16),
        Arguments.of(new int[] {1, 0, 8, 1, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 17),
        Arguments.of(new int[] {1, 0, 8, 1, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7}, 105),
        Arguments.of(new int[] {1, 3, 2, 1}, 3));
  }
}
