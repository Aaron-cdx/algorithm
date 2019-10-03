package leetcode.July_Leetcode.Tree;

/**
 * @author caoduanxi
 * @2019/7/13 21:16
 */
public class Test19 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    public boolean isBalanced(TreeNode root) {
        // 算高度，只要高度之差大于1直接false;
        // 这只是配判断整体，它要将左右作为一个整体
        if(Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1){
            return false;
        }
        // 这里用递归判断左右节点，每一个左右节点都要单独拎出来判断
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {
        // 最大深度
        if(root == null){
            return 0;
        }else{
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return Math.max(left_height, right_height)+1;
        }
    }
}
