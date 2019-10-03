package leetcode.August_Leetcode;

/**
 * @author caoduanxi
 * @2019/8/7 22:02
 */
public class Test10 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return rebuild(inorder, 0, inorder.length, postorder, postorder.length - 1);
    }

    public TreeNode rebuild(int[] inorder, int i, int j, int[] postorder, int p) {
        if (i == j) return null;
        TreeNode root = new TreeNode(postorder[p]);
        int k = 0;
        while (inorder[k] != root.val) k++;
        // 先构造右子树
        root.right = rebuild(inorder, k + 1, j, postorder, p - 1);
        // 再构造左子树
        root.left = rebuild(inorder, i, k, postorder, p-1-(j-k-1));
        return root;
    }
}
