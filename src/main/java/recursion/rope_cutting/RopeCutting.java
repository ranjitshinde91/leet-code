package recursion.rope_cutting;

public class RopeCutting {

    int maxNumberOfPieces(int lengthOfRope, int a, int b, int c) {
        if (lengthOfRope == 0) {
            return 0;
        }
        if (lengthOfRope < 0) {
            return -1;
        }
        int res = max(
                maxNumberOfPieces(lengthOfRope - a, a, b, c),
                maxNumberOfPieces(lengthOfRope - b, a, b, c),
                maxNumberOfPieces(lengthOfRope - c, a, b, c)
        );
        if (res == -1) {
            return -1;
        }
        return 1 + res;
    }

    private int max(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        }
        if (b >= a && b >= c) {
            return b;
        }
        return c;
    }
}
