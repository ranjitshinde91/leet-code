package dynamic_programming.fibonacci.tabulation;

public class FibonacciTab {


    public long tabulation(long number) {
        if (number == 0 || number == 1) {
            return number;
        }
        long first = 0;
        long second = 1;
        for (int i = 2; i <= number; i++) {
            long temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }
}
