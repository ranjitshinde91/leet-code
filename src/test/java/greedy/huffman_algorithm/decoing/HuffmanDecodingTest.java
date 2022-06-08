package greedy.huffman_algorithm.decoing;

import greedy.huffman_algorithm.HuffmanTreeBuilder;
import greedy.huffman_algorithm.MinHeapNode;
import greedy.huffman_algorithm.encoding.HuffmanEncoding;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class HuffmanDecodingTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(Character[] character, int[] frequency, String encodedText, String plainText) {
        var huffmanDecoding = new HuffmanDecoding();

        HuffmanTreeBuilder huffmanTreeBuilder = new HuffmanTreeBuilder();
        MinHeapNode minHeapNode = huffmanTreeBuilder.build(character, frequency, frequency.length);
        huffmanTreeBuilder.printCodes();

        String output = huffmanDecoding.decodeHuffmanData(minHeapNode, encodedText);

        assertThat(output).isEqualTo(plainText);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new Character[]{'a', 'b', 'c', 'd', 'e'}, new int[]{10, 50, 20, 40, 80}, "11001011111010", "abdce")
        );
    }
}