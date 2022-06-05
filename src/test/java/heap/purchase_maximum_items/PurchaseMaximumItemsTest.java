package heap.purchase_maximum_items;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseMaximumItemsTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void test1(long[] input, long sum, long expected) {
        var purchaseMaximumItems = new PurchaseMaximumItems();

        long cost = purchaseMaximumItems.maxItem(input, sum);

        assertThat(cost).isEqualTo(expected);
    }


    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(new long[]{1, 12, 5, 111, 200}, 10, 2),
                Arguments.of(new long[]{20, 10, 5, 30, 100}, 35, 3)
        );
    }
}
