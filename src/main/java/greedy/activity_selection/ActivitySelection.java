package greedy.activity_selection;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ActivitySelection {

    public static int activitySelection(int[] start, int[] end, int n) {
        PriorityQueue<Activity> activities = new PriorityQueue<>(Comparator.comparingInt(Activity::end));
        for (int i = 0; i < n; i++) {
            activities.add(Activity.from(start[i], end[i]));
        }
        int currentTime = 0;
        int completedActivities = 0;

        for (int i = 0; i < n; i++) {
            Activity activity = activities.poll();
            if (activity.start() > currentTime) {
                completedActivities++;
                currentTime = activity.end();
            }
        }
        return completedActivities;
    }
}

class Activity {
    private final int start;
    private final int end;

    private Activity(int start, int end) {
        this.start = start;
        this.end = end;

    }

    public static Activity from(int start, int end) {
        return new Activity(start, end);
    }

    public int start() {
        return this.start;
    }

    public int end() {
        return this.end;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
