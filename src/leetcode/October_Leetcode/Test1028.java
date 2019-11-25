package leetcode.October_Leetcode;

import java.util.Arrays;

/**
 * @author caoduanxi
 * @2019/10/28 20:38
 */
public class Test1028 {
    // 求至少需要多少钱才可以保证自己赢得比赛
    public int getMoneyAmount1(int n) {
        // 只有一个数字，一猜就中
        if (n == 1) return 0;
        return getMoney(1, n);
    }

    // 修改后的暴力法
    // 时间复杂度O(n!),选择一个数作为尝试，然后在递归中再选一个数，重复n次时间复杂度为O(n!)
    private int getMoney(int low, int high) {
        if (low >= high) return 0;
        int minRes = Integer.MAX_VALUE;
        for (int i = (low + high) / 2; i <= high; i++) {
            // 一个获取前面的最大值，一个获取后面的最大值
            int res = i + Math.max(getMoney(i + 1, high), getMoney(low, i - 1));
            minRes = Math.min(res, minRes);
        }
        return minRes;
    }

//    private int getMoney(int low, int high) {
//        if (low >= high) return 0;
//        int minRes = Integer.MAX_VALUE;
//        for (int i = low; i <= high; i++) {
//            // 一个获取前面的最大值，一个获取后面的最大值
//            int res = i + Math.max(getMoney(i + 1, high), getMoney(low, i - 1));
//            minRes = Math.min(res, minRes);
//        }
//        return minRes;
//    }
    // 答案给出的解法，时间复杂度O(n^3），遍历dp需要O(n^2)
    // 空间复杂度：O(n^2)
    // 没看懂
    public int getMoneyAmount(int n) {
        if (n == 1) return 0;
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int minRes = Integer.MAX_VALUE;
                for (int prv = start; prv < start + len - 1; prv++) {
                    int res = prv + Math.max(dp[start][prv - 1], dp[prv+1][start + len - 1]);
                    minRes = Math.min(res, minRes);
                }
                dp[start][start + len - 1] = minRes;
            }
        }
        return dp[1][n];
    }

    // 使用一个数组存储结果
    // 时间复杂度O(n^3)
    // 空间复杂度O(n^2)
    public int getMoneyAmount2(int n) {
        if(n == 1) return 0;
        int[][] memo = new int[n+1][n+1];
        return calculateMoney(1,n,memo);

    }
    private int calculateMoney(int low, int high, int[][] memo) {
        if (low >= high) return 0;
        if (memo[low][high] != 0) return memo[low][high];
        int minRes = Integer.MAX_VALUE;
        for (int i = (low+high)/2; i <= high; i++) {
            int res = i + Math.max(calculateMoney(i + 1, high, memo), calculateMoney(low, i - 1, memo));
            minRes = Math.min(res, minRes);
        }
        memo[low][high] = minRes;
        return minRes;
    }

}
