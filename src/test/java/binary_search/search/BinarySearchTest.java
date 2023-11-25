package binary_search.search;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BinarySearchTest {

  @ParameterizedTest
  @MethodSource("inputs")
  void test(int[] input, int target, int expected) {
    var binarySearch = new BinarySearch();

    int result = binarySearch.binarySearch(input, target);

    assertThat(result).isEqualTo(expected);
  }

  private static Stream<Arguments> inputs() {
    return Stream.of(
        Arguments.of(new int[] {-1, 0, 3, 5, 9, 12}, 9, 4),
        Arguments.of(new int[] {-1, 0, 3, 5, 9, 12}, 2, -1));
  }
}
