package leetcode.Septmber_Leetcode;

/**
 * @author caoduanxi
 * @2019/9/28 22:07
 */
public class Test27 {
    // 暴力法，直接记录每次的相加和
    // 复杂度O(n^2)
    public int maxSubArray1(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if(temp > max){
                max = temp;
            }
            for (int j = i+1; j < nums.length; j++) {
                temp += nums[j];
                if(temp > max){
                    max = temp;
                }
            }
        }
        return max;
    }
    // 动态规划法 区间最大一定是有一段大于0呈现递增的情况
    // 这一题的解法，如果sum>0，判定sum对于计算下去的数是有增益的效果
    // 如果sum <= 0，表示sum对于之后的结果没有增益效果
    // 每次比较sum与ans的大小，最后得出结果
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(sum > 0){
                sum += nums[i];
            }else {
                sum = nums[i];
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }
    // 利用一个dp[i]的数组存储结果
    public int maxSubArray3(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < len; i++) {
            if (dp[i - 1] >= 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }

        // 最后不要忘记全部看一遍求最大值
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 第三种分治法：待学习
    public int maxSubArray4(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        return maxSubArraySum(nums, 0, len - 1);
    }


    // 第三种分治法：待学习
    private int maxCrossingSum(int[] nums, int left, int mid, int right) {
        // 一定会包含 nums[mid] 这个元素
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        // 左半边包含 nums[mid] 元素，最多可以到什么地方
        // 走到最边界，看看最值是什么
        // 计算以 mid 结尾的最大的子数组的和
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        // 右半边不包含 nums[mid] 元素，最多可以到什么地方
        // 计算以 mid+1 开始的最大的子数组的和
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;

    }

    private int maxSubArraySum(int[] nums, int left, int right) {
        // 为了避开只有一个数的情况
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) >>> 1;// 向右移动一位，表示除以2
        // 计算前半部分
        return max3(maxSubArraySum(nums, left, mid),
                // 计算后半部分
                maxSubArraySum(nums, mid + 1, right),
                // 计算跨越时候获取的值
                maxCrossingSum(nums, left, mid, right));
    }

    private int max3(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }

    public static void main(String[] args) {
        System.out.println(2 >>> 1);
    }
}
