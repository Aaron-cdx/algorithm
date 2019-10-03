package leetcode.Septmber_Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caoduanxi
 * @2019/9/1 19:17
 */
public class Test01 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public List<List<String>> printTree(TreeNode root) {
        if (root == null) return null;
        int height = findHeight(root);
        // (1 << height) - 1 ��ÿһ��list�л�ȡ����Ԫ�ظ���
        int width = (1 << height) - 1;
        List<List<String>> res = new ArrayList<>(height);
        for (int i = 0; i < height; i++) {
            // ��ȡ�ڲ�list����
            List<String> list = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                list.add("");
            }
            // ��ӵ��ܵ�res��
            res.add(list);
        }
        helper(root, 1, 0, width, res);
        return res;
    }

    private void helper(TreeNode root, int depth, int start, int end, List<List<String>> res) {
        if (root == null || start > end) return;
        // �ҵ��յ�
        int mid = start + (end - start)/2;
        for (int i = start; i <= end; i++) {
            if (i == mid) {
                // ���
                res.get(depth - 1).set(i, root.val + "");
                break;
            }
        }
        // ���������
        helper(root.left, depth + 1, start, mid - 1, res);
        // ���������
        helper(root.right, depth + 1, mid + 1, end, res);
    }

    public int findHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
