package trie.most_frequent_word;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MostFrequentWordTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(String[] input, String expected) {
        var mostFrequentWord = new MostFrequentWord();

        String output = mostFrequentWord.mostFrequentWord(input, input.length);

        assertThat(output).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new String[]{"geeks", "for", "geeks"}, "geeks"),
                Arguments.of(new String[]{"hello", "world"}, "world"),
                Arguments.of(new String[]{"gwkyd" ,"ybqv" ,"etvf" ,"ybqv" ,"gbib" ,"gbib" ,"gwkyd" ,"etvf" ,"etvf" ,"gbib" ,"gbib" ,"etvf" ,"ybqv" ,"gbib" ,"etvf"}, "gbib"),
                Arguments.of(new String[]{"xejdcj", "xejdcj", "lvjpb", "tmyuiu", "lvjpb", "tmyuiu", "ovoba", "lvjpb", "lvjpb", "fqhyu", "fqhyu", "tmyuiu", "xejdcj", "tmyuiu", "fqhyu", "ovoba", "xejdcj"}
                        , "tmyuiu")
        );
    }

}