package hashing.two_arrays_are_equal_or_not;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TwoArraysAreEqualOrNotTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(long[] input1, long[] input2, boolean expected) {

        Solution solution = new Solution();

        boolean isEqual = solution.check(input1, input2, input1.length);

        assertThat(isEqual).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new long[]{1, 2, 5, 4, 0}, new long[]{2, 4, 5, 0, 1}, true),
                Arguments.of(new long[]{1, 2, 5}, new long[]{2, 4, 15}, false),
                Arguments.of(new long[]{20, 6, 17, 15, 19}, new long[]{6, 17, 20, 19, 19}, false),
                Arguments.of(new long[]{16, 1, 2, 14, 13, 17, 1}, new long[]{14, 1, 16, 2, 13, 2, 17}, false),
                Arguments.of(
                        new long[]{445, 627, 523, 466, 709, 417, 283, 259, 925, 638, 63, 625, 601, 37, 453, 900, 380, 551, 469, 72, 974, 132, 882, 931, 934, 895, 661, 164, 200, 982, 900, 997, 960, 774, 814, 669, 191},
                        new long[]{709, 900, 469, 37, 283, 417, 259, 132, 974, 814, 551, 466, 982, 627, 63, 669, 934, 625, 661, 960, 601, 380, 523, 200, 900, 191, 895, 774, 72, 997, 638, 931, 445, 925, 453, 164, 882},
                        true)
        );
    }


}