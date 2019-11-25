package leetcode.November_Leetcode;

/**
 * @author caoduanxi
 * @2019/11/5 20:23
 */
public class Test1105 {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs.length == 0 || (m == 0 && n == 0)) return 0;
        int[][] dp = new int[m + 1][n + 1];
        // 只需要确定第一行，第一列
        dp[0][0] = 0;
        // 首先统计strs中的0 1数目
        for (int i = 0; i < strs.length; i++) {
            int zeros = 0;
            int ones = 0;
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) - '0' == 0) {
                    zeros++;
                } else {
                    ones++;
                }
            }
            for (int k = m; k >= zeros; k--) {
                for (int l = n; l >= ones; l--) {
                    dp[k][l] = Math.max(dp[k][l], 1 + dp[k - zeros][l - ones]);
                }
            }
        }
        return dp[m][n];

//        for (int i = 1; i < m; i++) {
//            // 需要确定第一行的数据
//            dp[i][0] = ;
//        }
//        for (int j = 0; j < n; j++) {
//            // 需要确定第一列的数据
//            dp[0][j] = ;
//        }
        // dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+1;
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
//            }
//        }
//        return dp[m][n];
    }

    public boolean isExist(String[] strs, String str) {
        for (String s : strs) {
            if (s.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
