package leetcode.July_Leetcode.Tree;

/**
 * @author caoduanxi
 * @2019/7/13 21:16
 */
public class Test19 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    public boolean isBalanced(TreeNode root) {
        // ��߶ȣ�ֻҪ�߶�֮�����1ֱ��false;
        // ��ֻ�����ж����壬��Ҫ��������Ϊһ������
        if(Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1){
            return false;
        }
        // �����õݹ��ж����ҽڵ㣬ÿһ�����ҽڵ㶼Ҫ����������ж�
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {
        // ������
        if(root == null){
            return 0;
        }else{
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return Math.max(left_height, right_height)+1;
        }
    }
}
