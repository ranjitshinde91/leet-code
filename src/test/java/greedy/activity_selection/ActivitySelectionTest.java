package greedy.activity_selection;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ActivitySelectionTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(int[] start, int[] end, int expected) {
        var activitySelection = new ActivitySelection();

        int output = activitySelection.activitySelection(start, end, start.length);

        assertThat(output).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{2, 1}, new int[]{2, 2}, 1),
                Arguments.of(new int[]{1, 3, 2, 5}, new int[]{2, 4, 3, 6}, 3),
                Arguments.of(new int[]{2, 1, 5, 6}, new int[]{3, 4, 8, 10}, 2),
                Arguments.of(new int[]{1, 2, 4, 10}, new int[]{3, 4, 8, 11}, 3)
        );
    }

}