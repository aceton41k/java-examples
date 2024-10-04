package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;


public class IsIsomorphicTest {

    @ParameterizedTest
    @MethodSource("isIsomorphicTestData")
    public void isIsomorphicTest(String s, String t, boolean res) {
        assertEquals(res, isIsomorphic(s, t));
    }

    public static Stream<Arguments> isIsomorphicTestData() {
        return Stream.of(
                of("gogo", "baba", true),
                of("ab", "az", true),
                of("foo", "bar", false),
                of("z", "y", true),
                of("ab", "ba", true),
                of("ag", "b", false),
                of("badc", "baba", false),
                of("paper", "title", true)
        );
    }

    public boolean isIsomorphic(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if (slen != tlen)
            return false;

        var map = new HashMap<Character, Character>();
        for (int i = 0; i < tlen; i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (map.get(charS) != null) {
                if (map.get(charS) != charT)
                    return false;
            } else if (map.containsValue(charT))
                    return false;
                else map.put(charS, charT);
        }

        return true;
    }

    public static boolean isIsomorphicBest(String s, String t) {
        int[] map1 = new int[200];
        int[] map2 = new int[200];
        if (s.length() != t.length())
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (map1[s.charAt(i)] != map2[t.charAt(i)])
                return false;
            map1[s.charAt(i)] = i + 1;
            map2[t.charAt(i)] = i + 1;
        }
        return true;
    }

}
