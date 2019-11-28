package leetcode.November_Leetcode;

import java.util.Arrays;

/**
 * @author caoduanxi
 * @2019/11/28 19:46
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * n-1 与 n-2的交叉合并爬
 */
public class Test1128 {
    static int[] memo;

    public static int climbStairs(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return tryStep(n);
    }

    private static int tryStep(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (memo[n] != -1) return memo[n];
        return memo[n] = tryStep(n - 1) + tryStep(n - 2);
    }
    // 动态规划
    public static int climbStairs1(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs1(4));
    }
}
