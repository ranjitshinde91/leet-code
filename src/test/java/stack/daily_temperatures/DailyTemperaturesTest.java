package stack.daily_temperatures;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DailyTemperaturesTest {

  @ParameterizedTest
  @MethodSource("inputs")
  void test(int[] input, int[] expected) {

    var dailyTemperatures = new DailyTemperatures();

    int[] ints = dailyTemperatures.dailyTemperatures(input);

    assertThat(ints).containsExactly(expected);
  }

  private static Stream<Arguments> inputs() {
    return Stream.of(
        Arguments.of(
            new int[] {73, 74, 75, 71, 69, 72, 76, 73}, new int[] {1, 1, 4, 2, 1, 1, 0, 0}),
        Arguments.of(new int[] {30, 40, 50, 60}, new int[] {1, 1, 1, 0}),
        Arguments.of(
            new int[] {89, 62, 70, 58, 47, 47, 46, 76, 100, 70},
            new int[] {8, 1, 5, 4, 3, 2, 1, 1, 0, 0}));
  }
}
