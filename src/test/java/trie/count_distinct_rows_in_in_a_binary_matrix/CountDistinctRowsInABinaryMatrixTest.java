package trie.count_distinct_rows_in_in_a_binary_matrix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CountDistinctRowsInABinaryMatrixTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(int[][] input, int expected) {
        var subject = new CountDistinctRowsInABinaryMatrix();

        int output = subject.count(input);

        assertThat(output).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[][]{
                                {1, 0, 0},
                                {1, 1, 1},
                                {1, 0, 0},
                                {1, 1, 1}},
                        2),
                Arguments.of(new int[][]{
                                {1, 1, 0, 0},
                                {1, 1, 0, 0},
                                {1, 1, 0, 0},
                                {1, 1, 0, 0}},
                        1)
        );
    }

}