package stack.min_stack;

public class MinStack {
  private Node root;

  public MinStack() {}

  public void push(int val) {
    if (root == null) {
      this.root = new Node(val, val, null);
    } else {
      this.root = new Node(val, Math.min(root.minValue, val), root);
    }
  }

  public void pop() {
    this.root = root.next;
  }

  public int top() {
    return this.root.value;
  }

  public int getMin() {
    return this.root.minValue;
  }
}

class Node {
  public int value;
  public int minValue;
  public Node next;

  Node(int value, int minValue, Node next) {
    this.value = value;
    this.minValue = minValue;
    this.next = next;
  }
}
