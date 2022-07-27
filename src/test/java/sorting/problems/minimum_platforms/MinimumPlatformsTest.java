package sorting.problems.minimum_platforms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumPlatformsTest {

    @ParameterizedTest
    @MethodSource("inputs")
    public void heapBased(int[] arr, int[] dep, int expected) {
        var minimumPlatforms = new MinimumPlatforms();

        int noOfPlatforms = minimumPlatforms.findPlatform(arr, dep, dep.length);

        assertThat(noOfPlatforms).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("inputs")
    public void efficient(int[] arr, int[] dep, int expected) {
        var minimumPlatforms = new MinimumPlatforms();

        int noOfPlatforms = minimumPlatforms.findPlatformEfficient(arr, dep, dep.length);

        assertThat(noOfPlatforms).isEqualTo(expected);
    }

    public static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(
                        new int[]{900, 940, 950, 1100, 1500, 1800},
                        new int[]{910, 1200, 1120, 1130, 1900, 2000},
                        3
                ),
                Arguments.of(
                        new int[]{900, 1100, 1235},
                        new int[]{1000, 1200, 1240},
                        1
                ),
                Arguments.of(
                        new int[]{900, 1000, 1235},
                        new int[]{1000, 1100, 1240},
                        2
                )
        );
    }
}

