package two_pointer.trapping_rain_water;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TrappingRainWaterTest {

  @ParameterizedTest
  @MethodSource("inputs")
  void test(int[] input, int expected) {
    var trappingRainWater = new TrappingRainWater();

    int trapped = trappingRainWater.trap(input);

    assertThat(trapped).isEqualTo(expected);
  }

  private static Stream<Arguments> inputs() {
    return Stream.of(
        Arguments.of(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 6),
        Arguments.of(new int[] {4, 2, 0, 3, 2, 5}, 9),
        Arguments.of(new int[] {4, 9, 0, 7, 2, 5}, 10),
        Arguments.of(new int[] {1, 3, 0, 2, 5}, 4));
  }
}
