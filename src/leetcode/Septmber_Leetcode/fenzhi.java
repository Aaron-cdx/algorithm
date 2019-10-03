package leetcode.Septmber_Leetcode;

/**
 * @author caoduanxi
 * @2019/9/29 22:21
 */
public class fenzhi {

    // 分治法：时间复杂度O(NlogN)  空间复杂度O(1)
    // 分支法的思想就是从中间开始将所有的值分成两份
    // 每一次都这份的数值进程处理，从中间开始，向前向后，一定是连续的
    // 这样获取到的值与前半部分获取到的值和后半部分获取到的值作对比，一定会得出最大的值
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) return len;
        return maxSubArray(nums, 0, len - 1);
    }

    public int maxSubArray(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) >> 1;
        // 这是一个递归迭代过程，二分法也从向这里开始
        return getMax(maxSubArray(nums, left, mid),
                maxSubArray(nums, mid + 1, right),
                solutionArray(nums, left, mid, right));
    }

    private int solutionArray(int[] nums, int left, int mid, int right) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        // 从中间开始，向前进，看看最大为多少，可以断定一定是连续的
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }

        sum = 0;
        // 从中间开始想后走，看最大为多少
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }

    public int getMax(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }
}
