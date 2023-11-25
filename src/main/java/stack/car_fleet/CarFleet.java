package stack.car_fleet;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;

// leetcode: 853. Car Fleet
// Optimization possible :: instead on using Monotonic stack, we can use variable
public class CarFleet {

  public int carFleet(int target, int[] position, int[] speed) {

    ArrayList<Car> cars = new ArrayList<>();
    for (int i = 0; i < position.length; i++) {
      cars.add(new Car(position[i], speed[i]));
    }
    cars.sort(Comparator.comparingInt(Car::position));

    ArrayDeque<Double> stack = new ArrayDeque<>();
    for (int i = cars.size() - 1; i >= 0; i--) {
      double time = (target - cars.get(i).position()) / (double) cars.get(i).speed();
      if (stack.isEmpty() || time > stack.peek()) {
        stack.push(time);
      }
    }
    return stack.size();
  }
}

record Car(int position, int speed) {}
