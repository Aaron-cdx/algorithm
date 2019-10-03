package leetcode.Septmber_Leetcode;

/**
 * @author caoduanxi
 * @2019/9/29 21:43
 */
public class Test28 {
    // 不同路径问题
    // 判断从左上角的点到右下角的点有多少条路径
    // dp[i][j] = dp[i-1][j] + dp[i][j-1]
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] arr = new int[2][3];
        // 行列
        System.out.println(arr.length);
        System.out.println(arr[0].length);
    }
}
