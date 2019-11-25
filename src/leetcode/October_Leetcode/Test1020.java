package leetcode.October_Leetcode;

/**
 * @author caoduanxi
 * @2019/10/20 19:43
 */
public class Test1020 {
    // 买卖股票I
    // 暴力法，时间复杂度O(n^2)
    public int maxProfit1(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
//                max = Math.max(max, prices[j] - prices[i]);
//                if(prices[j] - prices[i] < 0) continue;
//                else max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    // 双指针，第一个停留在最小值处，继续向前走，继续选出最大的利润
    public int maxProfit2(int[] prices) {
        // 定义一个最小价格 双指针
        int max = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                max = Math.max(max, prices[i] - minPrice);
            }
        }
        return max;
    }

    // 时间复杂度O(n) 空间复杂度O(1)  买卖股票II
    public int maxProfit3(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }

    // 买卖股票存在冷冻期  单纯的动态规划问题
    // hold[i] = max(hold[i-1],rest[i-1] - prices[i])
    // sold[i] = hold[i-1] + prices[i]
    // rest[i] = max(rest[i-1],sold[i-1])
    public static int maxProfit(int[] prices) {
        int sold = 0;
        int hold = Integer.MIN_VALUE;
        int rest = 0;
        for (int price : prices) {
            // 卖出之前的股票,第一天最好的就是卖出，这样才可能最大
            int pre_sold = sold;
            // 卖的时候的股票
            sold = hold + price;
            // 买入时候的股票
            hold = Math.max(hold, rest - price);
            // 冷冻期时候的股票
            rest = Math.max(pre_sold, rest);
        }
        // 最后一天只能持有或者卖出，这样才可以达到最大的利润
        return Math.max(sold, rest);
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,3,0,2}));
    }

}
