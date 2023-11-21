package searching.searching_in_a_sorted_rotated_array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SearchingInASortedRotatedArrayTest {


    @ParameterizedTest
    @MethodSource("inputs")
    void test1(int[] input, int element, int expected) {

        Solution solution = new Solution();

        int numberOfElementsInIntersection = solution.searchInSortedRotated(input, element);

        assertThat(numberOfElementsInIntersection).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{3, 1}, 1, 1),
                Arguments.of(new int[]{10, 20, 30, 40, 50}, 30, 2),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4),
                Arguments.of(new int[]{5, 1, 3}, 5, 0),
                Arguments.of(new int[]{5, 1, 2, 3, 4}, 1, 1),
                Arguments.of(new int[]{100, 200, 300, 10, 20}, 40, -1),
                Arguments.of(new int[]{100, 200, 300, 10, 20}, 20, 4),
                Arguments.of(new int[]{100, 200, 300, 400, 20, 30, 40}, 50, -1),
                Arguments.of(new int[]{100, 200, 300, 400, 20, 30, 40}, 40, 6),
                Arguments.of(new int[]{100, 200, 300, 400, 20, 30, 40}, 20, 4),
                Arguments.of(new int[]{100, 200, 300, 400, 20, 30, 40}, 100, 0),
                Arguments.of(new int[]{100, 200, 300, 400, 20, 30, 40}, 300, 2)
        );
    }
}