package leetcode.August_Leetcode;

/**
 * @author caoduanxi
 * @2019/8/23 19:51
 */
public class Test23 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    // Ŀ�ľ����ҵ���ֱ�����������н��֮��
    int maxSum = 0;

    public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] res = doRob(root);
        return Math.max(res[0], res[1]);
    }

    public int[] doRob(TreeNode root) {
        int[] res = new int[2];
        if (root == null) return res;
        int[] left = doRob(root.left);
        int[] right = doRob(root.right);

        // ���������ڵ�ģ��͵�һ�����ӽڵ��ֵ
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // �������ڵ�ģ��Ͳ��������ڵ�Ķ����ӽڵ��ֵ
        res[1] = left[0] + right[0] + root.val;

        return res;
    }
}
