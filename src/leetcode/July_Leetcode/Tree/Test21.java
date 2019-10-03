package leetcode.July_Leetcode.Tree;

/**
 * @author caoduanxi
 * @2019/7/14 18:33
 */
public class Test21 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    // 求二叉树的最小深度
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        if(root.left == null && root.right == null) return 1;

        int min_depth = Integer.MAX_VALUE;
        if(root.left != null){
            min_depth = Math.min(min_depth,minDepth(root.left));
        }
        if(root.right != null){
            min_depth = Math.min(min_depth,minDepth(root.right));
        }

        return min_depth + 1;
    }
    // 最短路径
    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }else{
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            return Math.min(left,right)+1;
        }
    }
}
