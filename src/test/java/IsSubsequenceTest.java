import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsSubsequenceTest {

    public static Stream<Arguments> isSubsequenceTestData() {
        return Stream.of(
                Arguments.of("abc", "a12b3dc", true),
                Arguments.of("abc", "abd", false));
    }


    @ParameterizedTest
    @MethodSource("isSubsequenceTestData")
    public void isSubsequenceTest(String str1, String str2, boolean res) {
        assertEquals(isSubsequence(str1, str2), res);
    }


    public static boolean isSubsequence(String s, String t) {
        int count = 0;
        int lastPos = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = lastPos; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    count++;
                    lastPos = j + 1;
                    break;
                }

            }
            if (count == s.length()) break;

        }
        return count == s.length();
    }
}
