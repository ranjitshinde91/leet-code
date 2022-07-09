package binary_search_tree.ceiling_on_left_side;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Java6Assertions.assertThat;

class CeilingOnLeftSideTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(int[] input, int[] expected) {
        var ceilingOnLeftSide = new CeilingOnLeftSide();

        int[] output = ceilingOnLeftSide.ceil(input);

        assertThat(output).containsExactly(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{2, 8, 30, 15, 25, 12}, new int[]{-1, -1, -1, 30, 30, 15}),
                Arguments.of(new int[]{30, 20, 10}, new int[]{-1, 30, 20}),
                Arguments.of(new int[]{10, 20, 30}, new int[]{-1, -1, -1})
        );
    }

}