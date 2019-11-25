package leetcode.November_Leetcode;

import java.util.Arrays;

/**
 * @author caoduanxi
 * @2019/11/10 18:55
 */
public class Test1110 {
    // 记忆化数组解决问题
    static int[] memo = null;

    // 使用递归解决问题
    public static int numDecodings(String s) {
        memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        return decoding(s, 0);
    }

    private static int decoding(String s, int start) {
        // 如果到了最后一个，表名有一种情况，返回1
        if (start == s.length()) {
            return 1;
        }
        // 对第一个的0做判断，是0的话直接返回0
        // 主要是0不代表任何字母，所以导致为0的话直接返回，不作处理
        if (s.charAt(start) == '0') {
            return 0;
        }
        if (memo[start] != -1) {
            return memo[start];
        }
        // 只用管第一位和第二位，因为超过三位的直接就超出了26
        int ans1 = decoding(s, start + 1);
        int ans2 = 0;
        if (start < s.length() - 1) {
            int ten = (s.charAt(start) - '0') * 10;
            int one = s.charAt(start + 1) - '0';
            if (ten + one <= 26) {
                // 如果前面两个小于26，直接往下走，大于的话，直接返回
                ans2 += decoding(s, start + 2);
            }
        }
        return memo[start] = ans1 + ans2;
    }

    // 使用动态规划解决问题
    public static int numDecodings1(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        if (s.charAt(len - 1) != '0') {
            dp[len - 1] = 1;
        }
        // i指代的是上面记忆化中的下标
        for (int i = len - 2; i >= 0; i--) {
            if(s.charAt(i) == '0') continue;
            int ans1 = dp[i + 1];
            int ans2 = 0;
            int ten = (s.charAt(i) - '0') * 10;
            int one = s.charAt(i + 1) - '0';
            if (ten + one <= 26) {
                // 如果前面两个小于26，直接往下走，大于的话，直接返回
                ans2 = dp[i + 2];
            }
            dp[i] = ans1 + ans2;
        }

        return dp[0];
    }


    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }
}
