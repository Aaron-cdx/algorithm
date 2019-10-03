package leetcode.August_Leetcode;

import java.util.Stack;

/**
 * @author caoduanxi
 * @2019/8/3 21:19
 */
public class Test5 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        // 左子树小于当前节点，右子树大于当前节点，左子树和右子树本身也必须是二叉搜索树
        if (root == null) return false;
        return isSubBST(root, null, null);
    }

    // 判断左右子树是否是二叉搜索树
    public boolean isSubBST(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        // 给定一个最大值和一个最小值，如果最小值不为null，且当前值小于最小值，返回false
        int val = root.val;
        if ((lower != null && val <= lower)) {
            return false;
        }
        // 如果最大值不为null，且当前值大于最大值，返回false
        if (upper != null && val >= upper) {
            return false;
        }
        // 右子树，无上届，有下界
        if (!isSubBST(root.right, val, upper)) return false;
        // 左子树，无下界，有上界
        if (!isSubBST(root.left, lower, val)) return false;
        return true;
    }

    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (pre != null || pre.val >= p.val) return false;
            pre = p;
            p = p.right;
        }
        return true;
    }

    TreeNode p = null;

    public boolean isValidBST3(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST3(root.left)) return false;

        if(p != null && p.val >= root.val) return false;
        p = root;// p永远作为中间节点

        return isValidBST3(root.right);

    }
}
