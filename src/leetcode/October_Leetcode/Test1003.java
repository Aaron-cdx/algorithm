package leetcode.October_Leetcode;

/**
 * @author caoduanxi
 * @2019/10/3 19:46
 * <p>
 * 题目：爬楼梯，需要n阶到楼顶
 * 每次可以选择1阶楼梯或者两阶楼梯
 * 问有多少中方案上楼
 */
public class Test1003 {
    // 分析题目发现这是一道斐波那契数列题，
    // 可以知道当前的值等于i-1和i-2的值相加
    // 时间复杂度为O(n) 空间复杂度O(n)
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
    // 暴力法，求1和2分别行走的个数相加
    // 时间复杂度O(2^n) 空间复杂度O(1)
    public static int climbStairs2(int n) {
        return climbStairs(0, n);
    }

    public static int climbStairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climbStairs(i + 1, n) + climbStairs(i + 2, n);
    }

    // 记忆型递归，用一个数组来记忆下递归到这里的数值
    // 时间复杂度O(n)  空间复杂度O(n)
    public static int climbStairs(int n) {
        int[] memo = new int[n+1];
        return climb_stairs(0,n,memo);
    }

    private static int climb_stairs(int i, int n, int[] memo) {
        if(i > n){
            return 0;
        }
        if(i == n){
            return 1;
        }
        // 看看有没有之前计算过的值，有的话直接返回，从而节省了计算时间
        if(memo[i] > 0){
            return memo[i];
        }
        memo[i] = climb_stairs(i+1,n,memo)+climb_stairs(i+2,n,memo);
        return memo[i];
    }


    public static void main(String[] args) {
        System.out.println(climbStairs(44));
    }
}
