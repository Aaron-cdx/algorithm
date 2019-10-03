package leetcode.July_Leetcode.Tree;

import java.util.Stack;

/**
 * @author caoduanxi
 * @2019/7/29 21:13
 */
public class Test44 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
    int ans = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) return ans;
        sumBST(root,L,R);
        return ans;
    }

    public void sumBST(TreeNode root, int L, int R){
        if(root == null) return;

        if(root.val >= L && root.val <= R){
            ans += root.val;
        }
        if(root.val > L){
            sumBST(root.left,L,R);
        }
        if(root.val < R){
            sumBST(root.right,L,R);
        }
    }

    public int rangeSumBST2(TreeNode root, int L, int R) {
        int ans = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node != null){
                if(node.val >= L && node.val <= R){
                    ans += node.val;
                }
                if(node.val > L){
                    stack.push(node.left);
                }
                if(node.val < R){
                    stack.push(node.right);
                }
            }
        }
        return ans;
    }
}
