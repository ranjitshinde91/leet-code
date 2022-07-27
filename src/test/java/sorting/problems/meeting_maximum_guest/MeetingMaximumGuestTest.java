package sorting.problems.meeting_maximum_guest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MeetingMaximumGuestTest {

    @ParameterizedTest
    @MethodSource("inputs")
    public void heapBased(int[] arr, int[] dep, int expected) {
        var meetingMaximumGuest = new MeetingMaximumGuest();

        int maxNoOfGuestMet = meetingMaximumGuest.meet(arr, dep, dep.length);

        assertThat(maxNoOfGuestMet).isEqualTo(expected);
    }

    public static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(
                        new int[]{900, 940},
                        new int[]{1000, 1030},
                        2
                ),
                Arguments.of(
                        new int[]{800, 700, 1235},
                        new int[]{840, 820, 1240},
                        2
                ),
                Arguments.of(
                        new int[]{900, 1000, 1235},
                        new int[]{1000, 1100, 1240},
                        2
                )
        );
    }

}