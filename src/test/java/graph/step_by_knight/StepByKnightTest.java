package graph.step_by_knight;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StepByKnightTest {

    @Test
    void test() {
        StepByKnight stepByKnight = new StepByKnight();

        int result = stepByKnight.minStepToReachTarget(new int[]{4, 5}, new int[]{1, 1}, 6);

        assertThat(result).isEqualTo(3);
    }
}