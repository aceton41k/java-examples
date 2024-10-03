package leetcode;

import java.util.HashMap;

public class Majority {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 1, 2, 2, 4, 1, 2};
        int[] nums2 = new int[]{1, 1, 0, 0, 1};
        System.out.println(Solution.majorityElement(nums2));
    }

    static class Solution {
        public static int majorityElement(int[] nums) {
            var map = new HashMap<Integer, Integer>();
            int maxOcc = 0;
            // add all elements and their occurrences in a map
            for (int el : nums) {
                if (map.containsKey(el)) {
                    map.put(el, map.get(el) + 1);
                    if (map.get(el) > maxOcc) {
                        maxOcc = map.get(el);
                    }
                } else map.put(el, 1);
            }
            // find key (element) by value - max occurrence
            for (var entry : map.entrySet()) {
                if (entry.getValue() == maxOcc) {
                    return entry.getKey();
                }

            }
            return -1;
        }
    }
}
