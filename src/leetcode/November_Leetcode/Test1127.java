package leetcode.November_Leetcode;

/**
 * @author caoduanxi
 * @2019/11/27 21:03
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，
 * 你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 解题分析，一个数组，里面+号的加上-号的需要为target
 * sum(p)表示正号 sum(n)表示负号 两者均是表示大小
 * sum(p)-sum(n) = target
 * sum(nums)+sum(p)-sum(n)=target+sum(nums)
 * ====> sum(nums)-sum(n)=sum(p)
 * 2sum(p) = target+sum(nums)
 * sum(p) = (target+sum(nums))/2 ==>变身背包问题
 */
public class Test1127 {
    public static int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) return 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 如果总和小于S的话，直接就是0，怎么组合都得不到
        if (sum < S || (sum + S) % 2 == 1) return 0;
        sum = (sum + S) / 2;
        int n = nums.length;
        // 用于存储有多少种为S的组合
        int dp[] = new int[sum + 1];
        // 赋初值
//        for (int i = 0; i <= sum; i++) {
//            dp[i] = nums[0];
//        }
        dp[0] = 1; // 至少一种
        // 物品
        for (int i = 0; i < n; i++) {
            // 背包
            for (int j = sum; j >= nums[i] && j >= 0; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[sum];
    }

    static int count = 0;

    public static int findTargetSumWays1(int[] nums, int S) {
        findCount(nums, S, 0, nums.length);
        return count;
    }

    private static void findCount(int[] nums, int s, int start, int end) {
        // 这表示符合情况到了最后
        if (start == end && s == 0) {
            count++;
            return;
        }
        // 这表示最后不符合情况，但是又到了最后
        if(start == end){
            return;
        }
        // 这里判断组合为+或者-的情况
        int s1 = s - nums[start];
        int s2 = s + nums[start];
        findCount(nums, s1, start + 1, end);
        findCount(nums, s2, start + 1, end);
    }


    public static void main(String[] args) {
        System.out.println(findTargetSumWays1(new int[]{1}, 1));
    }
}
