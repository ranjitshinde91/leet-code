package binary_search.koko_eating_bananas;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class KokoEatingBananasTest {

  @ParameterizedTest
  @MethodSource("inputs")
  void test(int[] piles, int hour, int expected) {
    var kokoEatingBananas = new KokoEatingBananas();

    int k = kokoEatingBananas.minEatingSpeed(piles, hour);

    assertThat(k).isEqualTo(expected);
  }

  private static Stream<Arguments> inputs() {
    return Stream.of(
        Arguments.of(new int[] {3, 6, 7, 11}, 8, 4),
        Arguments.of(new int[] {30, 11, 23, 4, 20}, 5, 30),
        Arguments.of(new int[] {312884470}, 312884469, 2),
        Arguments.of(new int[] {1, 1, 1, 999999999}, 10, 142857143),
        Arguments.of(new int[] {30, 11, 23, 4, 20}, 6, 23));
  }
}
