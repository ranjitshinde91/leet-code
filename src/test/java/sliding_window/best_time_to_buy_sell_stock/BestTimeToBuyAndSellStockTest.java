package sliding_window.best_time_to_buy_sell_stock;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BestTimeToBuyAndSellStockTest {

  @ParameterizedTest
  @MethodSource("inputs")
  void test(int[] input, int expected) {
    var bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();

    int maxProfit = bestTimeToBuyAndSellStock.maxProfit(input);

    assertThat(maxProfit).isEqualTo(expected);
  }

  private static Stream<Arguments> inputs() {

    return Stream.of(
        Arguments.of(new int[] {7, 1, 5, 3, 6, 4}, 5), Arguments.of(new int[] {7, 6, 4, 3, 1}, 0));
  }
}
