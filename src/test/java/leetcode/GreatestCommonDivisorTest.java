package leetcode;

import org.junit.jupiter.params.ParameterizedTest;


import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

// https://leetcode.com/problems/greatest-common-divisor-of-strings

public class GreatestCommonDivisorTest {

    public static Stream<Arguments> testData() {
        return Stream.of(
                of("ABCABC", "ABC", "ABC"),
                of("ABABAB", "ABAB", "AB"),
                of("LEET", "CODE", ""),
                of("ABCDEF", "ABC", ""),
                of("AA", "A", "A"),
                of("AAAAAAAAA", "AAACCC", ""),
                of("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXX")
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void test(String str1, String str2, String res) {
        assertEquals(res, gcdOfStrings(str1, str2));
    }


    public String gcdOfStrings(String str1, String str2) {

        String minStr;
        String maxStr;
        if (str1.length() > str2.length()) {
            maxStr = str1;
            minStr = str2;
        } else {
            maxStr = str2;
            minStr = str1;
        }

        if (!maxStr.contains(minStr)) return "";
        int nod = gcd(maxStr.length(), minStr.length());

        int i = 0;
        while (i < str1.length()) {
            if (str1.substring(i, nod + i).equals(str2.substring(0, nod)))
                i += nod;
            else return "";
        }
        return str1.substring(0, nod);
    }

    protected int gcd(int a, int b) {
        while (a > 0 && b > 0) {
            if (a >= b)
                a = a % b;
            else
                b = b % a;
        }
        return Math.max(a, b);
    }
}
