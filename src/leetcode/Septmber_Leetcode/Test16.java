package leetcode.Septmber_Leetcode;

/**
 * @author caoduanxi
 * @2019/9/17 19:39
 */
public class Test16 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        // ��valΪ�ڵ�
        if(root == null) return new TreeNode(val);
        // С�ڵĻ���ֱ����Ͻڵ㣬������ڵ㼴��
        if(root.val < val){
            TreeNode res = new TreeNode(val);
            res.left = root;
            return res;
        }else{
            // �������������ֱ�����Լ����ұ���
            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }
    }
}
