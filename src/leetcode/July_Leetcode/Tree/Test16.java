package leetcode.July_Leetcode.Tree;

/**
 * @author caoduanxi
 * @2019/7/13 14:15
 */
public class Test16 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    // 拆分成两颗树，只要两棵树递归的时候左等于右即可
    public boolean isSymmetric(TreeNode root) {
        // 判断是不是镜像对称的树
        if(root != null){
            return isMirror(root.left,root.right);
        }
        return true;
    }
    // 判断是否是镜像
    public boolean isMirror(TreeNode a, TreeNode b){
         if(a==null && b==null) return true;

         if(a == null || b == null) return false;

         return (a.val == b.val) && isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }
}
