package leetcode.October_Leetcode;

import java.util.Arrays;

/**
 * @author caoduanxi
 * @2019/10/12 19:10
 */
public class Test1012 {

    public static int rob(int[] nums) {
        // 只需要判断最后一个和第一个是否成环，成环的话就不偷
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (nums.length == 1) {
            return dp[0];
        }
        return Math.max(findMax(Arrays.copyOfRange(nums,0,nums.length-1)),
                findMax(Arrays.copyOfRange(nums,1,nums.length)));
        // 先计算偷第一个房间的，不偷最后一个房间的
        // 在计算不偷第一个房间的，偷最后一个房间的
    }
    public static int findMax(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if(nums.length > 1){
            dp[1] = Math.max(dp[0],nums[1]);
        }
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0};
        System.out.println(rob(nums));
    }
}
