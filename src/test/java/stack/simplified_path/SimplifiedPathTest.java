package stack.simplified_path;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SimplifiedPathTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test(String input, String expected) {
        var pathSimplifier = new SimplifiedPath();

        String simplifiedPath = pathSimplifier.simplify(input);

        assertThat(simplifiedPath).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of("/a/..", "/"),
                Arguments.of("/a/./b/../../c/", "/c"),
                Arguments.of("/../../../../../a", "/a"),
                Arguments.of("/a/./b/./c/./d/", "/a/b/c/d"),
                Arguments.of("/a/../.././../../.", "/"),
                Arguments.of("/a//b//c//////d", "/a/b/c/d")
        );
    }

}