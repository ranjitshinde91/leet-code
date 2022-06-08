package greedy.huffman_algorithm.encoding;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class HuffmanEncodingTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(Character[] character, int[] frequency, String plaintext, String expected) {
        var huffmanEncoding = new HuffmanEncoding();

        String encodedText = huffmanEncoding.encode(character, frequency, frequency.length, plaintext);

        assertThat(encodedText).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new Character[]{'a', 'b', 'c', 'd', 'e'}, new int[]{10, 50, 20, 40, 80}, "abdce", "11001011111010")
        );
    }

}