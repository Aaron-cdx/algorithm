package leetcode.November_Leetcode;

import java.util.Arrays;

/**
 * @author caoduanxi
 * @2019/11/28 20:13
 * 问题可以转化为求最长公共子序列问题
 * 只是需要s倒置
 */
public class Test1128_1 {
    // 暴力超出时间限制
    static int memo[][];

    public static int longestPalindromeSubseq(String s) {
        memo = new int[s.length() + 1][s.length() + 1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        // s 0 s.length()-1 正序  s1 s.length()-1 0 反序
        return getLong(s, 0, s.length() - 1);
    }

    private static int getLong(String s, int start, int end) {
        if (start >= s.length() || end < 0) return 0;
        if (memo[start][end] != -1) return memo[start][end];
        int res = 0;
        if (s.charAt(start) == s.charAt(end)) {
            // 相等，互相前进
            res += 1 + getLong(s, start + 1, end - 1);
        } else {
            // 不相等，看看谁先走比较大就取谁
            res += Math.max(getLong(s, start + 1, end), getLong(s, start, end - 1));
        }
        return memo[start][end] = res;
    }

    // 使用动态规划来解决问题
    // dp[i][j]表示从第i个字符到第j个字符最长的回文序列是多长
    // 如果i与j相同，此时两者一个前一个后，+2 即dp[i+1][j-1]+2
    // 如果不相等，直接一个前一个后判断谁大取谁
    public static int longestPalindromeSubseq1(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        dp[0][n-1] = s.charAt(0) == s.charAt(n-1) ? 1 : 0;
        for (int i = n-1; i >= 0; i--) {
            // 表示所有单个字符都是1
            dp[i][i] = 1;
            for (int j = i+1; j < n; j++) {
                  if(s.charAt(i) == s.charAt(j)){
                      // 如果自己和自己相等，一次性是加2
                      // 这两个就不会出现在同一个地方，因为i是从最后面开始
                      dp[i][j] = 2 + dp[i+1][j-1];
                  }else{
                      dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                  }
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq1("bbbab"));
    }
}
