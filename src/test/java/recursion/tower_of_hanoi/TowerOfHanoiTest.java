package recursion.tower_of_hanoi;

import org.junit.jupiter.api.Test;

class TowerOfHanoiTest {

    @Test
    void test1() {
        var towerOfHanoi = new TowerOfHanoi();

        towerOfHanoi.towerOfHanoi(3, 'A', 'B', 'C');

    }
}