package leetcode.October_Leetcode;

/**
 * @author caoduanxi
 * @2019/10/4 19:55
 */
public class Test1004 {
    // 时间复杂度O(mxn)
    // 空间复杂度O(mxn)
    // 可以将dp[i-1][j-1]看做替换操作
    // dp[i-1][j]看做删除操作
    // dp[i][j-1]看做插入操作
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int dp[][] = new int[m+1][n+1];
        // 第一列
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i-1][0] + 1;
        }
        // 第一行
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j-1] +1;
        }
        // 处理非第一行和第一列的情况
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 如果相等，就取上一次的最优解
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    // 不等的话，就比较上一次的最优解，和上左谁更小，取谁
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
                }
            }
        }
        // 返回最优解
        return dp[m][n];
    }
}
