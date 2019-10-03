package leetcode.August_Leetcode;

import java.util.Stack;

/**
 * @author caoduanxi
 * @2019/8/4 21:21
 */
public class Test6 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = root;
        TreeNode wrongNode = null;

        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;// 这样cur才会有null的情况
            } else {
                cur = stack.pop();
                // 找第一个错误的节点
                // 当前节点小于上一个节点时，上一个节点时错误节点
                if (wrongNode == null && pre != null && cur.val < pre.val) {
                    wrongNode = pre;
                }
                // 寻找第二个节点，做交换
                // 当当前节点大于错误节点的时候，当前节点的前节点就是错误节点
                if (wrongNode != null && pre != null && cur.val >= pre.val) {
                    swap(wrongNode, pre);
                    break;
                }
                pre = cur;
                cur = cur.right;
            }
            // 如果到最后还是没找到
            if (wrongNode != null && pre != null && cur.val >= pre.val) {
                swap(wrongNode, pre);
            }
        }
    }

    private void swap(TreeNode wrongNode, TreeNode pre) {
        int temp = wrongNode.val;
        wrongNode.val = pre.val;
        pre.val = temp;
    }
}
