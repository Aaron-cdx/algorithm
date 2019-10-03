package leetcode.August_Leetcode;

/**
 * @author caoduanxi
 * @2019/8/18 18:43
 */
public class Test15 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    // �ַ���ƴ��
    int sum = 0;

    public int sumNumbers1(TreeNode root) {
        helper(root, new StringBuilder());
        return sum;
    }

    public void helper(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val);
        // �ж��Ƿ���Ҷ�ӽڵ㣬��Ҷ�ӽڵ�ͼ��뵽sum��
        if (root.left == null && root.right == null) {
            sum += Integer.parseInt(sb.toString());
        }
        helper(root.left, sb);
        helper(root.right, sb);
        // ���˵Ĳ���û��--��Ϊsb��ȫ�ֱ����������˵Ļ���û�����������
        sb.delete(sb.length() - 1, sb.length());
    }

    // ֱ����ֵ����
    int res = 0;

    public int sumNumbers(TreeNode root) {
        newHelper(root, 0);
        return res;
    }

    public void newHelper(TreeNode root, int temp) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sum += temp * 10 + root.val;
        }
        newHelper(root.left, temp * 10 + root.val);
        newHelper(root.right, temp * 10 + root.val);
    }
}
