package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxOccurrenceTest {

    public static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("xxxxxthkoioiiaacccc", 'x'),
                Arguments.of("aaabbb", 'a'),
                Arguments.of("ZZZ", 'Z'),
                Arguments.of("FfFfF", 'F'),
                Arguments.of("", '\u0000'),
                Arguments.of("g", 'g'));
    }


    @ParameterizedTest
    @MethodSource("testData")
    public void test(String s, char res) {
        assertEquals(res, maxOcc(s));
    }

    public static char maxOcc(String s) {
        if (s.isEmpty()) return 0;
        var map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            else map.put(s.charAt(i), 1);
        }
        char output = 0;
        int maxValue = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (maxValue < entry.getValue()) {
                maxValue = entry.getValue();
                output = entry.getKey();
            }
        }
        return output;
    }

}
