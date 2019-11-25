package leetcode.October_Leetcode;

/**
 * @author caoduanxi
 * @2019/10/19 17:06
 */
public class NumArray {
    int[] numArray;
    int[] dp;

    public NumArray(int[] nums) {
        dp = new int[nums.length + 1];
        getSum(nums);
        this.numArray = nums;
    }

    // 现将结果存储起来
    public void getSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            dp[i + 1] = dp[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return dp[j + 1] - dp[i];
    }
}
