package leetcode.November_Leetcode;

import java.util.Arrays;

/**
 * @author caoduanxi
 * @2019/11/8 18:39
 */
public class Test1108 {
    // 首先使用递归法，发现重叠子问题
    // 使用记忆化数组
    static int[] memo = null;

    public static int integerBreak1(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return breakNum(n);
    }

    private static int breakNum(int n) {
        // 递归的终止条件
        if (n <= 2) return 1;
        if (memo[n] != -1) {
            return memo[n];
        }
        // 至少分成两个数，这个n永远是最后一个n
        // 遍历所有分割可能性
        int res = 0;
        for (int i = 2; i < n; i++) {
            // 至少分割为两部分
            res = max3(res, i * breakNum(n - i), i * (n - i));
        }
        return memo[n] = res;
    }

    // 使用动态规划，双重for循环，可以代表需要递归的n-i
    public static int integerBreak(int n) {
        if(n <= 2) return 1;
        int[] memo = new int[n+1];
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            int res = 0;
            for (int j = 1; j < i; j++) {
                res = max3(res,j*memo[i-j],j*(i-j));
            }
            memo[i] = res;
        }
        return memo[n];
    }


    public static int max3(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }


    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
}
