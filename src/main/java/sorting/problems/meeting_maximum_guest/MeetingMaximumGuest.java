package sorting.problems.meeting_maximum_guest;

import java.util.Arrays;

public class MeetingMaximumGuest {

    public int meet(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int result = 1;
        int maxGuestMet = 1;

        int j = 0;
        int i = 1;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                maxGuestMet++;
                i++;
            } else {
                maxGuestMet--;
                j++;
            }
            result = Math.max(result, maxGuestMet);
        }
        return result;
    }
}
