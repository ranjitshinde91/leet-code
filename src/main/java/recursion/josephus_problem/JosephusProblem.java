package recursion.josephus_problem;


public class JosephusProblem {
    private int[] persons;

    public int kill(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (kill(n - 1, k) + k) % n;
    }
}
