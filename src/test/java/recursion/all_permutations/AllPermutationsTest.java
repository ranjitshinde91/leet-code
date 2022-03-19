package recursion.all_permutations;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

class AllPermutationsTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(String word, List<String> expected) {
        var allPermutations = new AllPermutations();

        var subsets = allPermutations.calculate(word);

        assertThat(subsets).containsAll(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of("", emptyList()),
                Arguments.of("AB", List.of("AB", "BA")),
                Arguments.of("ABC", List.of("ABC", "ACB", "BAC", "BCA", "CAB", "CBA"))
        );
    }


}