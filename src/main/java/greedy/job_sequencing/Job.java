package greedy.job_sequencing;

public class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", profit=" + profit +
                ", deadline=" + deadline +
                '}';
    }
}
