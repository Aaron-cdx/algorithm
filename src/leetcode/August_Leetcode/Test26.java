package leetcode.August_Leetcode;

/**
 * @author caoduanxi
 * @2019/8/25 20:09
 */
public class Test26 {
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
        // key小，走左边
        if(root.val > key){
            root.left = deleteNode(root.left,key);
            return root;
        }
        // key大，走右边
        if(root.val < key){
            root.right = deleteNode(root.right,key);
            return root;
        }
        assert root.val == key;
        // 如果左边为null，则直接将右边怼过来即可
        if(root.left == null){
            TreeNode right = root.right;
            root.right = null;
            return right;
        }
        // 如果右边为null，则直接将左边怼过来
        if(root.right == null){
            TreeNode left = root.left;
            root.left = null;
            return left;
        }
        // 如果左右都不为null，此时就需要进行前驱节点的查找并替换
        // 查找左边最大的节点
        TreeNode predecessorNode = maxNode(root.left);
        // 复制一份作为新的节点
        TreeNode predecessorNodeCopy = new TreeNode(predecessorNode.val);
        // 将最大的节点从树中删除
        predecessorNodeCopy.left = removeMaxNode(root.left);
        // 右节点直接拿root的右节点即可
        predecessorNodeCopy.right = root.right;
        // 删除key节点
        root.left = null;
        root.right = null;
        return predecessorNodeCopy;
    }
    // 删除的方法
    private TreeNode removeMaxNode(TreeNode node) {
        // 这是新节点的左边，也是此节点的左边
        if(node.right == null){
            TreeNode left = node.left;
            node.left = null;
            return left;
        }
        node.right = removeMaxNode(node.right);
        return node;
    }

    private TreeNode maxNode(TreeNode node) {
        if(node.right == null){
            return node;
        }
        return maxNode(node.right);
    }



}
