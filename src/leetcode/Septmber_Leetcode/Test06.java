package leetcode.Septmber_Leetcode;

/**
 * @author caoduanxi
 * @2019/9/5 21:52
 */
public class Test06 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return null;
        if(hasZero(root)){
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);
        }else{
            return null;
        }
        return root;
    }

    public boolean hasZero(TreeNode root){
        if(root == null) return false;
        if(root.val == 1){
            return true;
        }
        return hasZero(root.left) || hasZero(root.right);
    }
}
