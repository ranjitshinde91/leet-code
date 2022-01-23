package searching.square_root_of_a_number;

class Solution {
    long floorSqrt(long number) {
        long low = 1;
        long high = number;
        long ans = -1;

        while (low <= high) {
            long mid = (low + high) / 2;
            long square = mid * mid;
            if (square == number) {
                return mid;
            } else if (square > number) {
                high = mid - 1;
            } else {
                low = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }
}

