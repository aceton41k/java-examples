package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsPalindromeTest {

    public static Stream<Arguments> isPalindromeTestData() {
        return Stream.of(
                Arguments.of("A man, a plan, a canal: Panama", true),
                Arguments.of("abc", false),
                Arguments.of("!b.ab)", true));
    }

    @ParameterizedTest
    @MethodSource("isPalindromeTestData")
    public void isPalindromeTest(String str, boolean res) {
        assertEquals(isPalindrome(str), res);
    }



    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]+", "");
        StringBuilder reversed = new StringBuilder(s).reverse();
        return reversed.toString().equals(s);
    }

    public static boolean isPalindromeBest(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int last = s.length() - 1;
        while (start <= last) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(last);
            if (!Character.isLetterOrDigit(currFirst)) {
                start++;
            } else if (!Character.isLetterOrDigit(currLast)) {
                last--;
            } else {
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }
}
