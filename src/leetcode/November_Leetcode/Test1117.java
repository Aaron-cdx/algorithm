package leetcode.November_Leetcode;

/**
 * @author caoduanxi
 * @2019/11/17 20:19
 */
public class Test1117 {
    /**
     * 解题思路：
     * 首先有3个状态，买入，卖出，冷冻
     * 定义三个状态：hold sold rest  持有 售卖 啥都不干
     * rest 可以rest[i-1]/sold[i-1]
     * hold 可以res[i-1]-prices[i]/hold[i-1]
     * sold 可以hold[i-1]+prices[i]
     * 由于sold的是售卖，可以知道hold[i-1]基本是要为负值
     * 计算每次持有的最大是多少，计算每次保持不变的rest是多少，也就是冷冻
     * 这一题主要是状态转移图的画法
     */
    public static int maxProfit1(int[] prices) {
        int len = prices.length;
        int[] rest = new int[len + 1];
        int[] hold = new int[len + 1];
        int[] sold = new int[len + 1];
        hold[0] = Integer.MIN_VALUE;
        rest[0] = 0;
        sold[0] = 0;
        for (int i = 0; i < prices.length; i++) {
            sold[i + 1] = hold[i] + prices[i];
            hold[i + 1] = Math.max(hold[i], rest[i] - prices[i]);
            rest[i + 1] = Math.max(rest[i], sold[i]);
        }
        // 肯定是卖出的时候利润最大了，保持或者冷冻的话，你肯定是获取不到最大的利润的
        return Math.max(rest[len], sold[len]);
    }

    // O(1)空间的版本
    public static int maxProfit(int[] prices) {
        int hold = Integer.MIN_VALUE;
        int sold = 0;
        int rest = 0;
        for (int price : prices) {
            // 记录前一个sold价格
            int preSold = sold;
            // 计算当前的售卖价格
            sold = hold + price;
            hold = Math.max(hold, rest - price);
            rest = Math.max(rest, preSold);
        }
        return Math.max(sold, rest);
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}
