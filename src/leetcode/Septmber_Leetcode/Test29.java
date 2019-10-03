package leetcode.Septmber_Leetcode;

/**
 * @author caoduanxi
 * @2019/9/30 22:15
 */
public class Test29 {
    // 时间复杂度O(nm)
    // 空间复杂度O(nm)
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // 新建dp数组
        int[][] dp = new int[n][m];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 给第一个赋值
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                }
                // 在边界上第一行
                if (i == 0 && j != 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }
                // 在边界上第一列
                if (j == 0 && i != 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                }
                // 不在边界上，此时的值只可能来自上面或者左边，获取前一个值的最小值即可
                if (i != 0 && j != 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        // 返回结果
        return dp[n - 1][m - 1];
    }

    /*public int minPathSum(int[][] grid) {
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j != grid[0].length - 1)
                    grid[i][j] = grid[i][j] + grid[i][j + 1];
                else if (j == grid[0].length - 1 && i != grid.length - 1)
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                else if (j != grid[0].length - 1 && i != grid.length - 1)
                    grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
            }
        }
        return grid[0][0];
    }*/
}
