package leetcode.October_Leetcode;

/**
 * @author caoduanxi
 * @2019/10/19 19:32
 */
public class NumMatrix {

    // 暴力法超出时间限制
//    int[][] arr;
//    public NumMatrix(int[][] matrix) {
//        this.arr = matrix;
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        int sum =0;
//        for (int i = row1; i <=row2 ; i++) {
//            for (int j = col1; j <=col2 ; j++) {
//                sum += arr[i][j];
//            }
//        }
//        return sum;
//    }
    // 使用动态规划，动态存储
    // 当做正方形来做，使用面积的加减来做！
    int[][] dp;
    public NumMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return;
        this.dp = new int[matrix.length+1][matrix[0].length+1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
               dp[i+1][j+1] = dp[i+1][j] + dp[i][j+1] - dp[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2+1][col2+1] - dp[row2+1][col1] - dp[row1][col2+1] + dp[row1][col1];
    }

}
