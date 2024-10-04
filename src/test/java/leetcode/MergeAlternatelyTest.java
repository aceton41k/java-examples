package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeAlternatelyTest {

    public static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abc", "pqr", "apbqcr"),
                Arguments.of("abc", "pqrzzz", "apbqcrzzz"),
                Arguments.of("abcd", "pq", "apbqcd"));
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void test(String word1, String word2, String res) {
        assertEquals(res, mergeAlternately(word1, word2));
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word1.length() && i < word2.length(); i++) {
            sb
                    .append(word1.charAt(i))
                    .append(word2.charAt(i));
        }
        String tail = word1.length() > word2.length()
                ? word1.substring(word2.length())
                : word2.substring(word1.length());

        return sb.append(tail).toString();
    }

}


