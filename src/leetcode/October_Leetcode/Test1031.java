package leetcode.October_Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author caoduanxi
 * @2019/10/31 19:19
 */
public class Test1031 {
    // 回溯法属于暴力法，超出时间限制，只能采用动态规划
    public static int combinationSum4(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int[] memo = new int[nums.length + 1];
        combine4(nums, res, target, 0, new ArrayList<>());
        return res.size();
    }

    public static void combine4(int[] nums, List<List<Integer>> res, int target, int start, List<Integer> list) {
        if (target < 0) return;

        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        // 因为可以复用所以这里i=0
        for (int i = 0; i < nums.length; i++) {
            if (target - nums[i] < 0) break;
            list.add(nums[i]);
            combine4(nums, res, target - nums[i], i, list);
            list.remove(list.size() - 1);
        }
    }

    // 动态规划第一种解法是利用memo[]存储来回溯
    // [1,2,3] 4  dp[4] = dp[3]+dp[2]+dp[1]
    public static int combinationSum(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        // dp[i] = dp[i-1]+dp[i-2]
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    // 备忘录法 记忆化搜索
    static int[] memo = null;

    public static int combinationSum2(int[] nums, int target) {
        if (nums.length == 0) return 0;
        memo = new int[target + 1];
        return combine(nums, target);
    }

    private static int combine(int[] nums, int target) {
        if (target == 0) return 1;
        int res = 0;
        // 如果存在直接返回
        if (memo[target] != 0) return memo[target];
        for (int num : nums) {
            // 否则参与计算
            if (target >= num) {
                res += combine(nums, target - num);
            }
        }
        // 给备忘录赋值
        return memo[target] = res;
    }


    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{1, 2, 3}, 4));
    }
}
