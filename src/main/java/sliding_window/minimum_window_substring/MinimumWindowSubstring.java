package sliding_window.minimum_window_substring;

import java.util.HashMap;
import java.util.Map;

// leetcode-76
public class MinimumWindowSubstring {

  public String minWindow(String s, String t) {
    if (s.length() < t.length()) {
      return "";
    }
    int minWindow = Integer.MAX_VALUE;
    int startIndex = 0;
    int remainingChar = t.length();
    String minWindowString = "";

    Map<Character, Integer> characters = new HashMap<>();
    populate(characters, t);
    for (int i = 0; i < s.length(); i++) {
      Character current = s.charAt(i);
      if (characters.containsKey(current)) {
        if (characters.get(current) > 0) {
          remainingChar--;
        }
        characters.compute(current, (key, value) -> value - 1);
      }

      while (startIndex < i
          && (!characters.containsKey(s.charAt(startIndex))
              || (characters.containsKey(s.charAt(startIndex))
                  && characters.get(s.charAt(startIndex)) < 0))) {
        if (characters.containsKey(s.charAt(startIndex))) {
          characters.compute(s.charAt(startIndex), (key, value) -> value + 1);
        }
        startIndex++;
      }

      // when window is found
      if (remainingChar == 0) {
        if (minWindow > (i - startIndex + 1)) {
          minWindowString = s.substring(startIndex, i + 1);
          minWindow = (i - startIndex + 1);
        }
        characters.compute(s.charAt(startIndex), (key, value) -> value + 1);
        startIndex++;
        remainingChar++;
      }
    }
    return minWindowString;
  }

  private void populate(Map<Character, Integer> characters, String t) {
    for (int i = 0; i < t.length(); i++) {
      characters.computeIfPresent(t.charAt(i), (key, value) -> value + 1);
      characters.putIfAbsent(t.charAt(i), 1);
    }
  }
}
