package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoSumTest {
    // https://leetcode.com/problems/two-sum

    public static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void test(int[] nums, int target, int[] res) {
        assertArrayEquals(res, twoSum(nums, target));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] out = new int[]{0, 0};
        for (int i = 0; i < nums.length; i++) {

            Integer curEl = map.get(target - nums[i]);
            if (curEl != null) {
                out[0] = curEl;
                out[1] = i;
                return out;
            } else map.putIfAbsent(nums[i], i);

        }
        return out;
    }
}
