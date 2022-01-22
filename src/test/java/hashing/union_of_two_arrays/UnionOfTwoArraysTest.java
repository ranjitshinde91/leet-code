package hashing.union_of_two_arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class UnionOfTwoArraysTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(int[] input1, int[] input2, int expected) {

        Solution solution = new Solution();

        int numberOfElementsInIntersection = solution.doUnion(input1, input2);

        assertThat(numberOfElementsInIntersection).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5}, 5)
        );
    }

}