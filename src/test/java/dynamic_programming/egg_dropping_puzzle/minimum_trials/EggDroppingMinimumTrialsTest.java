package dynamic_programming.egg_dropping_puzzle.minimum_trials;

import dynamic_programming.minimum_jumps_to_reach_end.MinimumJumpsToReachEnd;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EggDroppingMinimumTrialsTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void memoization(int floors, int eggs, int expected) {
        var eggDroppingMinimumTrials = new EggDroppingMinimumTrials();

        long output = eggDroppingMinimumTrials.memoization(floors, eggs);

        assertThat(output).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("inputs")
    void tabulation(int floors, int eggs, int expected) {
        var eggDroppingMinimumTrials = new EggDroppingMinimumTrials();

        long output = eggDroppingMinimumTrials.tabulation(floors, eggs);

        assertThat(output).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(10, 1, 10),
                Arguments.of(3, 2, 2),
                Arguments.of(10, 2, 4)
        );
    }

}