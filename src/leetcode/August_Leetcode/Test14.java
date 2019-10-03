package leetcode.August_Leetcode;

/**
 * @author caoduanxi
 * @2019/8/16 21:38
 */
public class Test14 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    int Max_num = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMaxNum(root);
        return Max_num;
    }

    public int getMaxNum(TreeNode root) {
        if (root == null) return 0;
        int left_num = Math.max(getMaxNum(root.left), 0);
        int right_num = Math.max(getMaxNum(root.right), 0);
        // 新节点
        int pre_num = root.val + left_num + right_num;
        // 得出最大的值
        Max_num = Math.max(pre_num, Max_num);
        // 因为路径不能交叉，只能获取左右最大节点+父节点的值传回
        return Math.max(left_num, right_num) + root.val;
    }
}
