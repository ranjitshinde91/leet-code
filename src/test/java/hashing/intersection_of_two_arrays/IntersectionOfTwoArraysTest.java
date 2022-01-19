package hashing.intersection_of_two_arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class IntersectionOfTwoArraysTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(int[] input1, int[] input2, int expected) {

        Solution solution = new Solution();

        int numberOfElementsInIntersection = solution.numberofElementsInIntersection(input1, input2, input1.length, input2.length);

        assertThat(numberOfElementsInIntersection).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{89, 24, 75, 11, 23}, new int[]{89, 2, 4}, 1),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, new int[]{3, 4, 5, 6, 7}, 4)
        );
    }
}