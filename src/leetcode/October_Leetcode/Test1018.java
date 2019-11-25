package leetcode.October_Leetcode;

import java.util.Arrays;

/**
 * @author caoduanxi
 * @2019/10/18 19:21
 */
public class Test1018 {
    // 这一题也写不出，我都不知道这段时间的自己在干什么！
    // 暴力法：时间复杂度O(n^2)
    public static int lengthOfLIS1(int[] nums) {
        return getLength(nums, Integer.MIN_VALUE, 0);
    }

    public static int getLength(int[] nums, int pre, int cur) {
        if (cur == nums.length) return 0;
        int count = 0;
        if (nums[cur] > pre) {
            count = 1 + getLength(nums, nums[cur], cur + 1);
        }
        int noCount = getLength(nums, pre, cur + 1);
        return Math.max(noCount, count);
    }
    // 时间复杂度O(n^2) 空间复杂度O(N)
    public static int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 每一次遍历可以获取到一个最大的值
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    // 时间复杂度O(nlogn)
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0;
            // 当前tails的长度
            int j = res;
            // i < j
            while (i < j) {
                int m = (i + j) / 2;
                // 通过二分法找出分界点
                if (tails[m] < num) {
                    // 表明后面接一个更大数的可能性更大
                    i = m + 1;
                } else {
                    // 如果区间不存在的话，此时的中间分界点可以接在之前所有的节点之后
                    j = m;
                }
            }
            tails[i] = num;
            if (res == j) res++;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
