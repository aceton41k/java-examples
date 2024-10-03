package leetcode;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

class MaxProfit {
    public static void main(String[] args) throws IOException {
        var props = new Properties();
        props.load(new FileReader("src/test/resources/array.properties"));
        int[] prices = Arrays.stream(props.getProperty("array").split(",")).mapToInt(Integer::valueOf).toArray();
        System.out.println(Solution.maxProfit(prices));
    }

    static class Solution {
        public static int maxProfit(int[] prices) {
            int maxProfit=0;
            for(int i=0; i< prices.length; i++) {
                for (int j = i+1; j<prices.length; j++) {
                    if(prices[i] < prices[j])
                        if(maxProfit <  (prices[j] - prices[i]))
                            maxProfit = prices[j] - prices[i];
                }
            }
            return maxProfit;
        }
    }
}