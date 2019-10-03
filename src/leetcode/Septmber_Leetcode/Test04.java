package leetcode.Septmber_Leetcode;

import java.util.*;

/**
 * @author caoduanxi
 * @2019/9/3 20:38
 */
public class Test04 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return true;
        List<ANode> res = new ArrayList<>();
        // 构造一个类存放节点和个数
        res.add(new ANode(root,1));
        int i = 0;
        while(i < res.size()){
            // 获取到第一个
            ANode aNode = res.get(i++);
            if(aNode.node != null){
                // 只要node不为null，则左右判断
                res.add(new ANode(aNode.node.left,2*aNode.code));
                // 右边
                res.add(new ANode(aNode.node.right,2*aNode.code+1));
            }
        }
        // 获取到节点的总和，判断与res.size是否相同，相同为true，不同为false
        return res.get(i-1).code == res.size();
    }

    class ANode{
        TreeNode node;
        int code;
        public ANode(TreeNode node, int code) {
            this.node = node;
            this.code = code;
        }
    }

    public boolean isCompleteTree1(TreeNode root) {
        if(root == null) return true;
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        res.add(root.val);
        while (!queue.isEmpty()){
            int num = queue.size();
            for (int i = 0; i < num; i++) {
                TreeNode node = queue.poll();
                if(node.left != null){
                    res.add(node.left.val);
                    queue.add(node.left);
                }else{
                    // null的话，直接添加-1
                    res.add(-1);
                }
                if(node.right != null){
                    res.add(node.right.val);
                    queue.add(node.right);
                }else{
                    res.add(-1);
                }
            }
        }
        for (int i = 1; i < res.size(); i++) {
            // 只要有-1的后面出现非-1的值，直接判定为false
            if(res.get(i-1)==-1 && res.get(i) != -1){
                return false;
            }
        }
        return true;
    }
}
