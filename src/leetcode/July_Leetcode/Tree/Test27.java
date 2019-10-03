package leetcode.July_Leetcode.Tree;

/**
 * @author caoduanxi
 * @2019/7/20 21:31
 */
public class Test27 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;


        if(s.val == t.val){
            return isEqual(s,t) || isSubtree(s.left,t) || isSubtree(s.right, t);
        }

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    // ÅÐ¶ÏÊÇ·ñÈ«µÈ
    public boolean isEqual(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;

        if(s.val == t.val){
            return isEqual(s.left, t.left) && isEqual(s.right, t.right);
        }
        return false;
    }
}
