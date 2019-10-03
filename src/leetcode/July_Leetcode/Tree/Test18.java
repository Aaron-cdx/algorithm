package leetcode.July_Leetcode.Tree;

/**
 * @author caoduanxi
 * @2019/7/13 20:53
 */
public class Test18 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    public int maxDepth1(TreeNode root) {
        if(root == null){
            return 0;
        }else{
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return Math.max(left_height,right_height)+1;
        }
    }

    public int maxDepth(TreeNode root) {
        int num = 0;
        if(root == null){
            return num;
        }else{
            num += 1;
        }
        int num1 = 0;
        int num2 = 0;
        // 左边高度
        if(root.left != null){
            num1 += maxDepth(root.left);
        }
        // 右边高度
        if(root.right != null){
            num2 += maxDepth(root.right);
        }
        return num+Math.max(num1,num2);
    }

//    public int maxDepth(TreeNode a, TreeNode b){
//        int num1 = 0;
//        int num2 = 0;
//        if(a != null){
//
//        }
//    }
}
