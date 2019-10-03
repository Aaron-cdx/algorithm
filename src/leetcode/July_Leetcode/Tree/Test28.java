package leetcode.July_Leetcode.Tree;

/**
 * @author caoduanxi
 * @2019/7/21 14:31
 */
public class Test28 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        if(t == null) return sb.toString();
//        sb.append(t.val);
//        if(t.left != null){
//            sb.append("("+tree2str(t.left)+")");
//            sb.append(t.right == null ? "" : "("+tree2str(t.right)+")");
//        }else if(t.left == null && t.right != null){
//            sb.append("()");
//            sb.append("("+tree2str(t.right)+")");
//        }
        helper(t, sb);
        return sb.toString();
    }

    private void helper(TreeNode t, StringBuilder sb) {
        if(t == null) return;

        sb.append(t.val);

        if(t.left != null){
            sb.append("(");
            helper(t.left, sb);
            sb.append(")");
        }else{
            if(t.right != null){
                sb.append("()");
            }
        }
        if(t.right != null){
            sb.append("(");
            helper(t.right, sb);
            sb.append(")");
        }
    }
}
