package sliding_window.permutation_in_string;

import java.util.HashMap;
import java.util.Map;

// leetcode-567
public class PermutationInString {

  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }

    Map<Character, Integer> characterMap = new HashMap<>();
    populate(characterMap, s1);

    int remainingMatched = s1.length();
    int startIndex = -1;
    for (int i = 0; i < s2.length(); i++) {
      Character current = s2.charAt(i);
      if (!characterMap.containsKey(current)) {
        remainingMatched = s1.length();
        for (int k = startIndex; k < i && startIndex != -1; k++) {
          characterMap.computeIfPresent(s2.charAt(k), (key, value) -> value + 1);
        }
        startIndex = -1;
      } else {
        if (startIndex == -1) {
          startIndex = i;
        }
        if (characterMap.get(current) == 0) {
          while (s2.charAt(startIndex) != current) {
            characterMap.computeIfPresent(s2.charAt(startIndex), (key, value) -> value + 1);
            startIndex++;
            remainingMatched++;
          }
          startIndex++;
        } else {
          remainingMatched--;
          characterMap.computeIfPresent(current, (key, value) -> value - 1);
        }
        if (remainingMatched == 0) {
          return true;
        }
      }
    }
    return false;
  }

  private static void populate(Map<Character, Integer> characterMap, String s1) {
    for (int i = 0; i < s1.length(); i++) {
      characterMap.computeIfPresent(s1.charAt(i), (key, value) -> value + 1);
      characterMap.putIfAbsent(s1.charAt(i), 1);
    }
  }
}
