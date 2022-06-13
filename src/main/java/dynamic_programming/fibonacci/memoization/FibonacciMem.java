package dynamic_programming.fibonacci.memoization;

import java.util.HashMap;
import java.util.Map;

public class FibonacciMem {
    private final Map<Long, Long> cache;

    public FibonacciMem() {
        this.cache = new HashMap<>();
    }

    public long memoization(long number) {
        if (this.cache.containsKey(number)) {
            return this.cache.get(number);
        }
        if (number == 0 || number == 1) {
            return number;
        }
        long result = memoization(number - 1) + memoization(number - 2);
        this.cache.put(number, result);
        return result;
    }
}
