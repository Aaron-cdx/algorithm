package leetcode.Septmber_Leetcode;

/**
 * @author caoduanxi
 * @2019/9/17 20:16
 */
public class Test17 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for (int i = 0; i < preorder.length; i++) {
            root = helper(preorder[i],root);
        }
        return root;
    }

    private TreeNode helper(int num,TreeNode root) {
        if(root == null) return new TreeNode(num);
        if(root.val > num){
            root.left = helper(num,root.left);
        }else{
            root.right = helper(num,root.right);
        }
        return root;
    }

    /*public int getBigIndex(int[] nums, int begin, int num) {
        int ans = -1;
        for (int i = begin + 1; i < nums.length; i++) {
            if (nums[i] > num) {
                ans = i;
                return ans;
            }
        }
        return ans;
    }*/
}
