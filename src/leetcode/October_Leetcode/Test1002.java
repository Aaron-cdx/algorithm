package leetcode.October_Leetcode;

/**
 * @author caoduanxi
 * @2019/10/2 20:02
 */
public class Test1002 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 第一个数，如果自己就是障碍物，那么就此结束，否则为1
                if (i == 0 && j == 0) {
                    if (obstacleGrid[i][j] == 1) {
                        return 0;
                    } else {
                        dp[i][j] = 1;
                    }
                }
                if (i == 0 && j != 0) {
                    // 边界上如果是0，且自己上一个也是0，那么表示没有遇到障碍物
                    // 但是为了避免之前遇见过障碍物，所以使用自己等同于前一个
                    if (obstacleGrid[i][j] == 0 && obstacleGrid[i][j - 1] == 0) {
                        dp[i][j] = dp[i][j - 1];
                    }
                    // 是障碍物或者前一个是障碍物的话，则不做处理，0
                }
                // 同上
                if (j == 0 && i != 0) {
                    if (obstacleGrid[i][j] == 0 && obstacleGrid[i - 1][j] == 0) {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
                // 如果不是边界，涉及到上左的相加
                if (i != 0 && j != 0) {
                    if (obstacleGrid[i][j] == 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /*public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                // 第一个数，如果自己就是障碍物，那么就此结束，否则为1
                if (i == 0 && j == 0) {
                    if (obstacleGrid[i][j] == 1) {
                        return 0;
                    } else {
                        obstacleGrid[i][j] = 1;
                    }
                }
                if (i == 0 && j != 0) {
                    // 边界上如果是0，且自己上一个也是0，那么表示没有遇到障碍物
                    // 但是为了避免之前遇见过障碍物，所以使用自己等同于前一个
                    if (obstacleGrid[i][j] == 0 && obstacleGrid[i][j - 1] == 0) {
                        obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                    }
                    // 是障碍物或者前一个是障碍物的话，则不做处理，0
                }
                // 同上
                if (j == 0 && i != 0) {
                    if (obstacleGrid[i][j] == 0 && obstacleGrid[i - 1][j] == 0) {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                    }
                }
                // 如果不是边界，涉及到上左的相加
                if (i != 0 && j != 0) {
                    if (obstacleGrid[i][j] == 0) {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                    }
                }
            }
        }
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }*/
}
