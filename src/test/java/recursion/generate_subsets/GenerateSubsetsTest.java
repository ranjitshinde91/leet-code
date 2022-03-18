package recursion.generate_subsets;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import recursion.rope_cutting.RopeCutting;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GenerateSubsetsTest {
    @ParameterizedTest
    @MethodSource("inputs")
    void test1(String word, List<String> expected) {
        var generateSubsets = new GenerateSubsets();

        var subsets = generateSubsets.subsets(word);

        assertThat(subsets).containsAll(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of("", List.of("")),
                Arguments.of("A", List.of("", "A")),
                Arguments.of("AB", List.of("", "A", "B", "AB")),
                Arguments.of("ABC", List.of("", "A", "B", "C", "AB", "AC", "BC", "ABC"))
        );
    }

}