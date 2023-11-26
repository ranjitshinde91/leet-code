package binary_search.find_minimum_in_rotated_sorted_array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FindMinimumInRotatedSortedArrayTest {

  @ParameterizedTest
  @MethodSource("inputs")
  void test(int[] input, int expected) {
    var findMinimumInRotatedSortedArray = new FindMinimumInRotatedSortedArray();

    int minimum = findMinimumInRotatedSortedArray.findMin(input);

    assertThat(minimum).isEqualTo(expected);
  }

  private static Stream<Arguments> inputs() {
    return Stream.of(
        Arguments.of(new int[] {3, 4, 5, 1, 2}, 1),
        Arguments.of(new int[] {4, 5, 6, 7, 0, 1, 2}, 0),
        Arguments.of(new int[] {11, 13, 15, 17}, 11));
  }
}
