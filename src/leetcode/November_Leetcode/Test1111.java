package leetcode.November_Leetcode;

import java.util.Arrays;

/**
 * @author caoduanxi
 * @2019/11/11 21:28
 * 62-不同路径-medium
 */
public class Test1111 {
    public static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[][] dp = new int[m][n];
        // 行和列初始化
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        // 值只能从上面来或者左边来
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        // 返回右下角的值
        return dp[m - 1][n - 1];
    }

    // 利用空间压缩，O(n)空间复杂度
    public static int uniquePaths1(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        int big = Math.max(m, n);
        int less = Math.min(m, n);
        int[] dp = new int[less];
        Arrays.fill(dp, 1);
        for (int i = 1; i < big; i++) {
            // 使用dp暂存上一次计算的这一列的值
            // dp[1] = dp[0]+dp[1] dp[2]=dp[2]+dp[1]
            for (int j = 1; j < less; j++) {
                // 只需要更新列即可
                // 保留一个暂存值，实质还是上面下来，和左边过来
                dp[j] += dp[j - 1];
            }
        }
        return dp[less - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 3));
    }

//    private int getPath(int m, int n, int row, int col) {
//        if (row >= m || col >= n) {
//            return 0;
//        }
//        for (int i = 0; i <= m; i++) {
//
//        }
//    }
}
