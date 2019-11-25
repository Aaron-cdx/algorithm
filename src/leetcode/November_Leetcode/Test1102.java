package leetcode.November_Leetcode;

import java.util.Arrays;

/**
 * @author caoduanxi
 * @2019/11/2 20:23
 */
public class Test1102 {
    public static boolean canPartition1(int[] nums) {
        // 先对数组进行排序
        Arrays.sort(nums);
        int[] arr = Arrays.copyOfRange(nums, 0, nums.length - 1);
        // 从后往前判断
        int[] arr2 = Arrays.copyOfRange(nums, nums.length - 1, nums.length);
        return partition(nums, arr, 0, nums[nums.length - 1]) || partition2(nums, arr2, nums.length - 1, getRes(Arrays.copyOfRange(nums, 0, nums.length - 1)));
    }

    private static boolean partition(int[] nums, int[] arr, int index, int end) {
        int cnt1 = getRes(arr);
        if (cnt1 == end) return true;
        if (cnt1 > end)
            return partition(nums, Arrays.copyOfRange(nums, index + 1, nums.length - 1), index + 1, end + getRes(Arrays.copyOfRange(nums, 0, index + 1)));
        return false;
    }

    private static boolean partition2(int[] nums, int[] arr, int index, int end) {
        int cnt = getRes(arr);
        if (cnt == end) return true;
        if (cnt < end)
            return partition2(nums, Arrays.copyOfRange(nums, index - 1, nums.length), index - 1, end - getRes(Arrays.copyOfRange(nums, index - 1, nums.length - 1)));
        return false;
    }

    private static int getRes(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        // 我们需要获取的是整个数组总和的一半
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length][target + 1];
        // 先写第一行,看第一个数是否能够刚好填满第一行
        for (int i = 1; i < target + 1; i++) {
            if (nums[0] == i) {
                dp[i][0] = true;
            }
        }

        // 这里dp[i][j]=dp[i-1][j] i表示物品索引
        // 第一个用来表示索引，第二个用来装数字
        // i表示物品
        for (int i = 1; i < nums.length; i++) {
            // j表示容量
            for (int j = 0; j < target + 1; j++) {
                // 表明当前的值与上面的值一致
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][target];
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        // 我们需要获取的是整个数组总和的一半
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        // 直接判断第一行有没有等于target的，有的话，dp[i] = true
        // 直接break，后面不可能等于nums[0]了
        for (int i = 0; i < target + 1; i++) {
            if (nums[0] == i) {
                dp[i] = true;
                break;
            }
        }
        // i表示物品，j表示容量
        for (int i = 1; i < nums.length; i++) {
            // 从后往前判断 容量一定要大于物品大小，如果容量小于物品，没必要做判断了
            for (int j = target; j >= 0 && j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }


    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{3, 3, 3, 4, 5}));
    }
}
