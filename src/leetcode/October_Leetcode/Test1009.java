package leetcode.October_Leetcode;

/**
 * @author caoduanxi
 * @2019/10/9 21:27
 */
public class Test1009 {
    // 前提：该序列至少包含一个数
    // 找出乘积最大的连续子序列
    public static int maxProduct1(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        int preMin = nums[0];
        int preMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 用两个指针，一个存最大值，一个存最小值
            int curMax = Math.max(Math.max(preMax*nums[i],preMin*nums[i]),nums[i]);
            int curMin = Math.min(Math.min(preMax*nums[i],preMin*nums[i]),nums[i]);
            dp[i+1] = Math.max(dp[i],curMax);
            preMax = curMax;
            preMin = curMin;
        }
        return dp[nums.length];
    }
    public int maxProduct2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = nums[0];
        int pre_max = nums[0];
        int pre_min = nums[0];
        // 用两个数，一个保存最大，一个保存最小的，
        for (int i = 1; i < nums.length; i++) {
            int cur_max = Math.max(Math.max(pre_max * nums[i], pre_min * nums[i]), nums[i]);
            int cur_min = Math.min(Math.min(pre_max * nums[i], pre_min * nums[i]), nums[i]);
            res = Math.max(res, cur_max);
            pre_max = cur_max;
            pre_min = cur_min;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = new int[]{2, 3, -2, 4};
        System.out.println(maxProduct1(num));
    }

    // 暴力法
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int temp = 1;
            for (int j = 0; j < i; j++) {

            }
        }
        return 0;
    }

    // 最大子序和
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int sum = 0;
        dp[0] = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            dp[i + 1] = Math.max(dp[i], sum);
        }
        return dp[nums.length];
    }

}
