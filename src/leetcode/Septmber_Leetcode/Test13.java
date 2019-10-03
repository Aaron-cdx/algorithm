package leetcode.Septmber_Leetcode;

/**
 * @author caoduanxi
 * @2019/9/15 16:51
 */
public class Test13 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    int res;

    public int distributeCoins(TreeNode root) {
        // ʵ�ʾ��Ǽ�����ֵΪ�ڵ�ֱ�ӵľ���
        if (root == null) return 0;
        res = 0;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        // �ж���ߵĴ�С
        int leftNum = dfs(root.left);
        // �ж��ұߵĴ�С
        int rightNum = dfs(root.right);
        // �������ҽڵ㣬ֱ�ӵľ�����Ǿ���ֵ���
        res += Math.abs(leftNum) + Math.abs(rightNum);
        // ��ȥ����ڵ����裬�������
        return leftNum + rightNum + root.val - 1;
    }
}
