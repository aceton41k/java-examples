package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerOfThreeTest {

    @ParameterizedTest
    @MethodSource("powerOfThreeTestData")
    public void powerOfThreeTest (int n, boolean res) {
        assertEquals(PowerOfThreeTest.isPowerOfThree(n), res);
    }

    public static Stream<Arguments> powerOfThreeTestData() {
        return Stream.of(
                Arguments.of(3, true),
                Arguments.of(0, false),
                Arguments.of(-1, false),
                Arguments.of(9, true));
    }

    public static boolean isPowerOfThree(int n) {
        if(n <= 0) return false;
        for(int i=1; i <= n && i > 0; i*=3) {
            if(n==i) return true;
        }
        return false;
    }
}
