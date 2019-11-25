package leetcode.October_Leetcode;

/**
 * @author caoduanxi
 * @2019/10/29 19:52
 */
public class Test1029 {
    // 暴力法
    public int wiggleMaxLength1(int[] nums) {
        if (nums.length < 2) return nums.length;
        // 回溯法
        return 1 + Math.max(calculateLen(0, nums, true), calculateLen(0, nums, false));
    }

    private int calculateLen(int low, int[] nums, boolean isUp) {
        int maxCount = 0;
        for (int i = low + 1; i < nums.length; i++) {
            // 每一次都判断，然后再次回溯，深度n
            if ((nums[i] - nums[low] > 0 && isUp) || (nums[i] - nums[low] < 0 && !isUp)) {
                maxCount = Math.max(maxCount, 1 + calculateLen(i, nums, !isUp));
            }
        }
        return maxCount;
    }


    public int wiggleMaxLength3(int[] nums) {
        if (nums.length < 2) return nums.length;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    up[i] = Math.max(up[i], down[j] + 1);
                } else if (nums[i] < nums[j]) {
                    down[i] = Math.max(up[j] + 1, down[i]);
                }
            }
        }
        return 1 + Math.max(up[nums.length - 1], down[nums.length - 1]);
    }
    // 最直观的一种方法，只有上升下降，上升就是下降+1，下降就是上升+1
    public int wiggleMaxLength4(int[] nums) {
        if (nums.length == 0) return 0;
        int up = 1;
        int down = 1;
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i] - nums[i - 1];
            if (temp > 0) up = down + 1;
            if (temp < 0) down = up + 1;
        }
        return Math.max(up, down);
    }
    // 最容易懂的方式
    // 定义一个上升下降
    // 遇着上升就用下降的+1,下降的继续保持不变
    // 遇着下降的就用上升的+1,上升的继续保持不变
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) return 0;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        up[0] = down[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }
        return Math.max(up[nums.length - 1], down[nums.length - 1]);
    }
}
