package leetcode.August_Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author caoduanxi
 * @2019/8/27 19:54
 */
public class Test30 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    // �������
    public List<Integer> largestValues1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // ��¼��һ���е����ֵ
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                max = Math.max(node.val, max);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(max);
        }
        return res;
    }

    // �ݹ飺�����������
    List<Integer> list = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        helper(root, 0);
        return list;
    }

    private void helper(TreeNode root, int depth) {
        if (root == null) return;
        // �Ȱ�ͷ���ֵ����
        if (depth + 1 > list.size()) {
            list.add(depth, root.val);
        }
        // �ж�ͬһ�е������
        if (root.val > list.get(depth)) {
            list.set(depth, root.val);
        }
        helper(root.left, depth + 1);
        helper(root.right, depth + 1);
    }
}
