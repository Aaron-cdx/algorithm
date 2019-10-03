package leetcode.July_Leetcode.Tree;

/**
 * @author caoduanxi
 * @2019/7/27 21:27
 */
public class Test39 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;

        if(root.val == val) return root;

        TreeNode left = searchBST(root.left, val);
        TreeNode right = searchBST(root.right,val);

        if(left==null && right == null){
            return null;
        }
        return left == null ? right : left;
        /*
        // 因为是二叉搜索树，所以还可以继续优化
        if(root.val > val){
            TreeNode left = searchBST(root.left, val);
            return left;
        }else{
            TreeNode right = searchBST(root.right,val);
            return right;
        }
         */
    }
}
