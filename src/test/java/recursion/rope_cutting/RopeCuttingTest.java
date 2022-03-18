package recursion.rope_cutting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RopeCuttingTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(int lengthOfRope, int a, int b, int c, int expected) {
        var ropeCutting = new RopeCutting();

        int maxNumberOfPieces = ropeCutting.maxNumberOfPieces(lengthOfRope, a, b, c);

        assertThat(maxNumberOfPieces).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(5, 2, 5, 1, 5),
                Arguments.of(23, 12, 9, 11, 2),
                Arguments.of(5, 4, 2, 6, -1)
        );
    }

}