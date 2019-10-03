package leetcode.July_Leetcode.Tree;

/**
 * @author caoduanxi
 * @2019/7/13 15:09
 */
public class Test17 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return rebuildTree(nums, 0, nums.length - 1);
    }

    public TreeNode rebuildTree(int[] nums, int l, int r){
        if(l > r) return null;// 防止长度为0出现
        int m = (l+r)>>1;
        TreeNode root = new TreeNode(nums[m]);
        root.left = rebuildTree(nums,l,m-1);
        root.right = rebuildTree(nums, m+1, r);
        return root;
    }

    public TreeNode sortedArrayToBST1(int[] nums) {
        if(nums.length == 0) return null;
        // 构造平衡搜索二叉树
        int m = nums.length/2;

        // 左边
        TreeNode root = new TreeNode(nums[m]);
        TreeNode cur = root;
        for (int i = m-1; i >= 0; i--) {
            cur.left = new TreeNode(nums[i]);
            cur = cur.left;
        }

        // 右边
        TreeNode temp = root;
        if(nums.length - 1 > m){
            temp.right = new TreeNode(nums[nums.length - 1]);
            temp = temp.right;
            for (int i = nums.length - 2; i > m; i-- ){
                temp.left = new TreeNode(nums[i]);
                temp = temp.left;
            }
        }

        return root;
    }
}
