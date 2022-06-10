package backtracking.n_queen_problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NQueenProblemTest {
    @ParameterizedTest
    @MethodSource("inputs")
    void test1(int n, boolean expected) {
        var nQueenProblem = new NQueenProblem(n);

        boolean canPlace = nQueenProblem.canPlace();

        assertThat(canPlace).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(3, false),
                Arguments.of(4, true),
                Arguments.of(5, true),
                Arguments.of(6, true),
                Arguments.of(7, true)
        );
    }


}