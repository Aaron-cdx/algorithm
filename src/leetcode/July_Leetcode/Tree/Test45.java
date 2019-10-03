package leetcode.July_Leetcode.Tree;

/**
 * @author caoduanxi
 * @2019/7/30 21:19
 */
public class Test45 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        int num = root.val;
        return helper(root,num);
    }

    public boolean helper(TreeNode root, int num){
        if(root == null) return true;

        if(root.val != num){
            return false;
        }
        return helper(root.left,num) && helper(root.right,num);
    }
}
