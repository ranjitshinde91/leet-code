package greedy.huffman_algorithm.encoding;

import greedy.huffman_algorithm.HuffmanTreeBuilder;
import greedy.huffman_algorithm.MinHeapNode;

public class HuffmanEncoding {


    public String encode(Character[] character, int[] frequency, int length, String plaintext) {
        MinHeapNode rootNode = new HuffmanTreeBuilder().build(character, frequency, length);
        StringBuilder encodedString = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            encodedString.append(encodingCodeFor(rootNode, plaintext.charAt(i)));
        }
        return encodedString.toString();
    }

    private String encodingCodeFor(MinHeapNode node, char character) {
        if (node == null) {
            return "$";
        }
        if (node.data == character) {
            return "";
        }
        String leftChild = encodingCodeFor(node.left, character);
        if (!leftChild.contains("$")) {
            return "0" + leftChild;
        }
        return "1" + encodingCodeFor(node.right, character);
    }
}
