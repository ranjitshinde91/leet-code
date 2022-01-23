package searching.searching_in_a_sorted_array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SearchingAnElementInSortedArrayTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(int[] input, int element, int expected) {

        Solution solution = new Solution();

        int numberOfElementsInIntersection = solution.searchInSorted(input, element);

        assertThat(numberOfElementsInIntersection).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{1}, 1, 1),
                Arguments.of(new int[]{1}, 2, -1),
                Arguments.of(new int[]{1, 2, 3, 4, 6}, 6, 1),
                Arguments.of(new int[]{1, 3, 4, 5, 6}, 2, -1)
        );
    }

}