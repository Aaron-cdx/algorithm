package leetcode.August_Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author caoduanxi
 * @2019/8/28 18:36
 */
public class Test31 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public TreeNode addOneRow1(TreeNode root, int v, int d) {
        if(root == null) return null;
        // root至少有一个节点
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<TreeNode> parentNode = new ArrayList<>();
        int depth = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                if(depth == d-1){
                    parentNode.add(node);
                }
            }
            depth ++;
            if(depth == d){
                break;
            }
        }
        // 重构二叉树
        for (TreeNode parent : parentNode) {
            TreeNode left = parent.left;
            TreeNode right = parent.right;
            TreeNode newNodeLeft = new TreeNode(v);
            TreeNode newNodeRight = new TreeNode(v);
            newNodeLeft.left = left;
            newNodeRight.right = right;
            parent.left = newNodeLeft;
            parent.right = newNodeRight;
        }
        return root;
    }
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(root == null) return null;
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        return helper(root,v,d,1);
    }

    private TreeNode helper(TreeNode root, int v, int d, int depth) {
        if(root == null) return null;
        // 也就是d在depth的下面，此时需要添加节点
        if(d == depth + 1){
            TreeNode left = root.left;
            TreeNode right = root.right;
            TreeNode newNodeLeft = new TreeNode(v);
            TreeNode newNodeRight = new TreeNode(v);
            newNodeLeft.left = left;
            newNodeRight.right = right;
            root.left = newNodeLeft;
            root.right = newNodeRight;
            return root;
        }
        root.left = helper(root.left,v,d,depth+1);
        root.right = helper(root.right,v,d,depth+1);
        return root;
    }


}
