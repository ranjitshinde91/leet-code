package sliding_window.best_time_to_buy_sell_stock;

public class BestTimeToBuyAndSellStock {

  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int buyPrice = prices[0];
    for (int i = 1; i < prices.length; i++) {
      maxProfit = Math.max(maxProfit, prices[i] - buyPrice);
      buyPrice = Math.min(buyPrice, prices[i]);
    }
    return maxProfit;
  }
}
