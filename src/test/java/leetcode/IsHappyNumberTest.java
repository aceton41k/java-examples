package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsHappyNumberTest {
    public static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(19, true),
                Arguments.of(2, false),
                Arguments.of(7, true),
                Arguments.of(1, true)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void test(int n, boolean res) {
        assertEquals(res, isHappy(n));
    }

    public boolean isHappy(int n) {
        if (n == 1 || n == 7) return true;
        if (n < 10) return false;
        int[] digits = new int[10];

        int sum = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = n % 10;
            if (digits[i] != 0) {
                sum = sum + digits[i] * digits[i];
            }
            n /= 10;
        }

        return isHappy(sum);
    }
}
