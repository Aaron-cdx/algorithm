package leetcode.November_Leetcode;

/**
 * @author caoduanxi
 * @2019/11/26 19:31
 * <p>
 * 预测赢家
 * 输入: [1, 5, 2]
 * 输出: False
 * 解释: 一开始，玩家1可以从1和2中进行选择。
 * 如果他选择2（或者1），那么玩家2可以从1（或者2）和5中进行选择。如果玩家2选择了5，那么玩家1则只剩下1（或者2）可选。
 * 所以，玩家1的最终分数为 1 + 2 = 3，而玩家2为 5。
 * 因此，玩家1永远不会成为赢家，返回 False。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/predict-the-winner
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test1126 {
    public static boolean PredictTheWinner(int[] nums) {
        if (nums.length % 2 == 0) return true;
        return getWinner(nums, 0, nums.length - 1, 1) >= 0;
    }

    // 这里的思想主要是，我拿就是获得，对方拿就是我失去
    private static int getWinner(int[] nums, int start, int end, int turn) {
        if (start == end) return turn * nums[start];
        // 这里的-1表示，只要是我拿就是正的，只要是对方拿就是负的
        int a = turn * nums[start] + getWinner(nums, start + 1, end, -turn);
        int b = turn * nums[end] + getWinner(nums, start, end - 1, -turn);

        return turn * Math.max(turn * a, turn * b);
    }

    public static boolean PredictTheWinner1(int[] nums) {
//        if (nums.length % 2 == 0) return true;
        int dp[][] = new int[nums.length + 1][nums.length + 1];
        int n = nums.length;
        // 初始化
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        // 先看自己可以拿的，在dp[i][j]
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }

    // 动态规划
    public static boolean PredictTheWinner2(int[] nums) {
        int dp[][] = new int[nums.length + 1][nums.length + 1];
        // 从start开始，自己从头开始的话，则减去自己对手所拿
        // 从end开始，则从最后开始，减去对手所拿
        for (int start = nums.length; start >= 0; start--) {
            for (int end = start + 1; end < nums.length; end++) {
                int a = nums[start] - dp[start + 1][end];
                int b = nums[end] - dp[start][end - 1];
                dp[start][end] = Math.max(a, b);
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }

    // 空间优化 因为第i个只与第i+1个有关系
    public static boolean PredictTheWinner3(int[] nums) {
        int dp[] = new int[nums.length];
        for (int start = nums.length; start >= 0; start--) {
            for (int end = start + 1; end < nums.length; end++) {
                int a = nums[start] - dp[end];
                int b = nums[end] - dp[end - 1];
                dp[end] = Math.max(a, b);
            }
        }
        return dp[nums.length - 1] >= 0;
    }

    public static void main(String[] args) {
        System.out.println(PredictTheWinner1(new int[]{1, 5, 233, 7}));
    }
}
