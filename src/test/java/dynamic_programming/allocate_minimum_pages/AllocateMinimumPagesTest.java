package dynamic_programming.allocate_minimum_pages;

import dynamic_programming.binary_knapsack.BinaryKnapsack;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AllocateMinimumPagesTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void memoization(int[] pages, int numberOfStudents, int expected) {
        var allocateMinimumPages = new AllocateMinimumPages();

        int output = allocateMinimumPages.memoization(pages, numberOfStudents);

        assertThat(output).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("inputs")
    void tabulation(int[] pages, int numberOfStudents, int expected) {
        var allocateMinimumPages = new AllocateMinimumPages();

        long output = allocateMinimumPages.tabulation(pages, numberOfStudents);

        assertThat(output).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{10, 20, 30, 40}, 2, 60),
                Arguments.of(new int[]{10, 20, 30}, 1, 60),
                Arguments.of(new int[]{10, 5, 30, 1, 2, 5, 10, 10}, 3, 30)
        );
    }

}