package leetcode.Septmber_Leetcode;

/**
 * @author caoduanxi
 * @2019/9/5 21:34
 */
public class Test05 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        helper(root,val);
        return root;
    }

    public void helper(TreeNode root, int val) {
        if (root == null) return;
        // ���valֵ����ߣ��ж�����Ƿ�Ϊnull
        // Ϊnull�Ļ�ֱ��ƴ�ӽڵ㣬�����������
        if (root.val > val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
                return;
            } else {
                helper(root.left, val);
            }
            // �ұ�Ҳ�����
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return;
            } else {
                helper(root.right, val);
            }
        }
    }

}
