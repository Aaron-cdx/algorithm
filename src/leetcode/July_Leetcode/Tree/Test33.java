package leetcode.July_Leetcode.Tree;

/**
 * @author caoduanxi
 * @2019/7/23 21:15
 */
public class Test33 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    int res = 0;
    public int longestUnivaluePath2(TreeNode root) {
        helper(root);
        return res;
    }

    public int helper(TreeNode root){
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);
        // 从根节点一直遍历到最左最右，然后进行处理，直接返回两边相加与res的对比
        // 往上走，因为路径不能左边加右边加，所以返回左右最大的
        int l = 0; int r = 0;
        if(root.left != null && root.val == root.left.val){
            l += left + 1;
        }
        if(root.right != null && root.val == root.right.val){
            r += right + 1;
        }
        res = Math.max(res, l+r);

        return Math.max(l,r);
    }

    public int longestUnivaluePath3(TreeNode root) {
        int maxNum = 0;
        int num_left = 0;
        int num_right = 0;
        if(root == null) return 0;

        if(root.left != null){
            if(root.val == root.left.val){
                num_left += 1;
            }
            num_left += longestUnivaluePath(root.left);
        }
        if(root.right != null){
            if(root.val == root.right.val){
                num_right += 1;
            }
            num_right += longestUnivaluePath(root.right);
        }
        maxNum = Math.max(num_left,num_right);
        return maxNum;
    }







    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        arrowLength(root);
        return ans;

    }
    public int arrowLength(TreeNode root){
        if(root == null) return 0;

        int left = arrowLength(root.left);
        int right = arrowLength(root.right);
        int arrowLeft = 0;
        int arrowRight = 0;
        if(root.left != null && root.left.val == root.val){
            arrowLeft += left + 1;
        }
        if(root.right != null && root.right.val == root.val){
            arrowRight += right + 1;
        }
        ans = Math.max(ans, (left+right));

        return Math.max(arrowLeft,arrowRight);
    }

}
