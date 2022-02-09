package stack.stock_span_problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StockSpanProblemTest {


    @ParameterizedTest
    @MethodSource("inputs")
    void test1(int[] input, int[] expected) {
        Solution solution = new Solution();

        int[] span = solution.calculateSpan(input, input.length);

        assertThat(span).containsExactly(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new int[]{100, 80, 60, 70, 60, 75, 85}, new int[]{1, 1, 1, 2, 1, 4, 6}),
                Arguments.of(new int[]{10, 4, 5, 90, 120, 80}, new int[]{1, 1, 2, 4, 5, 1}),
                Arguments.of(new int[]{10, 4, 3}, new int[]{1, 1, 1}),
                Arguments.of(new int[]{10, 15, 20}, new int[]{1, 2, 3}),
                Arguments.of(new int[]{10, 30, 20}, new int[]{1, 2, 1}),
                Arguments.of(new int[]{10}, new int[]{1}),
                Arguments.of(
                        new int[]{74, 665, 742, 512, 254, 469, 748, 445, 663, 758, 38, 60, 724, 142, 330, 779, 317, 636, 591, 243, 289, 507, 241, 143, 65, 249, 247, 606, 691, 330, 371, 151, 607, 702, 394, 349, 430, 624, 85, 755, 357, 641, 167, 177, 332, 709, 145, 440, 627, 124, 738, 739, 119, 483, 530, 542, 34, 716, 640, 59, 305, 331, 378, 707, 474, 787, 222, 746, 525, 673, 671, 230, 378, 374, 298, 513, 787, 491, 362, 237, 756, 768, 456, 375, 32, 53, 151, 351, 142, 125, 367, 231, 708, 592, 408, 138, 258, 288, 554, 784, 546, 110, 210, 159, 222, 189, 23, 147, 307, 231, 414, 369, 101, 592, 363, 56, 611, 760, 425, 538, 749, 84, 396, 42, 403, 351, 692, 437, 575, 621, 597, 22, 149, 800},
                        new int[]{1, 2, 3, 1, 1, 2, 7, 1, 2, 10, 1, 2, 3, 1, 2, 16, 1, 2, 1, 1, 2, 3, 1, 1, 1, 4, 1, 10, 13, 1, 2, 1, 4, 18, 1, 1, 3, 4, 1, 24, 1, 2, 1, 2, 3, 6, 1, 2, 3, 1, 11, 12, 1, 2, 3, 4, 1, 6, 1, 1, 2, 3, 4, 6, 1, 66, 1, 2, 1, 2, 1, 1, 2, 1, 1, 5, 77, 1, 1, 1, 4, 5, 1, 1, 1, 2, 3, 4, 1, 1, 7, 1, 11, 1, 1, 1, 2, 3, 5, 23, 1, 1, 2, 1, 4, 1, 1, 2, 8, 1, 10, 1, 1, 14, 1, 1, 17, 18, 1, 2, 3, 1, 2, 1, 4, 1, 6, 1, 2, 3, 1, 1, 2, 134})
        );
    }

}