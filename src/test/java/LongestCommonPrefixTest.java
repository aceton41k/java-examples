import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestCommonPrefixTest {

    public static Stream<Arguments> isPalindromeTestData() {
        return Stream.of(Arguments.of(new String[]{"car", "cab"}, "ca"),
                Arguments.of(new String[]{"carrot", "caroline", "carol"}, "car"));
    }

    @ParameterizedTest
    @MethodSource("isPalindromeTestData")
    public void longestCommonPrefixTest(String[] str, String res) {
        assertEquals(longestCommonPrefix(str), res);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        StringBuilder prefix = new StringBuilder();
        if (!strs[0].isEmpty()) {
        boolean off = false;
            for (int i = 0; i < strs[0].length(); i++) {
                if(!off) {
                    char currentChar = strs[0].charAt(i);
                    int k = 0;
                    for (int j = 1; j < strs.length; j++) {
                        if (i < strs[j].length()) {
                            if (currentChar == strs[j].charAt(i)) {
                                k++;
                                if (k == strs.length - 1) {
                                    prefix.append(strs[j].charAt(i));
                                }
                            } else off = true;
                        }
                    }
                } else break;
            }
            return prefix.toString();
        } else return "";
    }
}
