package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class ArrayNotContainsTest {

    /**
     *  вывести элементы первого массива, которых нет во втором </br>
     *  массивы отсортированы
     *
     */


    @ParameterizedTest
    @MethodSource("testData")
    public void test(int[] a1, int[] a2, List<Integer> a3) {
        Assertions.assertEquals(a3, arrayNotContainsElements(a1, a2), "Arrays are not equal");
    }


    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 5}, new int[]{0, 2, 4}, List.of(1, 3, 5)),
                Arguments.of(new int[]{0, 2, 6}, new int[]{2}, List.of(0, 6)),
                Arguments.of(new int[]{0}, new int[]{0, 1}, Collections.emptyList()),
                Arguments.of(new int[]{0, 8}, new int[]{2, 7}, List.of(0, 8)),
                Arguments.of(new int[]{2, 3, 6}, new int[]{0, 1, 3, 5, 9}, List.of(2, 6)));
    }

    public List<Integer> arrayNotContainsElements(int[] arr1, int[] arr2) {

        var list = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                list.add(arr1[i]);
                i++;
            } else if (arr1[i] == arr2[j]) {
                i++;
                j++;
            } else
                j++;
        }
        for (int k = i; k < arr1.length; k++) {
            list.add(arr1[k]);
        }

        return list;
    }

}
