package searching.square_root_of_a_number;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SquareRootOfNumberTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(long input, int expected) {

        Solution solution = new Solution();

        long floorSqrt = solution.floorSqrt(input);

        assertThat(floorSqrt).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(5, 2),
                Arguments.of(4, 2),
                Arguments.of(9, 3),
                Arguments.of(10, 3),
                Arguments.of(16, 4),
                Arguments.of(15, 3),
                Arguments.of(17, 4)
        );
    }

}