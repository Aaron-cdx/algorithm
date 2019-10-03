package leetcode.July_Leetcode.Tree;

/**
 * @author caoduanxi
 * @2019/7/13 14:15
 */
public class Test16 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    // ��ֳ���������ֻҪ�������ݹ��ʱ��������Ҽ���
    public boolean isSymmetric(TreeNode root) {
        // �ж��ǲ��Ǿ���ԳƵ���
        if(root != null){
            return isMirror(root.left,root.right);
        }
        return true;
    }
    // �ж��Ƿ��Ǿ���
    public boolean isMirror(TreeNode a, TreeNode b){
         if(a==null && b==null) return true;

         if(a == null || b == null) return false;

         return (a.val == b.val) && isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }
}
