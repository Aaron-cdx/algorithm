package leetcode.Septmber_Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caoduanxi
 * @2019/9/7 22:04
 */
public class Test08 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    class ANode {
        TreeNode node;
        int len;

        public ANode(TreeNode node, int len) {
            this.node = node;
            this.len = len;
        }
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        // 获取到这个节点即可
        return dfs(root).node;
    }
    // 1次深度优先搜索，只查找最深的节点
    public ANode dfs(TreeNode node){
        // 为null的话，返回null,0
        if(node == null) return new ANode(null,0);
        // 深度左边
        ANode leftNode = dfs(node.left);
        // 深度右边
        ANode rightNode = dfs(node.right);
        // 左大于右的话，返回左边节点
        if(leftNode.len > rightNode.len){
            return new ANode(leftNode.node,leftNode.len+1);
        }
        if(leftNode.len < rightNode.len){
            return new ANode(rightNode.node, rightNode.len+1);
        }
        // 左右相等的话，则是随便返回其中一个
        return new ANode(node,leftNode.len+1);
    }

    public TreeNode subtreeWithAllDeepest1(TreeNode root) {
        List<ANode> nodeList = new ArrayList<>();
        helper(root,nodeList,0);
        int maxDepth = Integer.MAX_VALUE;
        for (ANode aNode : nodeList) {
            if(aNode.len > maxDepth){
                maxDepth = aNode.len;
            }
            System.out.println(aNode.len);
        }
        for (ANode aNode : nodeList) {
            if(aNode.len == maxDepth - 1){
                if(aNode.node.left != null || aNode.node.right != null){
                    return aNode.node;
                }
            }
        }
        return null;
    }

    private void helper(TreeNode root, List<ANode> nodeList, int depth) {
        if(root == null) return;
        if(depth <= nodeList.size()){
            nodeList.add(new ANode(root,depth));
        }
        helper(root.left,nodeList,depth+1);
        helper(root.right,nodeList,depth+1);
    }

}
