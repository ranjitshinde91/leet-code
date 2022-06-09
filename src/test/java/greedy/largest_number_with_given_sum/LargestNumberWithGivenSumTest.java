package greedy.largest_number_with_given_sum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LargestNumberWithGivenSumTest {
    @ParameterizedTest
    @MethodSource("inputs")
    void test1(int numberOfDigits, int sum, String expected) {
        var largestNumberWithGivenSum = new LargestNumberWithGivenSum();

        String output = largestNumberWithGivenSum.largestNumber(numberOfDigits, sum);

        assertThat(output).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(5, 12, "93000"),
                Arguments.of(3, 29, "-1")
        );
    }

}