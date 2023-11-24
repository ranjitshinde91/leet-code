package two_pointer.valid_palindrome;

public class ValidPalindrome {

  public boolean isPalindrome(String input) {
    int left = 0;
    int right = input.length() - 1;

    while (left < right) {
      while (left < right && !isAlphanumeric(input.charAt(left))) {
        left++;
      }
      while (left < right && !isAlphanumeric(input.charAt(right))) {
        right--;
      }
      if (Character.toLowerCase(input.charAt(left)) != Character.toLowerCase(input.charAt(right))) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

  private boolean isAlphanumeric(char character) {
    return character >= 'a' && character <= 'z'
        || character >= 'A' && character <= 'Z'
        || character >= '0' && character <= '9';
  }
}
