package binary_search.search_a_2d_matrix;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SearchA2DMatrixTest {

  @ParameterizedTest
  @MethodSource("inputs")
  void test(int[][] input, int target, boolean expected) {

    SearchA2DMatrix searchA2DMatrix = new SearchA2DMatrix();

    boolean isPresent = searchA2DMatrix.searchMatrix(input, target);

    assertThat(isPresent).isEqualTo(expected);
  }

  private static Stream<Arguments> inputs() {
    return Stream.of(
        Arguments.of(new int[][] {{1}}, 1, true),
        Arguments.of(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13, false),
        Arguments.of(new int[][] {{1}, {3}}, 3, true));
  }
}
