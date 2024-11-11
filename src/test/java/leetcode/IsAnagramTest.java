package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsAnagramTest {
// https://leetcode.com/problems/valid-anagram

    public static Stream<Arguments> tstData() {
        return Stream.of(
                Arguments.of("aacc", "ccac", false),
                Arguments.of("anagram", "nagaram", true),
                Arguments.of("a", "b", false),
                Arguments.of("yqhbicoumu", "ouiuycbmqh", true),
                Arguments.of("ab", "bac", false)
        );
    }

    @ParameterizedTest
    @MethodSource("tstData")
    public void test(String s, String t, boolean res) {
        assertEquals(res, isAnagramIntArrayApproach(s, t));
    }


    public boolean isAnagramIntArrayApproach(String s, String t) {

        if (s.length() != t.length())
            return false;

        int[] array = new int[26];

        for (char i : s.toCharArray()) {
            array[i - 'a']++;
        }
        for (char i : t.toCharArray()) {
            array[i - 'a']--;
        }
        for (int i : array) {
            if (i != 0) return false;
        }
        return true;
    }

    /**
     * Deprecated, <br> see better solution {@link #isAnagramIntArrayApproach}
     */
    @Deprecated
    public boolean isAnagramHashMapApproach(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            map.merge(sChar, 1, Integer::sum);
            if (map.get(tChar) != null)
                map.put(tChar, map.get(tChar) - 1);
            else map.put(tChar, -1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0)
                return false;
        }
        return true;
    }

}
