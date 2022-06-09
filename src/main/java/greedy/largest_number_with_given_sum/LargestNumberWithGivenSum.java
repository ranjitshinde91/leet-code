package greedy.largest_number_with_given_sum;

public class LargestNumberWithGivenSum {

    static String largestNumber(int numberOfDigits, int sum) {
        StringBuilder password = new StringBuilder();
        int remaining = sum;

        for (int i = 0; i < numberOfDigits; i++) {
            for (int k = 9; k >= 0; k--) {
                if (remaining - k >= 0) {
                    password.append(k);
                    remaining = remaining - k;
                    break;
                }
            }
        }
        if (remaining != 0) {
            return "-1";
        }
        return password.toString();
    }
}
