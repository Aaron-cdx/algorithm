package leetcode.July_Leetcode.Tree;

/**
 * @author caoduanxi
 * @2019/7/21 15:18
 */
public class Test29 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;

        if(t2 == null) return t1;

        // 如果两者都不为null,构造一个新的节点
        TreeNode res = new TreeNode(t1.val + t2.val);
        // 只需要返回新的节点就行
        res.left = mergeTrees(t1.left, t2.left);
        res.right = mergeTrees(t1.right, t2.right);

        return res;
    }

}
