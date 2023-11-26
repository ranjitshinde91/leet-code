package sliding_window.longest_repeating_character_replacement;

import java.util.HashMap;
import java.util.Map;

// leetcode-412
public class LongestRepeatingCharacterReplacement {

  public int characterReplacement(String s, int k) {
    int max = Integer.MIN_VALUE;
    Map<Character, Integer> frequency = new HashMap<>();
    int left = 0;
    for (int right = 0; right < s.length(); right++) {
      char current = s.charAt(right);
      if (!frequency.containsKey(s.charAt(right))) {
        frequency.put(current, 0);
      }
      frequency.computeIfPresent(current, (key, value) -> value + 1);
      int mfc = getMostFrequencyCount(frequency);
      if ((right - left - mfc + 1) > k) {
        frequency.computeIfPresent(s.charAt(left), (key, value) -> value - 1);
        left++;
      }
      max = Math.max(max, (right - left) + 1);
    }
    return max;
  }

  // Since only character are capital letters (26): traversal in O(26)-> constant
  private int getMostFrequencyCount(Map<Character, Integer> frequency) {
    int max = Integer.MIN_VALUE;
    for (int value : frequency.values()) {
      max = Math.max(max, value);
    }
    return max;
  }
}
