package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordPatternTest {

    @ParameterizedTest
    @MethodSource("testData")
    public void test(String pattern, String s, boolean res) {
        assertEquals(res, wordPattern(pattern, s));
    }

    public static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abba", "dog cat cat dog", true),
                Arguments.of("abba", "dog cat cat fish", false),
                Arguments.of("abba", "dog dog dog dog", false));
    }

    public boolean wordPattern(String pattern, String s) {

        var map = new HashMap<Character, String>();
        String[] words = s.split(" ");

        if (pattern.length() != words.length)
            return false;
        for (int i = 0; i < pattern.length(); i++) {

            char currentChar = pattern.charAt(i);
            String currentWord = words[i];

            if (map.get(currentChar) != null) {
                if (!map.get(currentChar).equals(currentWord))
                    return false;
            } else if (map.containsValue(currentWord))
                return false;
            map.put(currentChar, currentWord);
        }
        return true;
    }
}
