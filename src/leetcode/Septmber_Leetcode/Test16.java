package leetcode.Septmber_Leetcode;

/**
 * @author caoduanxi
 * @2019/9/17 19:39
 */
public class Test16 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        // 以val为节点
        if(root == null) return new TreeNode(val);
        // 小于的话，直接怼上节点，放在左节点即可
        if(root.val < val){
            TreeNode res = new TreeNode(val);
            res.left = root;
            return res;
        }else{
            // 如果大于它，就直接往自己的右边走
            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }
    }
}
