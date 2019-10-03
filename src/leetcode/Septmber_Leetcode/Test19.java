package leetcode.Septmber_Leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author caoduanxi
 * @2019/9/18 21:03
 */
public class Test19 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }


    int max = 0;

    public int maxAncestorDiff(TreeNode root) {
        // ά������ֵ��һ����С��һ�����
        if (root == null) return max;
        helper(root, root.val, root.val);
        return max;
    }

    // �ݹ���ʵľ�����һ����ֹ����������������
    private void helper(TreeNode root, int lower, int upper) {
        if (root == null) return;
        // ��ǰ��С
        int l = Math.min(root.val, lower);
        // ��ǰ���
        int h = Math.max(root.val, upper);
        // ����Ҷ�ӽڵ����max
        if (root.left == null && root.right == null) {
            max = Math.max(max, Math.abs(l - h));
        }
        helper(root.left, l, h);
        helper(root.right, l, h);

    }


    public int maxAncestorDiff1(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    max = Math.max(max, max + Math.abs(temp.val - temp.left.val));
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    max = Math.max(max, max + Math.abs(temp.val - temp.right.val));
                    queue.add(temp.right);
                }
            }
        }
        return max;
    }

}
