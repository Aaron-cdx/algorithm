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
        // keyС�������
        if(root.val > key){
            root.left = deleteNode(root.left,key);
            return root;
        }
        // key�����ұ�
        if(root.val < key){
            root.right = deleteNode(root.right,key);
            return root;
        }
        assert root.val == key;
        // ������Ϊnull����ֱ�ӽ��ұ���������
        if(root.left == null){
            TreeNode right = root.right;
            root.right = null;
            return right;
        }
        // ����ұ�Ϊnull����ֱ�ӽ��������
        if(root.right == null){
            TreeNode left = root.left;
            root.left = null;
            return left;
        }
        // ������Ҷ���Ϊnull����ʱ����Ҫ����ǰ���ڵ�Ĳ��Ҳ��滻
        // ����������Ľڵ�
        TreeNode predecessorNode = maxNode(root.left);
        // ����һ����Ϊ�µĽڵ�
        TreeNode predecessorNodeCopy = new TreeNode(predecessorNode.val);
        // �����Ľڵ������ɾ��
        predecessorNodeCopy.left = removeMaxNode(root.left);
        // �ҽڵ�ֱ����root���ҽڵ㼴��
        predecessorNodeCopy.right = root.right;
        // ɾ��key�ڵ�
        root.left = null;
        root.right = null;
        return predecessorNodeCopy;
    }
    // ɾ���ķ���
    private TreeNode removeMaxNode(TreeNode node) {
        // �����½ڵ����ߣ�Ҳ�Ǵ˽ڵ�����
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
