package leetcode.October_Leetcode;

/**
 * @author caoduanxi
 * @2019/10/10 21:50
 */
public class Test1010 {
    // 相邻的房间被偷会触发报警
    // [2,1,1,2]
    // 每次进房间以后，看先获取第一个房间的。
    // 看1号房间和2号房间，比较两者
    // 3号房间，需要判断1和2之后，是否应该偷三号房间
    public static int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
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
        int[] num = new int[]{2,1,1,2};
        System.out.println(rob(num));
    }

    public static int rob1(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if(nums.length > 1){
            dp[1] = Math.max(dp[0],nums[1]);
        }
        for (int i = 2; i < nums.length; i++) {
            int temp = 0;
            if(i-2 != 0){
               temp = dp[i - 2] + nums[i];
            }
            dp[i] = Math.max(dp[i - 1], temp);
        }
        return dp[nums.length - 1];
    }
}
