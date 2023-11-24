package stack.daily_temperatures;

import java.util.ArrayDeque;

// leetcode-739: Daily Temperatures
public class DailyTemperatures {

  public int[] dailyTemperatures(int[] temperatures) {

    ArrayDeque<Element> stack = new ArrayDeque<>();

    int[] output = new int[temperatures.length];

    stack.push(new Element(temperatures.length - 1, temperatures[temperatures.length - 1]));
    output[temperatures.length - 1] = 0;

    for (int i = temperatures.length - 1; i >= 0; i--) {
      int temp = temperatures[i];
      while (!stack.isEmpty() && temp >= stack.peek().temp) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        output[i] = 0;
      } else {
        output[i] = stack.peek().index - i;
      }
      stack.push(new Element(i, temp));
    }

    return output;
  }
}

class Element {
  public int index;
  public int temp;

  public Element(int index, int temp) {
    this.index = index;
    this.temp = temp;
  }
}
