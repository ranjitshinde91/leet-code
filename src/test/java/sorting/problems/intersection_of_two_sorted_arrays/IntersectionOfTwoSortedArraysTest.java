package sorting.problems.intersection_of_two_sorted_arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class IntersectionOfTwoSortedArraysTest {

    @ParameterizedTest
    @MethodSource("inputs")
    public void test(int[] input1, int[] input2, ArrayList<Integer> intersection) {
        var intersectionOfTwoSortedArrays = new IntersectionOfTwoSortedArrays();

        ArrayList<Integer> result = intersectionOfTwoSortedArrays.printIntersection(input1, input2, input1.length, input2.length);

        assertThat(result).containsExactlyElementsOf(intersection);
    }

    public static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3, 4},
                        new int[]{2, 4, 6, 7, 8},
                        new ArrayList<>(List.of(2, 4))
                ),
                Arguments.of(
                        new int[]{1, 2, 2, 3, 4},
                        new int[]{2, 2, 4, 6, 7, 8},
                        new ArrayList<>(List.of(2, 4))
                ),
                Arguments.of(
                        new int[]{1, 2},
                        new int[]{3, 4},
                        new ArrayList<>(List.of(-1))
                )
        );
    }
}