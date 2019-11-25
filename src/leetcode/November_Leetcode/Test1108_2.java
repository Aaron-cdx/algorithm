package leetcode.November_Leetcode;

import java.util.Arrays;

/**
 * @author caoduanxi
 * @2019/11/8 21:59
 */
public class Test1108_2 {
    // 递归法
    // 重叠子问题，使用记忆数组
    static int[] memo = null;

    public static int numSquares1(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return getSquaresNum(n);
    }

    private static int getSquaresNum(int n) {
        // 终止条件
        if (n == 0) return 0;
        if (memo[n] != -1) {
            return memo[n];
        }
        // 这是最差的条件也就是所有的都是1
        int res = n;
        // 从根号走起
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            int temp = getSquaresNum(n - i * i) + 1;
            res = Math.min(res, temp);
        }
        return memo[n] = res;
    }

    // 从记忆数组的自顶向下，改成动态规划的自底向上
    public static int numSquares(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int res = i;
            // 与自己之前的相比较
            for (int j = 1; j <= (int) Math.sqrt(i); j++) {
                res = Math.min(res, dp[i - j * j] + 1);
            }
            dp[i] = res;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(16));
    }
}
