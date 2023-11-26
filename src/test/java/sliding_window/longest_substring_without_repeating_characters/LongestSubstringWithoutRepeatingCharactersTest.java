package sliding_window.longest_substring_without_repeating_characters;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LongestSubstringWithoutRepeatingCharactersTest {

  @ParameterizedTest
  @MethodSource("inputs")
  void test(String input, int expected) {
    var solution = new LongestSubstringWithoutRepeatingCharacters();

    int lengthOfLongestSubstring = solution.lengthOfLongestSubstring(input);

    assertThat(lengthOfLongestSubstring).isEqualTo(expected);
  }

  @ParameterizedTest
  @MethodSource("inputs")
  void test2(String input, int expected) {
    var solution = new LongestSubstringWithoutRepeatingCharacters();

    int lengthOfLongestSubstring = solution.lengthOfLongestSubstringSetBased(input);

    assertThat(lengthOfLongestSubstring).isEqualTo(expected);
  }

  private static Stream<Arguments> inputs() {
    return Stream.of(
        Arguments.of("abcabcbb", 3),
        Arguments.of("bbbbb", 1),
        Arguments.of("pwwkew", 3),
        Arguments.of("dvdf", 3),
        Arguments.of("abba", 2));
  }
}
