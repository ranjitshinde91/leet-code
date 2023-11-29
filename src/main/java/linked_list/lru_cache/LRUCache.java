package linked_list.lru_cache;

import java.util.HashMap;
import java.util.Map;

// leetcode-146
public class LRUCache {
  private final int capacity;
  private int size;
  private Node head;
  private Node tail;
  private final Map<Integer, Node> cache = new HashMap<>();

  public LRUCache(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if (!keyExists(key)) {
      return -1;
    }
    Node node = getNode(key);
    makeRecentlyUsed(node);
    return node.value;
  }

  private void makeRecentlyUsed(Node node) {
    if (node == head) {
      return;
    }
    if (node == tail) {
      moveTailToHead();
    } else {
      moveMiddleToHead(node);
    }
  }

  private Node getNode(int key) {
    return cache.getOrDefault(key, null);
  }

  private boolean keyExists(int key) {
    return cache.containsKey(key);
  }

  private void moveMiddleToHead(Node node) {
    head.previous = node;
    node.previous.next = node.next;
    node.next.previous = node.previous;
    node.next = head;
    node.previous = null;
    this.head = node;
  }

  private void moveTailToHead() {
    Node newTail = tail.previous;
    newTail.next = null;
    tail.next = head;
    head.previous = tail;
    tail.previous = null;
    this.head = tail;
    this.tail = newTail;
  }

  public void put(int key, int value) {
    if (isEmpty()) {
      insertFirstElement(key, value);
      return;
    }
    if (keyExists(key)) {
      Node node = getNode(key);
      node.value = value;
      cache.put(key, node);
      makeRecentlyUsed(node);
      return;
    }
    insertNewElement(key, value);
  }

  private void insertNewElement(int key, int value) {
    if (size < capacity) {
      insertInTheBeginning(key, value);
    } else {
      removeLeastRecentlyUsed();
      insertInTheBeginning(key, value);
    }
  }

  private void removeLeastRecentlyUsed() {
    cache.remove(tail.key);
    this.tail = tail.previous;
    if (tail != null) {
      tail.next = null;
    }
  }

  private void insertInTheBeginning(int key, int value) {
    Node newNode = new Node(key, value);
    newNode.next = head;
    head.previous = newNode;
    this.head = newNode;
    if (tail == null) {
      this.tail = newNode;
    }
    cache.put(key, newNode);
    size++;
  }

  private void insertFirstElement(int key, int value) {
    Node newNode = new Node(key, value);
    head = newNode;
    tail = newNode;
    cache.put(key, newNode);
    size++;
  }

  private boolean isEmpty() {
    return size == 0;
  }
}

class Node {
  public int key;
  public int value;
  public Node previous;
  public Node next;

  public Node(int key, int value) {
    this.key = key;
    this.value = value;
  }
}
