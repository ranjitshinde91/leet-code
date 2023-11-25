package binary_search.koko_eating_bananas;

// leetcode-875: Koko Eating Bananas
public class KokoEatingBananas {

  public int minEatingSpeed(int[] piles, int h) {
    int max = piles[0];
    for (int i = 1; i < piles.length; i++) {
      max = Math.max(max, piles[i]);
    }
    if (piles.length == h) {
      return max;
    }
    int low = 1;
    int high = max;

    int lastK = 0;
    while (low <= high) {
      int k = low + (high - low) / 2;
      int hoursRemaining = eat(piles, h, k);
      if (hoursRemaining == 0) {
        lastK = k;
        high = k - 1;
      } else if (hoursRemaining > 0) {
        lastK = k;
        high = k - 1;
      } else {
        low = k + 1;
      }
    }
    return lastK;
  }

  private int eat(int[] piles, int h, int k) {
    int hours = 0;
    for (int pile : piles) {
      int hoursNeeded = (int) Math.ceil(pile / (double) k);
      hours += Math.max(hoursNeeded, 1);
      if (hours > h) {
        return -1;
      }
    }
    return hours == h ? 0 : 1;
  }
}
