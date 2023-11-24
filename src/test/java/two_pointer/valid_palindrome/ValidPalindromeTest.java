package two_pointer.valid_palindrome;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ValidPalindromeTest {

  @ParameterizedTest
  @MethodSource("inputs")
  void test1(String input, boolean expected) {
    var validPalindrome = new ValidPalindrome();

    boolean palindrome = validPalindrome.isPalindrome(input);

    assertThat(palindrome).isEqualTo(expected);
  }

  private static Stream<Arguments> inputs() {
    return Stream.of(
        Arguments.of("A man, a plan, a canal: Panama", true),
        Arguments.of("race a car", false),
        Arguments.of(" ", true),
        Arguments.of("", true));
  }
}
