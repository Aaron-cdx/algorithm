package leetcode.October_Leetcode;

/**
 * @author caoduanxi
 * @2019/10/24 18:21
 */
public class Test1024 {
    // 依靠规律得出的方法
    public static int integerBreak(int n) {
        if (n <= 3) return n - 1;
        int a = n / 3;
        int b = n % 3;
        // 表示可以整除
        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        }
        return (int) Math.pow(3, a) * 2;
    }

    // 动态规划法
    public static int integerBreak1(int n) {
        // 只需要三个即可，因为只在这三个里面限定：0 1 2
        int[] dp = {0, 1, 1};
        for (int i = 3; i <= n; i++) {
            dp[i % 3] = max3(1 * Math.max(dp[(i - 1) % 3], i - 1), 2 * Math.max(dp[(i - 2) % 3], i - 2), 3 * Math.max(dp[(i - 3) % 3], i - 3));
        }
        return dp[n % 3];
    }

    public static int max3(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }

    public static void main(String[] args) {
        System.out.println(integerBreak1(5));
    }
}
