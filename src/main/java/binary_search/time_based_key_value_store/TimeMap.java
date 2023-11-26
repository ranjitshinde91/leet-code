package binary_search.time_based_key_value_store;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// leetcode-981: Time Based Key-Value Store
public class TimeMap {
  private final Map<String, List<Node>> elements = new HashMap<>();

  public TimeMap() {}

  public void set(String key, String value, int timestamp) {
    if (elements.containsKey(key)) {
      elements.get(key).add(new Node(value, timestamp));
    } else {
      List<Node> nodes = new LinkedList<>();
      nodes.add(new Node(value, timestamp));
      elements.put(key, nodes);
    }
  }

  public String get(String key, int timestamp) {
    if (!elements.containsKey(key)) {
      return "";
    }
    int low = 0;
    List<Node> values = elements.get(key);
    int high = values.size() - 1;

    String result = "";
    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (values.get(mid).timestamp() == timestamp) {
        return values.get(mid).value();
      } else if (values.get(mid).timestamp() < timestamp) {
        result = values.get(mid).value();
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return result;
  }
}

record Node(String value, int timestamp) {}
