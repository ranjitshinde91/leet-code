package greedy.job_sequencing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class JobSequencingTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(Job[] jobs, int[] expected) {
        var jobSequencing = new JobSequencing();

        int[] output = jobSequencing.jobScheduling(jobs, jobs.length);

        assertThat(output).containsExactly(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(
                        new Job[]{
                                new Job(1, 4, 20),
                                new Job(2, 1, 10),
                                new Job(3, 1, 40),
                                new Job(4, 1, 30)
                        },
                        new int[]{2, 60}
                ),
                Arguments.of(
                        new Job[]{
                                new Job(1, 2, 100),
                                new Job(2, 1, 19),
                                new Job(3, 2, 27),
                                new Job(4, 1, 25),
                                new Job(5, 1, 15)
                        },
                        new int[]{2, 127}
                ),
                Arguments.of(
                        new Job[]{
                                new Job(1, 4, 70),
                                new Job(2, 1, 80),
                                new Job(3, 1, 30),
                                new Job(4, 1, 100)
                        },
                        new int[]{2, 170}
                ),
                Arguments.of(
                        new Job[]{
                                new Job(1, 2, 50),
                                new Job(2, 2, 60),
                                new Job(3, 3, 20),
                                new Job(4, 3, 30)
                        },
                        new int[]{3, 140}
                )
        );
    }
}