package greedy.huffman_algorithm.decoing;

import greedy.huffman_algorithm.MinHeapNode;

public class HuffmanDecoding {

    static String decodeHuffmanData(MinHeapNode root, String binaryString) {
        MinHeapNode current = root;
        StringBuilder plainText = new StringBuilder();
        for (int i = 0; i < binaryString.length(); i++) {
            char character = binaryString.charAt(i);
            if ('0' == character) {
                current = current.left;
            } else if ('1' == character) {
                current = current.right;
            }
            if (current.data != '$') {
                plainText.append(current.data);
                current = root;
            }
        }
        return plainText.toString();
    }
}
