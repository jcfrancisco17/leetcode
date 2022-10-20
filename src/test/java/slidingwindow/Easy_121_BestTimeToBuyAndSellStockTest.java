package slidingwindow;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">Question 121</a>
 *
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * </p>
 *
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the
 * future to sell that stock.
 * </p>
 *
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * </p>
 *
 * <pre>
 *  Example 1:
 *      Input: prices = [7,1,5,3,6,4]
 *      Output: 5
 *      Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *      Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 *
 *  Example 2:
 *      Input: prices = [7,6,4,3,1]
 *      Output: 0
 *      Explanation: In this case, no transactions are done and the max profit = 0.
 *
 *
 *  Constraints:
 *      1 <= prices.length <= 105
 *      0 <= prices[i] <= 104
 * </pre>
 */
class Easy_121_BestTimeToBuyAndSellStockTest {

    @Test
    void testCases() {
        assertThat(Solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4})).isEqualTo(5);
        assertThat(Solution.maxProfit(new int[]{7, 6, 4, 3, 1})).isZero();
    }

    /**
     * <p>
     * Uses two pointers. The first pointer is for buying which starts at zero, while the second pointer if for
     * selling which starts one. This is because buying happens first before selling.
     * </p>
     *
     * <p>
     * If the selling price is greater than the buying price, compute for the profit and compare it against the
     * recorded profit. If the selling price is lower than the buying price, update the buying price with the
     * selling price. This means a lower price has been found.
     * </p>
     */
    private static class Solution {
        private static int maxProfit(int[] prices) {
            int profit = 0;
            int buy = 0;
            int sell = 1;

            while (sell < prices.length) {
                if (prices[sell] > prices[buy]) {
                    profit = Math.max(profit, prices[sell] - prices[buy]);
                } else {
                    buy = sell;
                }
                sell++;
            }

            return profit;
        }
    }
}
