package stack.largest_rectangular_area;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LargestRectangularAreaTest {


    @ParameterizedTest
    @MethodSource("inputs")
    void test1(long[] input, long expected) {
        var largestRectangularArea = new LargestRectangularArea();

        long largestArea = largestRectangularArea.calculateArea(input);

        assertThat(largestArea).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new long[]{6, 2, 5, 4, 1, 5, 6}, 10),
                Arguments.of(new long[]{2, 5, 1}, 5)
        );
    }

}