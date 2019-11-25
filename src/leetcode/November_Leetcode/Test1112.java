package leetcode.November_Leetcode;

/**
 * @author caoduanxi
 * @2019/11/12 22:04
 */
public class Test1112 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1) return 0;
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        obstacleGrid[0][0] = 1;
        for (int i = 1; i < row; i++) {
            // 第一行的数字依赖于前一个数字的值。因为需要防止1扩散
            if(obstacleGrid[i][0] != 1 && obstacleGrid[i-1][0] != 0){
                obstacleGrid[i][0] = 1;
            }else{
                obstacleGrid[i][0] = 0;
            }
        }
        for (int i = 1; i < col; i++) {
            if(obstacleGrid[0][i] != 1 && obstacleGrid[0][i-1] != 0){
                obstacleGrid[0][i] = 1;
            }else{
                obstacleGrid[0][i] = 0;
            }
        }
        // 只要为1就为0，否则就相加
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }
        return obstacleGrid[row - 1][col - 1];
    }
}
