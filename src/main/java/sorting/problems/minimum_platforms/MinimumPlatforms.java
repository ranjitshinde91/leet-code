package sorting.problems.minimum_platforms;

import java.util.*;

public class MinimumPlatforms {

    static int findPlatform(int[] arr, int[] dep, int n) {

        List<Train> trains = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            trains.add(new Train(arr[i], dep[i]));
        }
        trains.sort(Comparator.comparingInt(it -> it.arr));

        int noOfPlatforms = 1;
        PriorityQueue<Integer> lastTrainMinDepTimes = new PriorityQueue<>();
        lastTrainMinDepTimes.add(trains.get(0).dep);

        for (int i = 1; i < trains.size(); i++) {
            Train train = trains.get(i);

            if (lastTrainMinDepTimes.peek() >= train.arr) {
                noOfPlatforms++;
                lastTrainMinDepTimes.add(train.dep);
            } else {
                lastTrainMinDepTimes.poll();
                lastTrainMinDepTimes.add(train.dep);
            }

        }
        return noOfPlatforms;
    }

    static int findPlatformEfficient(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int plat_needed = 1, result = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
            } else {
                plat_needed--;
                j++;
            }

            if (plat_needed > result)
                result = plat_needed;
        }

        return result;
    }

}


class Train {
    int arr;
    int dep;

    public Train(int arr, int dep) {
        this.arr = arr;
        this.dep = dep;
    }
}
