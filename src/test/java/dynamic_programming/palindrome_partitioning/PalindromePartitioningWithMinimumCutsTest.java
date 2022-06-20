package dynamic_programming.palindrome_partitioning;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PalindromePartitioningWithMinimumCutsTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void memoization(String string, int expected) {
        var palindromePartitioningWithMinimumCuts = new PalindromePartitioningWithMinimumCuts();

        var output = palindromePartitioningWithMinimumCuts.memoization(string);

        assertThat(output).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("inputs")
    void tabulation(String string, int expected) {
        var palindromePartitioningWithMinimumCuts = new PalindromePartitioningWithMinimumCuts();

        var output = palindromePartitioningWithMinimumCuts.tabulation(string);

        assertThat(output).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of("geek", 2),
                Arguments.arguments("abba", 0),
                Arguments.arguments("abbac", 1),
                Arguments.arguments("abcde", 4),
                Arguments.arguments("aaaa", 0),
                Arguments.arguments("abbabbc", 2)
        );
    }
}