package leetcode.November_Leetcode;

import java.util.Arrays;

/**
 * @author caoduanxi
 * @2019/11/18 20:56
 * 0-1背包问题
 * id       0       1       2
 * weight   1       2       3
 * value    6       10      12
 * 问一个容量为5的背包如何获取最大价值的物品？
 */
public class Test1118 {
    static int[][] memo = null;

    public static int knapsick(int[] w, int[] v, int C) {
        int n = w.length;
        memo = new int[n][C + 1];
        // 填充-1
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return solveKnap(w, v, 0, n - 1, C);
    }

    private static int solveKnap(int[] w, int[] v, int index, int n, int C) {
        // 索引，指示获取到第几个物品处
        if (index > n) return 0;
        // 先获取不偷这个物品的结果
        if (memo[index][C] != -1)
            return memo[index][C];
        int res = solveKnap(w, v, index + 1, n, C);
        for (int i = index; i <= n; i++) {
            // 这里要确保背包的容量是大于0的才可以偷取，否则不能偷取
            res = Math.max(res, C - w[i] >= 0 ? (v[i] + solveKnap(w, v, i + 1, n, C - w[i])) : 0);
        }
        return memo[index][C] = res;
    }

    public static int knapsick1(int[] w, int[] v, int C) {
        int n = w.length;
        if (w.length != v.length) return 0;
        int dp[][] = new int[n][C + 1];
        // 初始化第一行
        for (int i = 1; i <= C; i++) {
            dp[0][i] = v[0];
        }
        // 第几个物品
        for (int i = 1; i < n; i++) {
            // 背包容量大小
            for (int j = 1; j <= C; j++) {
                // 比较的是不偷与偷之间的大小，获取最大的为当前的值
                // 如果不偷就直接是上面的值了，如果偷的话，就要判断能不能头，能偷的话，不继承上面的值
                // 需要使用上面的值就是减去当前背包重量以后的还可以偷取的最大值
                // dp[j-1][i-w[j]]表示上一轮中此背包容量能偷取的最大值
                dp[i][j] = Math.max(dp[i - 1][j], (j - w[i] >= 0) ? v[i] + dp[i - 1][j - w[i]] : 0);
            }
        }
        return dp[n - 1][C];
    }

    // 由于空间复杂度是O(n*C)，而根据上面的可得到，每次的i只i-1相关
    // 所以只需要存储i-1的信息即可O(2*C)
    public static int knapsick2(int[] w, int[] v, int C) {
        int n = w.length;
        if (w.length != v.length) return 0;
        int dp[][] = new int[n][C + 1];
        // 初始化第一行
        for (int i = 1; i <= C; i++) {
            dp[0][i] = v[0];
        }
        // 第几个物品
        for (int i = 1; i < n; i++) {
            // 背包容量大小
            for (int j = 1; j <= C; j++) {
                // dp[j-1][i-w[j]]表示上一轮中此背包容量能偷取的最大值,就是表明此背包剩下的容量最大可以背多少！
                // 可以只用两个空间来表示，因为第i每次都是以来i-1
                dp[i % 2][j] = Math.max(dp[(i - 1) % 2][j], (j - w[i] >= 0) ? v[i] + dp[(i - 1) % 2][j - w[i]] : 0);
            }
        }
        return dp[(n - 1) % 2][C];
    }

    // 使用O(C)的空间来存储
    public static int knapsick3(int[] w, int[] v, int C) {
        int n = w.length;
        if (w.length != v.length) return 0;
        int[] dp = new int[C + 1];
        for (int i = 1; i <= C; i++) {
            dp[i] = v[0];
        }
        for (int i = 1; i < n; i++) {
            // 从最大的开始  使用j>=w[i]是为了及时停止，不重复加小的值
            // 只有容量大的时候才可偷取，这样的更新可以做大只更新最大的
            for (int j = C; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], v[i] + dp[j - w[i]]);
            }
        }
        return dp[C];
    }


    public static void main(String[] args) {
        System.out.println(knapsick3(new int[]{1, 2, 3}, new int[]{6, 10, 12}, 5));
    }
}
