package sorting.problems.sort_an_array_with_three_types;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SortAnArrayWithThreeTypesTest {

    @ParameterizedTest
    @MethodSource("inputs")
    public void test(int[] input, int[] expected) {
        var sortAnArrayWithThreeTypes = new SortAnArrayWithThreeTypes();

        sortAnArrayWithThreeTypes.sort(input, input.length);

        assertThat(input).containsExactly(expected);
    }

    public static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(
                        new int[]{0, 1, 2, 2, 0, 1, 0},
                        new int[]{0, 0, 0, 1, 1, 2, 2}
                )
        );
    }
}