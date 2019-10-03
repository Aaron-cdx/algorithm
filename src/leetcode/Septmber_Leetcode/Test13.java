package leetcode.Septmber_Leetcode;

/**
 * @author caoduanxi
 * @2019/9/15 16:51
 */
public class Test13 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    int res;

    public int distributeCoins(TreeNode root) {
        // 实质就是计算与值为节点直接的距离
        if (root == null) return 0;
        res = 0;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        // 判断左边的大小
        int leftNum = dfs(root.left);
        // 判断右边的大小
        int rightNum = dfs(root.right);
        // 无论左右节点，直接的距离就是绝对值相加
        res += Math.abs(leftNum) + Math.abs(rightNum);
        // 出去自身节点所需，多出来的
        return leftNum + rightNum + root.val - 1;
    }
}
