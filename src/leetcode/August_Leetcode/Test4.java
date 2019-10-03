package leetcode.August_Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caoduanxi
 * @2019/8/3 20:49
 */
public class Test4 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n == 0) return res;
        return getList(1, n);
    }

    public List<TreeNode> getList(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        // ����ʼ�Ľڵ�С�ڼ����ĵ��ʱ��
        if (start > end) {
            res.add(null);
            return res;
        }
        if (start == end) {
            TreeNode node = new TreeNode(start);
            res.add(node);
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> nodeLeft = getList(start, i - 1);
            List<TreeNode> nodeRight = getList(i + 1, end);
            // ��ߵ�������ұߵ��������
            for (TreeNode left : nodeLeft) {
                for (TreeNode right : nodeRight) {
                    // ������
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
