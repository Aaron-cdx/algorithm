package leetcode.July_Leetcode.Tree;

/**
 * @author caoduanxi
 * @2019/7/13 21:58
 */
public class Test20 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    // 设置的全局标志
    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        depth(root);
        return res;
    }

    public int depth(TreeNode root){
        if(root == null) return 0;
        int left = depth(root.left) + 1;
        int right = depth(root.right) + 1;
        if(Math.abs(left - right) > 1) res = false;
        return Math.max(left, right);
    }
}
