package leetcode.October_Leetcode;

/**
 * @author caoduanxi
 * @2019/10/14 19:28
 * 找到只包含1的最大的正方形，并返回它的面积
 */
public class Test1014 {
    // 时间复杂度O(mn) 空间复杂度O(mn)
    public int maximalSquare(char[][] matrix) {
        int maxSlen = 0;
        int row = matrix.length;
        int col = row > 0 ? matrix[0].length : 0;
        int[][] dp = new int[row+1][col+1];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    maxSlen = Math.max(maxSlen,dp[i][j]);
                }
            }
        }
        return maxSlen*maxSlen;
    }
    // 用暴力法先求解
    // 时间复杂度O(mn)^2 空间复杂度O(1)
    public int maximalSquare1(char[][] matrix) {
        int row = matrix.length;
        int col = row > 0 ? matrix[0].length : 0;
        int maxSlen = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(matrix[i][j] == '1'){
                    int sqLen = 1;
                    // 判断是否还是正方形
                    boolean flag = true;
                    while(sqLen+i<row && sqLen+j<col&&flag){
                        // 往下走
                        for (int k = j; k <=sqLen+j ; k++) {
                            if(matrix[i+sqLen][k] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        // 往右走
                        for (int k = i; k <=sqLen+i ; k++) {
                            if(matrix[k][j+sqLen] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        if(flag){
                            sqLen++;
                        }
                    }
                    // 结束就赋值，搞定最大
                    maxSlen = Math.max(sqLen,maxSlen);
                }
            }
        }
        return maxSlen*maxSlen;
    }
}
