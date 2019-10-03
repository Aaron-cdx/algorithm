package leetcode.Septmber_Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author caoduanxi
 * @2019/9/21 19:41
 */
public class Test23 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
    // 寻找x节点的个数
    // 寻找y节点的个数
    // 如果y>x的话，则获胜
    // 思路就是获取x的父节点的所有着色数
    // 获取x的左节点着色数，x的右节点着色数，以及x的着色数+除x外的着色数
    TreeNode cur = null;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        if(root == null) return false;
        findNode(root,x);
        // 左边节点
        int curLeftNum = helper(cur.left);
        // 右边节点
        int curRightNum = helper(cur.right);
        // 父节点个数
        int parentNum = n - curLeftNum - curRightNum - 1;
        // 每次会把所有的节点分为三部分，x的父节点个数，x的左节点个数，x的右节点个数
        return (parentNum > curLeftNum+curRightNum || curLeftNum > parentNum + curRightNum
                || curRightNum > curLeftNum + parentNum );
    }
    // 寻找到x的节点
    public void findNode(TreeNode root,int x){
        if(root == null) return;
        if(root.val == x){
            cur = root;
        }
        findNode(root.left,x);
        findNode(root.right,x);
    }
    // 获取节点个数
    public int helper(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                res.add(node.val);
            }
        }
        return res.size();
    }
}
