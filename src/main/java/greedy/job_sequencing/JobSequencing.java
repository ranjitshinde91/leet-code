package greedy.job_sequencing;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class JobSequencing {

    int[] jobScheduling(Job[] arr, int n) {

        Arrays.sort(arr, Collections.reverseOrder(Comparator.comparingInt(job -> job.profit)));

        int maxDeadLine = maxDeadLine(arr);
        Job[] jobs = new Job[maxDeadLine];
        for (Job job : arr) {
            int k = latestPossibleSlot(jobs, job);
            if (k != -1) {
                jobs[k] = job;
            }
        }

        for (int i = 0; i < jobs.length; i++) {
            System.out.println(jobs[i]);
        }

        int totalJobsCompleted = 0;
        int totalProfit = 0;
        int currentTime = 0;

        for (Job selectedJob : jobs) {
            if (selectedJob != null && currentTime < selectedJob.deadline) {
                totalJobsCompleted++;
                totalProfit = totalProfit + selectedJob.profit;
                currentTime++;
            }
        }
        return new int[]{totalJobsCompleted, totalProfit};
    }

    private int latestPossibleSlot(Job[] jobs, Job job) {
        for (int i = job.deadline - 1; i >= 0; i--) {
            if (jobs[i] == null) {
                return i;
            }
        }
        return -1;
    }

    private int maxDeadLine(Job[] jobs) {
        int temp = 0;
        for (Job job : jobs) {
            if (temp < job.deadline) {
                temp = job.deadline;
            }
        }
        return temp;
    }

}

