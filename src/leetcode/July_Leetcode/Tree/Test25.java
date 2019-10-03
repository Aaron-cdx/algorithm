package leetcode.July_Leetcode.Tree;

/**
 * @author caoduanxi
 * @2019/7/19 21:04
 */
public class Test25 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        maxNum(root);
        return res;
    }

    public int maxNum(TreeNode root){
        if(root == null){
            return 0;
        }

        int l = maxNum(root.left);
        int r = maxNum(root.right);
        // �жϵ���ÿһ���ڵ���������ֱ����ȡ����
        res = Math.max(res,l+r);

        return Math.max(l, r)+1;
    }
}
