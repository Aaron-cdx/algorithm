package leetcode.July_Leetcode.Tree;

/**
 * @author caoduanxi
 * @2019/7/14 19:34
 */
public class Test22 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    // [] 0 判定为false
    public boolean hasPathSum(TreeNode root, int sum) {
        // 为null直接返回false
        if(root == null) return false;

        // 不为null，判断sum-当前节点是否为0且此节点的左右子节点是否都为null
        if(root != null){
            // 满足则true
            if(sum - root.val == 0 && root.left == null && root.right == null) {
                return true;
            }
        }
        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
    }
}
