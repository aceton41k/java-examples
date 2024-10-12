import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxOccurrenceOfSymbolTest {

    public static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("saudgseujdbasjdeutawsvd", 'a'),
                Arguments.of("abab", 'a'),
                Arguments.of("z", 'z'),
                Arguments.of("", null)

        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void test(String s, Character res) {
        assertEquals(res, maxOccurrence(s));
    }

    public Character maxOccurrence(String s) {
        var map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) != null)
                map.put(s.charAt(i), map.get(s.charAt(i)));
            else map.put(s.charAt(i), 1);
            if (max < map.get(s.charAt(i))) max = map.get(s.charAt(i));
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max)
                return entry.getKey();
        }
        return null;
    }
}
