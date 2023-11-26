package sliding_window.longest_repeating_character_replacement;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LongestRepeatingCharacterReplacementTest {

  @ParameterizedTest
  @MethodSource("inputs")
  void test(String input, int k, int expected) {
    var longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();

    int i = longestRepeatingCharacterReplacement.characterReplacement(input, k);

    assertThat(i).isEqualTo(expected);
  }

  private static Stream<Arguments> inputs() {
    return Stream.of(
        Arguments.of("ABAB", 2, 4),
        Arguments.of("AABABBA", 1, 4),
        Arguments.of("ABABBB", 2, 6),
        Arguments.of("ABBB", 2, 4),
        Arguments.of("ABC", 1, 2));
  }
}
