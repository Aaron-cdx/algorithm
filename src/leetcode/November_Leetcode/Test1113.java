package leetcode.November_Leetcode;

import java.util.Arrays;

/**
 * @author caoduanxi
 * @2019/11/13 22:21
 */
public class Test1113 {
    // 暴力法，偷了当前的，就只能偷你相邻的后面的了
    // 使用记忆回溯法
    static int[] memo;

    public static int rob1(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return tryRob(nums, 0);
    }

    private static int tryRob(int[] nums, int index) {

        if (index >= nums.length) return 0;
        if (memo[index] != -1) return memo[index];
        int len = nums.length;
        int res = 0;
        for (int i = index; i < len; i++) {
            // 如果偷了0，那么后面的只能偷2号
            res = Math.max(res, nums[i] + tryRob(nums, i + 2));
        }
        return memo[index] = res;
    }

    // 动态规划
    public static int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        // 递归从前到后，那么动态规划就从后往前
        // 初始化最后一个数就为nums的最后一个数
        dp[n - 1] = nums[n - 1];
        // 目前要求的就是[0,n-2]的最大值
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                // 这里需要判断是否数组会越界
                // 使用dp[i]去存储结果res,从i向后判断
                dp[i] = Math.max(dp[i], nums[j] + ((j + 2) < n ? dp[j + 2] : 0));
            }
        }
        return dp[0];
    }

    // 动态规划II
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int len = nums.length;
        int[] dp = new int[len+1];
        dp[0] = 0;
        dp[1] = nums[0];
        // 多添加一个0，以dp作为存储单位存储
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i-1] + dp[i - 2]);
        }
        return dp[len];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }
}
