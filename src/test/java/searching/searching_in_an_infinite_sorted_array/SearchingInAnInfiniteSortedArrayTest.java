package searching.searching_in_an_infinite_sorted_array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SearchingInAnInfiniteSortedArrayTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(int[] input, int element, int expected) {

        Solution solution = new Solution();

        int numberOfElementsInIntersection = solution.searchInSorted(input, element);

        assertThat(numberOfElementsInIntersection).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{1, 10, 15, 20, 60, 80, 90, 100, 120, 500, 600, 700, 800, 900}, 100, 7),
                Arguments.of(new int[]{1, 10, 15, 20, 60, 80, 90, 100, 120, 500, 600, 700, 800, 900}, 1, 0),
                Arguments.of(new int[]{20, 40, 100, 300, 400, 500, 600}, 50, -1)
        );
    }


}