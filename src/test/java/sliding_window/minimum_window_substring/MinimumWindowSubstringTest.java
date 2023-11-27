package sliding_window.minimum_window_substring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MinimumWindowSubstringTest {

  @ParameterizedTest
  @MethodSource("inputs")
  void test(String s1, String s2, String expected) {
    var minimumWindowSubstring = new MinimumWindowSubstring();

    String minWindow = minimumWindowSubstring.minWindow(s1, s2);

    assertThat(minWindow).isEqualTo(expected);
  }

  private static Stream<Arguments> inputs() {
    return Stream.of(
        Arguments.of("ADOBECODEBANC", "ABC", "BANC"),
        Arguments.of("a", "a", "a"),
        Arguments.of("ab", "b", "b"),
        Arguments.of("aa", "a", "a"),
        Arguments.of("a", "aa", ""),
        Arguments.of("acbbaca", "aba", "baca"),
        Arguments.of("aaaaaaaaaaaabbbbbcdd", "abcdd", "abbbbbcdd"),
        Arguments.of("adobecodebanc", "abcda", "adobecodeba"),
        Arguments.of(
            "cgklivwehljxrdzpfdqsapogwvjtvbzahjnsejwnuhmomlfsrvmrnczjzjevkdvroiluthhpqtffhlzyglrvorgnalk",
            "mqfff",
            "fsrvmrnczjzjevkdvroiluthhpqtff"),
        Arguments.of("a", "b", ""));
  }
}
