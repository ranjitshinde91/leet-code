package greedy.fractional_knapsack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FractionalKnapsackTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(Item[] items, int capacity, double expected) {
        var fractionalKnapsack = new FractionalKnapsack();

        double output = fractionalKnapsack.fractionalKnapsack(capacity, items, items.length);

        assertThat(output).isEqualTo(expected);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new Item[]{
                        new Item(60, 10),
                        new Item(100, 20),
                        new Item(120, 30)
                }, 50, 240.00),
                Arguments.of(new Item[]{
                        new Item(60, 10),
                        new Item(100, 20)
                }, 50, 160),
                Arguments.of(new Item[]{
                        new Item(600, 50),
                        new Item(500, 20),
                        new Item(400, 30)
                }, 70, 1140)
        );
    }

}
