package stack.maximum_of_minimum_for_every_window_size;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import stack.largest_rectangular_area.LargestRectangularArea;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MaximumOfMinimumForEveryWindowSizeTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(int[] input, int[] expected) {
        var maximumOfMinimumForEveryWindowSize = new MaximumOfMinimumForEveryWindowSize();

        int[] output = maximumOfMinimumForEveryWindowSize.maxOfMin(input, input.length);

        assertThat(output).containsExactly(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{10, 20, 30, 50, 10, 70, 30}, new int[]{70, 30, 20, 10, 10, 10, 10}),
                Arguments.of(new int[]{10, 20, 30}, new int[]{30, 20, 10})
        );
    }


}