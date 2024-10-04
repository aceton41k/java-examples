package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CanConstructTest {


    public static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("aa", "aab", true),
                Arguments.of("abab", "abab", true),
                Arguments.of("a", "b", false),
                Arguments.of("aad", "aab", false),
                Arguments.of("aa", "ab", false)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void test(String a1, String a2, boolean res) {
        assertEquals(canConstruct(a1, a2), res);
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        var mag = new HashMap<Character, Integer>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            mag.put(c, mag.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            Integer count = mag.get(c);

            if(count == null || count == 0) return false;

            mag.put(c, count -1);
        }

        return true;
    }

}
