package dynamic_programming.edit_distance;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class EditDistanceTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void memoization(String first, String second, long expected) {
        var editDistance = new EditDistance();

        int output = editDistance.memoization(first, second);

        assertThat(output).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of("CAT", "CUT", 1),
                Arguments.of("GEEK", "GEEKS", 1),
                Arguments.of("SUNDAY", "SATURDAY", 3),
                Arguments.of("AB", "BC", 2)
        );
    }

    @ParameterizedTest
    @MethodSource("inputs")
    void tabulation(String first, String second, long expected) {
        var editDistance = new EditDistance();

        int output = editDistance.tabulation(first, second);

        assertThat(output).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("inputs")
    void tabulationWithSpaceOptimization(String first, String second, long expected) {
        var editDistance = new EditDistance();

        int output = editDistance.tabulationWithSpaceOptimization(first, second);

        assertThat(output).isEqualTo(expected);
    }

}