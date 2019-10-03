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
        // 判断根节点是否为key
        if (root.val == key) {
            // 如果右子树为null，直接返回左子树
            if (root.right == null) {
                return root.left;
            } else {
                // 右子树不为null，则获取右子树最小的节点来当做根节点
                TreeNode node = root.right;
                // 父节点
                TreeNode parent = root;
                // 需要移动寻找右子树最小的节点
                while (node != null && node.left != null) {
                    // 父节点跟随移动（目的就是为了后面的删除）
                    parent = node;
                    node = node.left;
                }
                // 此时node已经是最小的节点了，此时需要进行值的交换
                // 如果父的左节点为最小的，那么父节点的右节点就为null此时node.right=null
                if (parent.left == node) parent.left = node.right;
                if (parent.right == node) parent.right = node.right;
                // 最后删除节点
                node.left = root.left;
                node.right = root.right;
                return node;
            }
        } else if (root.val > key) {
            // 左边
            root.left = deleteNode(root.left, key);
        } else {
            // 右边
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}
