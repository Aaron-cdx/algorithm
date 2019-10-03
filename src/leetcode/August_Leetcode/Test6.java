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
                cur = cur.left;// ����cur�Ż���null�����
            } else {
                cur = stack.pop();
                // �ҵ�һ������Ľڵ�
                // ��ǰ�ڵ�С����һ���ڵ�ʱ����һ���ڵ�ʱ����ڵ�
                if (wrongNode == null && pre != null && cur.val < pre.val) {
                    wrongNode = pre;
                }
                // Ѱ�ҵڶ����ڵ㣬������
                // ����ǰ�ڵ���ڴ���ڵ��ʱ�򣬵�ǰ�ڵ��ǰ�ڵ���Ǵ���ڵ�
                if (wrongNode != null && pre != null && cur.val >= pre.val) {
                    swap(wrongNode, pre);
                    break;
                }
                pre = cur;
                cur = cur.right;
            }
            // ����������û�ҵ�
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
