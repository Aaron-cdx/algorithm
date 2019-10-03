package leetcode.August_Leetcode;

/**
 * @author caoduanxi
 * @2019/8/26 20:00
 */
public class Test27 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        // �жϸ��ڵ��Ƿ�Ϊkey
        if (root.val == key) {
            // ���������Ϊnull��ֱ�ӷ���������
            if (root.right == null) {
                return root.left;
            } else {
                // ��������Ϊnull�����ȡ��������С�Ľڵ����������ڵ�
                TreeNode node = root.right;
                // ���ڵ�
                TreeNode parent = root;
                // ��Ҫ�ƶ�Ѱ����������С�Ľڵ�
                while (node != null && node.left != null) {
                    // ���ڵ�����ƶ���Ŀ�ľ���Ϊ�˺����ɾ����
                    parent = node;
                    node = node.left;
                }
                // ��ʱnode�Ѿ�����С�Ľڵ��ˣ���ʱ��Ҫ����ֵ�Ľ���
                // ���������ڵ�Ϊ��С�ģ���ô���ڵ���ҽڵ��Ϊnull��ʱnode.right=null
                if (parent.left == node) parent.left = node.right;
                if (parent.right == node) parent.right = node.right;
                // ���ɾ���ڵ�
                node.left = root.left;
                node.right = root.right;
                return node;
            }
        } else if (root.val > key) {
            // ���
            root.left = deleteNode(root.left, key);
        } else {
            // �ұ�
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}
