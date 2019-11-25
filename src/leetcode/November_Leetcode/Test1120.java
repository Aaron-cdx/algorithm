package leetcode.November_Leetcode;

import java.util.Arrays;

/**
 * @author caoduanxi
 * @2019/11/20 21:35
 */
public class Test1120 {
    public static void main(String[] args) {
//        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums = new int[]{0};
        System.out.println(lengthOfLIS(nums));
    }


    //    private static int LongIS(int[] nums) {
//
//        getLongIS(nums, 0, nums[0], 1);
//        return res;
//    }
//
//    private static void getLongIS(int[] nums, int index, int num, int length) {
//        if (index >= nums.length) return;
//        for (int j = 0; j < nums.length; j++) {
//            for (int i = index; i < nums.length; i++) {
//                if (nums[i] > num) {
//                    getLongIS(nums,i,nums[i],length+1);
//                }
//            }
//        }
//        if(length > res){
//            res = length;
//        }
//    }
    static int[] memo = null;
    static int res = 0;

    // 最长上升子序列
    // 这是一定可以使用递归方法解决，然后使用记忆数组可以解决这个问题
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        memo = new int[nums.length];
        Arrays.fill(memo, 1);
        // 需要对每一求解
        for (int i = 0; i < nums.length; i++) {
            getLongIS(nums, i, nums[i], 1);
        }
        return res;
    }

    // 使用res记录总的
    private static void getLongIS(int[] nums, int index, int num, int length) {
        // 对每一个递归，只要大于自己的就加一，加完之后，变更全局长度
        for (int i = index; i < nums.length; i++) {
            if (nums[i] > num) {
                if (memo[i] != 1) {
                    res = Math.max(res, memo[i]);
                } else {
                    getLongIS(nums, i, nums[i], length + 1);
                }
            }
        }
        // 赋值
        if (length > res) {
            res = length;
            memo[index] = res;
        }
    }

    public static int lengthOfLIS1(int[] nums) {
        // 采用动态规划法
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            // 每一次判断一轮，在只要自己比前面的大就+1判断长度
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 1;
        for (int num : dp) {
            res = Math.max(num, res);
        }
        return res;
    }

    // 二分法
    public static int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0;
            int j = res;
            while (i < j) {
                int mid = (i+j)/2;
                // 如果中间的数小于当前的数，i继续向后走，看看有没有机会接到最后面
                if(dp[mid] < num) i=mid+1;
                // 否则用j代替mid的位置，继续向前判断值，如果没有大于的，如果没有大于的，这个mid会向0走
                else j = mid;
            }
            // 给保存的数组赋值，其中i的变化由循环中的逻辑来处理
            dp[i] = num;
            // 如果结果与j值相等,其实j值就是res顺利时候往后推进的指针
            if (res == j) {
                res++;
            }
        }
        return res;
    }
}
