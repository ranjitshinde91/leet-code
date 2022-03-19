package recursion.tower_of_hanoi;

public class TowerOfHanoi {

    public void towerOfHanoi(int n, char A, char B, char C) {
        if (n == 1) {
            System.out.println("move 1 from " + A + " to " + C);
            return;
        }
        towerOfHanoi(n - 1, A, C, B);
        System.out.println("move " + n + " from " + A + " to " + C);
        towerOfHanoi(n - 1, B, A, C);
    }
}
