package greedy.n_meetings_in_one_room;

import java.util.Comparator;
import java.util.PriorityQueue;

public class NMeetingsInOneRoom {

    public static int maxMeetings(int start[], int end[], int n)
    {

        PriorityQueue<Meeting> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(it -> it.endTime));
        for(int i=0;i<n;i++){
            priorityQueue.add(new Meeting(start[i], end[i]));
        }
        int currentTime = 0;
        int totalMeetings = 0;
        while(!priorityQueue.isEmpty()){
            Meeting meeting = priorityQueue.poll();
            if (currentTime < meeting.startTime) {
                currentTime = meeting.endTime;
                totalMeetings++;
            }
        }
        return totalMeetings;
    }
}

class Meeting{
    public int startTime;
    public int endTime;

    public Meeting(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
