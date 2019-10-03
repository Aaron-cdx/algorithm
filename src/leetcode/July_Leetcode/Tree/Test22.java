package leetcode.July_Leetcode.Tree;

/**
 * @author caoduanxi
 * @2019/7/14 19:34
 */
public class Test22 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    // [] 0 �ж�Ϊfalse
    public boolean hasPathSum(TreeNode root, int sum) {
        // Ϊnullֱ�ӷ���false
        if(root == null) return false;

        // ��Ϊnull���ж�sum-��ǰ�ڵ��Ƿ�Ϊ0�Ҵ˽ڵ�������ӽڵ��Ƿ�Ϊnull
        if(root != null){
            // ������true
            if(sum - root.val == 0 && root.left == null && root.right == null) {
                return true;
            }
        }
        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
    }
}
