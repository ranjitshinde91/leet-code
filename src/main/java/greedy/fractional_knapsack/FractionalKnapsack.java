package greedy.fractional_knapsack;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FractionalKnapsack {


    double fractionalKnapsack(int knapsackCapacity, Item[] arr, int n) {
        PriorityQueue<Item> priorityQueue = new PriorityQueue<>(
                Collections.reverseOrder(Comparator.comparingDouble(item -> (item.value / (double) item.weight)))
        );

        for (Item item : arr) {
            priorityQueue.add(item);
        }

        double totalValue = 0.0;
        int remainingCapacity = knapsackCapacity;
        while (!priorityQueue.isEmpty() && remainingCapacity > 0) {
            Item selectedItem = priorityQueue.poll();
            if (selectedItem.weight <= remainingCapacity) {
                totalValue = totalValue + selectedItem.value;
                remainingCapacity = remainingCapacity - selectedItem.weight;
            } else {
                totalValue = totalValue + (selectedItem.value * (remainingCapacity / (double) selectedItem.weight));
                remainingCapacity = 0;
            }
        }
        return totalValue;
    }
}


