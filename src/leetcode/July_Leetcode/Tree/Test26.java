package leetcode.July_Leetcode.Tree;

/**
 * @author caoduanxi
 * @2019/7/19 21:14
 */
public class Test26 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    int tiltSum = 0;
    public int findTilt(TreeNode root) {
        if(root == null) return 0;
        tilt(root);
        return tiltSum;
    }

    public int tilt(TreeNode root){
        if(root == null) return 0;

        int l = tilt(root.left);
        int r = tilt(root.right);

        tiltSum += Math.abs(l-r);

        return l+r+root.val;
    }
}
