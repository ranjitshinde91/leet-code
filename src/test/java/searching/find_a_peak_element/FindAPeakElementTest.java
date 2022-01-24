package searching.find_a_peak_element;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindAPeakElementTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(int[] input, int expected) {

        Solution solution = new Solution();

        long floorSqrt = solution.findPeak(input);

        assertThat(floorSqrt).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{80}, 0),
                Arguments.of(new int[]{80, 90}, 1),
                Arguments.of(new int[]{5, 10, 20, 15, 7}, 2),
                Arguments.of(new int[]{10, 20, 15, 5, 23, 90, 67}, 1),
                Arguments.of(new int[]{80, 70, 60}, 0),
                Arguments.of(new int[]{1, 13}, 1)

        );
    }

}