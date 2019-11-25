package leetcode.November_Leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author caoduanxi
 * @2019/11/6 21:32
 * 120. 三角形最小路径和
 */
public class Test1106 {
    // 递归运算=>发现重复子运算，使用记忆化数组
//    int[][] memo = null;
    public int minimumTotal1(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] dp = new int[row];
        for (int i = 0; i < row; i++) {
            // 获取最后一行的所有值，因为准备的是自底向上
            dp[i] = triangle.get(row - 1).get(i);
        }
        // 最后一行已经计算完毕
        for (int i = row - 2; i >= 0; i--) {
            // 这是这一行的个数
            for (int j = 0; j <= i; j++) {
                // 6 5 7
                //4 2 8 3  此时执行的动作是判断4+6--2+6的大小判断
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0) return 0;
        int dp[][] = new int[n][triangle.get(n - 1).size()];
        // 初始化
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                // 计算第一个
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                }
                // 计算最后一个
                else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                }
                // 计算中间的
                else {
                    // 判断上面最小的往下加
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp[n - 1].length; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }
        return min;
    }

//    private int getMinTotal(List<List<Integer>> triangle, int index, int start) {
//        // 递归需要有终止条件
//        if (memo[index][start] != -1) {
//            return memo[index][start];
//        }
//        if (index == triangle.size() - 1) return triangle.get(index).get(start);
//        int left = getMinTotal(triangle, index + 1, start);
//        memo[index + 1][start] = left;
//        int right = getMinTotal(triangle, index + 1, start + 1);
//        memo[index + 1][start + 1] = right;
//        // 这个是左边右边最小值+自己的值
//        return Math.min(left, right) + triangle.get(index).get(start);
//    }
//    int[] memo = new int[]
//    public int minimumTotal(List<List<Integer>> triangle) {
//
//    }
}
