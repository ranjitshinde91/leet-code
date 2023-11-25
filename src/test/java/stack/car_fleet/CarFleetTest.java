package stack.car_fleet;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarFleetTest {

  @ParameterizedTest
  @MethodSource("inputs")
  void test(int target, int[] position, int[] speed, int expected) {
    var carFleet = new CarFleet();

    int numberOfCarFleet = carFleet.carFleet(target, position, speed);

    assertThat(numberOfCarFleet).isEqualTo(expected);
  }

  private static Stream<Arguments> inputs() {
    return Stream.of(
        Arguments.of(12, new int[] {10, 8, 0, 5, 3}, new int[] {2, 4, 1, 1, 3}, 3),
        Arguments.of(10, new int[] {3}, new int[] {3}, 1),
        Arguments.of(
            100,
            new int[] {0, 2, 4},
            new int[] {
              4, 2, 1,
            },
            1),
        Arguments.arguments(10, new int[] {6, 8}, new int[] {3, 2}, 2),
        Arguments.arguments(10, new int[] {8, 3, 7, 4, 6, 5}, new int[] {4, 4, 4, 4, 4, 4}, 6));
  }
}
