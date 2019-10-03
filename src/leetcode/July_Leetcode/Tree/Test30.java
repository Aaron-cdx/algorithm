package leetcode.July_Leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author caoduanxi
 * @2019/7/21 15:56
 */
public class Test30 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    // 有时候需要打破惯性思维！不能觉得在做树的题目，就全是利用递归
    // 问题按照原先的思路解决不了的时候，可以回头看看！
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if(root == null) return list;
        // 利用队列来存储当前节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            // 当前节点的个数
            int size = queue.size();
            double ave = 0;
            for (int i = 0; i < size; i++) {
                // 通过遍历存储下一次需要计算的节点个数
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                // 将值存储起来
                ave += node.val;
            }
            // 计算并加入到list中
            list.add(ave/size);
        }
        return list;
    }
}
