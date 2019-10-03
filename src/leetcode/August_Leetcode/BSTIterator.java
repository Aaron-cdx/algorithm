package leetcode.August_Leetcode;

import java.util.Stack;

/**
 * @author caoduanxi
 * @2019/8/19 19:55
 */
public class BSTIterator {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        if (root == null) return;
        stack.push(root);
        // 寻找到最左的节点
        while (root.left != null) {
            stack.push(root.left);
            root = root.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        // 弹出最左的节点
        TreeNode temp = stack.pop();
        if (temp.right != null) {
            stack.push(temp.right);
            TreeNode node = temp.right;
            while (node.left != null) {
                stack.push(node.left);
                node = node.left;
            }
        }
        return temp.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        // 根据栈中是否有元素判断是否有下一个
        return !stack.isEmpty();
    }
}
