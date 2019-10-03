package leetcode.August_Leetcode;

/**
 * @author caoduanxi
 * @2019/8/20 19:47
 */
public class Test18 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
    // ��������������߶���ȣ����������(ǰ����ϸ��ڵ�)��ͳ���ұ߼���
    // �߶Ȳ���ȣ����ұ���������ͳ����ڵ�
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = getLevel(root.left);
        int right = getLevel(root.right);

        if (left == right) {
            return countNodes(root.right) + (1 << left);
        }else{
            return countNodes(root.left) + (1 << right);
        }
    }

    public int getLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            level += 1;
            root = root.left;
        }
        return level;
    }

    // ���ҵݹ�
    int sum = 1;

    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null) {
            sum += 1;
        }
        if (root.right != null) {
            sum += 1;
        }
        countNodes2(root.left);
        countNodes2(root.right);
        return sum;
    }

    // ֱ������+1���ڵ����
    public int countNodes4(TreeNode root) {
        if (root == null) return 0;
        return countNodes4(root.left) + countNodes4(root.right) + 1;
    }
}
