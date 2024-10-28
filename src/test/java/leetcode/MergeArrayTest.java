package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class MergeArrayTest {

    public static Stream<Arguments> testData() {
        return Stream.of(
//                Arguments.of(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3),
//                Arguments.of(new int[]{0}, 0, new int[]{1}, 1),
                Arguments.of(new int[]{2,0}, 1, new int[]{1}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void test(int[] nums1, int m, int[] nums2, int n) {
        merge(nums1, m, nums2, n);
    }


    // 1,2,3,0,0,0
    // 2,5,6
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int i = m > 0 ? m - 1 : 0;
        int j = n - 1;


        while (j >= 0 && i >=0) {
            if (nums1[i] < nums2[j]) {
                nums1[k] = nums2[j];
                k--;
                j--;
            } else {
                nums1[k] = nums1[i];
                i--;
                k--;
            }

        }
        System.out.println(Arrays.toString(nums1));
    }
}
