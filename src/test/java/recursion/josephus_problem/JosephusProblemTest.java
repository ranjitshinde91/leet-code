package recursion.josephus_problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class JosephusProblemTest {
    @ParameterizedTest
    @MethodSource("inputs")
    void test1(int n, int k, int expected) {
        var josephusProblem = new JosephusProblem();

        var index = josephusProblem.kill(n, k);

        assertThat(index).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(7, 3, 3),
                Arguments.of(4, 2, 0)
        );
    }

}