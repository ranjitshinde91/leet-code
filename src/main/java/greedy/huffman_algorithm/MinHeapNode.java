package greedy.huffman_algorithm;

public class MinHeapNode {
    public char data;
    public int freq;
    public MinHeapNode left;
    public MinHeapNode right;
    public MinHeapNode top;

    public MinHeapNode(char c, int freq) {
        left = right = null;
        this.data = c;
        this.freq = freq;
    }
}
