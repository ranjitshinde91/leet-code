package searching.majority_element;

class Solution {

    public long findMajorityElement(int[] input) {
        int candidate = findCandidate(input);
        if (isMajority(input, candidate)) {
            return candidate;
        }
        return -1;

    }

    int findCandidate(int[] input) {
        int maj_index = 0;
        int count = 1;
        for (int i = 1; i < input.length; i++) {
            if (input[i] == input[maj_index]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    maj_index = i;
                    count = 1;
                }
            }
        }
        return input[maj_index];
    }

    private boolean isMajority(int[] input, int candidate) {
        int count = 0;
        for (int j : input) {
            if (j == candidate) {
                count++;
            }
        }
        return count > input.length / 2;
    }

}
