package leetcode.July_Leetcode.Tree;

/**
 * @author caoduanxi
 * @2019/7/28 22:10
 */
public class Test42 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    int min = Integer.MAX_VALUE;
    int res = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        helper(root);
        return min;
    }

    public void helper(TreeNode root) {
        if (root == null) return;

        helper(root.left);

        if(res != Integer.MAX_VALUE){
            min = Math.min(min, root.val - res);
        }
        res = root.val;

        helper(root.right);
    }
}
