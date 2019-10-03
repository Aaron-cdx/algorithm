package leetcode.Septmber_Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author caoduanxi
 * @2019/9/2 19:42
 */
public class Test02 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    int maxWidth = 0;

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        helper(root, 1, 1, new ArrayList<Integer>());
        return maxWidth;
    }
    // 注意list遍历完左边以后，level基本就不会大于size了，所以一直进行的就是index之间的运算
    private void helper(TreeNode root, int level, int index, ArrayList<Integer> list) {
        if (root == null) return;
        // 行数大于list的size个数
        if (level > list.size()) {
            // 只要level大，就添加
            list.add(index);
        }
        // 判别最大值，当前的index与左边的最大的index比较，因为list中最大的就是左边的list
        maxWidth = Math.max(maxWidth, index - list.get(level - 1) + 1);
        // 往左边走，一直取最大的index
        helper(root.left, level + 1, index * 2, list);
        // 往右边
        helper(root.right, level + 1, index * 2 + 1, list);
    }

    public int widthOfBinaryTree1(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> indexQueue = new LinkedList<>();
        queue.add(root);
        // 放入长度
        int len = 1;
        // 放入位置
        indexQueue.add(1);
        while (!queue.isEmpty()) {
            // 临时存储节点
            Queue<TreeNode> qQueue = new LinkedList<>();
            // 临时存储位置
            LinkedList<Integer> nQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                // 节点和位置弹出
                TreeNode node = queue.poll();
                int num = indexQueue.poll();
                // 添加节点和相应的位置
                if (node.left != null) {
                    qQueue.add(node.left);
                    nQueue.add(2 * num);
                }
                if (node.right != null) {
                    qQueue.add(node.right);
                    nQueue.add(2 * num + 1);
                }
            }
            int pLen = 0;
            // 求长度
            if (nQueue.size() > 0) {
                pLen = nQueue.getLast() - nQueue.getFirst() + 1;
            }
            len = Math.max(len, pLen);
            // 赋值
            queue = qQueue;
            indexQueue = nQueue;
        }
        return len;
    }
}
