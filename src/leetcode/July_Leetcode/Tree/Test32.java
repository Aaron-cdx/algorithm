package leetcode.July_Leetcode.Tree;

/**
 * @author caoduanxi
 * @2019/7/22 21:01
 */
public class Test32 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    public int findSecondMinimumValue(TreeNode root) {
        int smin = -1;
        if(root == null) return smin;
        int min = root.val;

        smin = helper(root,min,smin);
        return smin;
    }

    public int helper(TreeNode root, int min, int smin){
        if(root == null) return smin;
        // 只有第一次才给第二大的值赋值
        if(root.val > min && smin == -1){
            smin = root.val;
        }
        // 其余的只有满足这种条件，否则不交换
        if(root.val < min && root.val < smin){
            smin = min;
            min = root.val;
        }
        smin = helper(root.left, min, smin);
        smin = helper(root.right, min, smin);

        return smin;
    }
}
