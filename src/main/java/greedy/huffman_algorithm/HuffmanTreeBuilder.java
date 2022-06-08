package greedy.huffman_algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanTreeBuilder {

    private MinHeapNode root;

    public MinHeapNode build(Character[] character, int[] frequency, int length) {
        PriorityQueue<MinHeapNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.freq));

        for (int i = 0; i < length; i++) {
            priorityQueue.add(new MinHeapNode(character[i], frequency[i]));
        }
        while (priorityQueue.size() > 1) {
            MinHeapNode first = priorityQueue.poll();
            MinHeapNode second = priorityQueue.poll();

            MinHeapNode newNode = new MinHeapNode('$', first.freq + second.freq);
            newNode.left = first;
            newNode.right = second;

            priorityQueue.add(newNode);
        }
        root = priorityQueue.poll();
        return root;
    }

    public void printCodes() {
        _printCodes(root, "");
    }

    private void _printCodes(MinHeapNode root, String s) {
        if (root.data != '$') {
            System.out.println(root.data + " " + s);
            return;
        }
        _printCodes(root.left, s + "0");
        _printCodes(root.right, s + "1");
    }
}
