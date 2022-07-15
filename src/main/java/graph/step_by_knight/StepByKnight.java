package graph.step_by_knight;

import java.util.ArrayDeque;
import java.util.Queue;

class StepByKnight {

    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {

        return _minStepToReachTarget(
                new Position(knightPos[0], knightPos[1]),
                new Position(targetPos[0], targetPos[1]),
                n);
    }

    private int _minStepToReachTarget(Position knightPos, Position targetPos, int n) {

        boolean[][] visited = new boolean[n + 1][n + 1];
        int[][] distance = new int[n + 1][n + 1];
        distance[knightPos.x][knightPos.y] = 0;

        Queue<Position> queue = new ArrayDeque<>();
        queue.add(knightPos);

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            if (!visited[current.x][current.y]) {
                visited[current.x][current.y] = true;

                if (current.x == targetPos.x && current.y == targetPos.y) {
                    return distance[current.x][current.y];
                }
                dotask(new Position(current.x + 2, current.y + 1), current, queue, distance, n);
                dotask(new Position(current.x + 2, current.y - 1), current, queue, distance, n);
                dotask(new Position(current.x + 1, current.y - 2), current, queue, distance, n);
                dotask(new Position(current.x - 1, current.y - 2), current, queue, distance, n);
                dotask(new Position(current.x - 2, current.y - 1), current, queue, distance, n);
                dotask(new Position(current.x - 2, current.y + 1), current, queue, distance, n);
                dotask(new Position(current.x - 1, current.y + 2), current, queue, distance, n);
                dotask(new Position(current.x + 1, current.y + 2), current, queue, distance, n);
            }
        }
        return -1;
    }

    private void dotask(Position newPosition, Position current, Queue<Position> queue, int[][] distance, int n) {
        if (isSafe(newPosition, n)) {
            queue.add(newPosition);
            distance[newPosition.x][newPosition.y] = distance[current.x][current.y] + 1;
        }
    }

    private boolean isSafe(Position position, int n) {
        return !(position.x > n || position.x <= 0 || position.y > n || position.y <= 0);
    }

}

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
