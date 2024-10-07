package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxProfitTest {

    public static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 6, 5, 0, 3}, 4),
                Arguments.of(new int[]{3, 2, 3}, 1),
                Arguments.of(new int[]{5, 4, 3, 2, 1}, 0));
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void test(int[] prices, int profit) {
        assertEquals(profit, maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        int lowestPrice = 10000;
        for (int price : prices) {
            if (lowestPrice > price) lowestPrice = price;
            if (profit < price - lowestPrice) profit = price - lowestPrice;
        }
        return profit;
    }
}