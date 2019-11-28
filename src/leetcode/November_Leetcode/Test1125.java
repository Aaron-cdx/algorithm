package leetcode.November_Leetcode;

import java.util.Arrays;

/**
 * @author caoduanxi
 * @2019/11/25 20:19
 * 分割等和子集
 */
public class Test1125 {
    public static boolean canPartition(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 表明是奇数不可以分为两份
        if (sum % 2 != 0) return false;
        // 转换为典型的背包问题空间为n
        int n = sum / 2;
        // 存储一个结果集
        boolean[] dp = new boolean[n + 1];
        Arrays.fill(dp, false);
        for (int i = 1; i <= n; i++) {
            // 看是否有单个就可以填满此处的背包
            if (nums[0] == i) {
                dp[i] = true;
                break;
            }
        }
        // 如果没有单个就可以填满的，就需要使用遍历来获取结合起来能满足的了。
        // 初始化遍历已经使用了第一个数据
        // 每一次的遍历都是数组存储中结构的变化
        for (int i = 1; i < nums.length; i++) {
            // 背包容量
            for (int j = n; j >= 0 && j >= nums[i]; j--) {
                // 自己本身就能填满与自己需要自己和(j-nums[i])一起能够填满
                dp[j] = (dp[j] || dp[j - nums[i]]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 2, 5}));
    }
}
