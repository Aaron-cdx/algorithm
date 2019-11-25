package leetcode.November_Leetcode;

/**
 * @author caoduanxi
 * @2019/11/7 20:30
 * 64-最小路径和问题-medium
 */
public class Test1107 {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                }
                if(i == 0 && j-1 >= 0){
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }
                if(j == 0 && i-1 >= 0){
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }
                if(j-1 >= 0 && i-1 >= 0){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
                }
            }
        }
        return dp[row-1][col-1];
    }
    public int minPathSum1(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(i == 0 && j-1 >= 0){
                    grid[i][j] = grid[i][j-1] + grid[i][j];
                }
                if(j == 0 && i-1 >= 0){
                    grid[i][j] = grid[i-1][j] + grid[i][j];
                }
                if(j-1 >= 0 && i-1 >= 0){
                    grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1])+grid[i][j];
                }
            }
        }
        return grid[row-1][col-1];
    }
}
