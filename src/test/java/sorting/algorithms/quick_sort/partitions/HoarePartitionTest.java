package sorting.algorithms.quick_sort.partitions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class HoarePartitionTest {

    @ParameterizedTest
    @MethodSource("inputs")
    public void test(int[] input, int low, int high, int p, int expected) {

        var hoarePartition = new HoarePartition();

        int pivotElement = hoarePartition.partition(input, low, high, p);

        assertThat(pivotElement).isEqualTo(expected);
    }

    public static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(
                        new int[]{2, 7, 8, 3, 7},
                        0,
                        4,
                        1,
                        2
                ),
                Arguments.of(
                        new int[]{5, 3, 12, 8, 5},
                        0,
                        4,
                        0,
                        1
                ),
                Arguments.of(
                        new int[]{5, 3, 12, 8, 5, 5},
                        0,
                        5,
                        0,
                        2
                ),
                Arguments.of(
                        new int[]{70, 60, 80, 40, 30},
                        0,
                        4,
                        4,
                        0
                ),
                Arguments.of(
                        new int[]{30, 40, 20, 50, 80},
                        0,
                        4,
                        4,
                        3
                ),
                Arguments.of(
                        new int[]{5, 3, 8, 4, 2, 7, 1, 10},
                        0,
                        7,
                        1,
                        1
                )
        );
    }
}

