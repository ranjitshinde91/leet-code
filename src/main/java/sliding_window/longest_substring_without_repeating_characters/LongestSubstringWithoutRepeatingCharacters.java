package sliding_window.longest_substring_without_repeating_characters;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

  public int lengthOfLongestSubstring(String s) {
    if (s.isEmpty()) {
      return 0;
    }
    int i = 0;
    int j = 0;
    int maxSubstring = 1;

    for (int index = 1; index < s.length(); index++) {
      char current = s.charAt(index);
      int m = i;
      while (m <= j && s.charAt(m) != current) {
        m++;
      }
      if (m == j + 1) {
        j++;
        maxSubstring = Math.max(maxSubstring, (j - i) + 1);
      } else {
        i = m + 1;
        j++;
      }
    }
    return maxSubstring;
  }

  public int lengthOfLongestSubstringSetBased(String s) {
    if (s.isEmpty()) {
      return 0;
    }
    int j = 0;
    int maxSubstring = 0;

    Set<Character> characterSet = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      char current = s.charAt(i);
      while (!characterSet.add(current)) {
        characterSet.remove(s.charAt(j++));
      }
      maxSubstring = Math.max(maxSubstring, i - j + 1);
    }
    return maxSubstring;
  }
}
