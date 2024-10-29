package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A prime number is a number that can only be divided by itself and 1 without remainders.
 * Write solution that returns true if the given number is prime otherwise returns false.
 */

public class IsPrimeTest {

    public static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(0, false),
                Arguments.of(1, false),
                Arguments.of(2, true),
                Arguments.of(7, true),
                Arguments.of(8, false),
                Arguments.of(23, true),
                Arguments.of(58, false),
                Arguments.of(-3, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void test(int number, boolean res) {
        assertEquals(res, isPrime(number));
    }

    public boolean isPrime(int number) {
        int i;
        if (number <= 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;

        int sqrt = (int) Math.sqrt(number);
        for (i = 3; i < sqrt; i += 2) {
            if (number % i == 0)
                return false;
        }
        return true;

    }

}
