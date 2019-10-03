package leetcode.August_Leetcode;

/**
 * @author caoduanxi
 * @2019/8/21 19:48
 */
public class Test20 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root, p, q);
        return res;
    }

    public boolean recurseTree(TreeNode curNode, TreeNode p, TreeNode q) {
        if (curNode == null) return false;

        int left = this.recurseTree(curNode.left, p, q) ? 1 : 0;
        int right = this.recurseTree(curNode.right, p, q) ? 1 : 0;
        int mid = (curNode == p || curNode == q) ? 1 : 0;
        if (mid + left + right > 2) {
            res = curNode;
        }
        return (mid + left + right) > 0;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (isExist(root.left, p) && isExist(root.left, q)) {
            return lowestCommonAncestor1(root.left, p, q);
        } else if (isExist(root.right, p) && isExist(root.right, q)) {
            return lowestCommonAncestor1(root.right, p, q);
        } else {
            return root;
        }
    }

    public boolean isExist(TreeNode node, TreeNode cur) {
        if (node == null) return false;
        if (node.val == cur.val) {
            return true;
        }
        return isExist(node.left, cur) || isExist(node.right, cur);
    }

}
