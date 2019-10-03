package leetcode.August_Leetcode;

import java.util.*;

/**
 * @author caoduanxi
 * @2019/8/19 20:33
 */
public class Test17 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    // �������
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.remove();
                list.add(temp.val);
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            // ������ұߵ�Ԫ�ؼ���
            res.add(list.get(list.size() - 1));
        }
        return res;
    }

    // �ݹ�ⷨ
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res, int depth) {
        if (root == null) return;
        if (depth == res.size()) {
            res.add(root.val);
        }
        // ��Ϊ������ͼ�������ȱ����ұߣ�ֻҪ������߶���Ⱦ����
        // ��Ϊ����ǡ����һ��ֻ����һ����
        helper(root.right, res, depth + 1);
        helper(root.left, res, depth + 1);
    }


}
