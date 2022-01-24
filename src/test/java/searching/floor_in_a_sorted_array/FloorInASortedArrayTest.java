package searching.floor_in_a_sorted_array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FloorInASortedArrayTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(long[] input, int element, int expected) {

        Solution solution = new Solution();

        int floor = solution.findFloor(input, input.length, element);

        assertThat(floor).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new long[]{1, 2, 8, 10, 11, 12, 19}, 0, -1),
                Arguments.of(new long[]{1, 2, 8, 10, 11, 12, 19}, 1, 0),
                Arguments.of(new long[]{1, 2, 8, 10, 11, 12, 19}, 5, 1),
                Arguments.of(new long[]{66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130}, 106, 40)
        );
    }
}