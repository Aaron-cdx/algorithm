package leetcode.Septmber_Leetcode;

/**
 * @author caoduanxi
 * @2019/9/17 20:51
 */
public class Test18 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    int idx = 0;
    int[] preorder;
    int n;

    public TreeNode bstFromPreorder(int[] preorder) {
        this.preorder = preorder;
        n = preorder.length;
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    public TreeNode helper(int lower, int upper) {
        if (idx == n) return null;
        int val = preorder[idx];
        if (val < lower || val > upper) return null;
        idx++;
        TreeNode root = new TreeNode(val);
        root.left = helper(lower, val);
        root.right = helper(val, upper);
        return root;
    }
}
