package leetcode.July_Leetcode.Tree;

/**
 * @author caoduanxi
 * @2019/7/27 21:42
 */
public class Test40 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    int min = Integer.MAX_VALUE;
    int relativeMin = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        helper(root);
        return min;

    }

    public void helper(TreeNode root){
        if(root == null) return;

        helper(root.left);
        if(relativeMin != Integer.MAX_VALUE){
            min = Math.min(min, root.val - relativeMin);
        }
        relativeMin = root.val;
        helper(root.right);

    }
}
