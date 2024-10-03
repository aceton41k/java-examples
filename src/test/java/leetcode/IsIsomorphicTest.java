package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class IsIsomorphicTest {

    @ParameterizedTest
    @MethodSource("isIsomorphicTestData")
    public void isIsomorphicTest(String s, String t, boolean res) {
        assertEquals(res, isIsomorphic(s, t));
    }

    public static Stream<Arguments> isIsomorphicTestData() {
        return Stream.of(
                Arguments.of("gogo", "baba", true),
                Arguments.of("ab", "az", true),
                Arguments.of("foo", "bar", false),
                Arguments.of("z", "y", true),
                Arguments.of("ab", "ba", true),
                Arguments.of("ag", "b", false));
    }

    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length())
            return false;

        var map = new HashMap<Character, Character>();
        for (int i = 0; i < t.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (map.get(charS) != null) {
                if (map.get(charS) != charT)
                    return false;
            } else map.put(charS, charT);
        }

        return true;
    }
}
