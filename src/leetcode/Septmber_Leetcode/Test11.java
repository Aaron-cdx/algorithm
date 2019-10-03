package leetcode.Septmber_Leetcode;

import java.util.Deque;

/**
 * @author caoduanxi
 * @2019/9/10 20:11
 */
class Test11 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    TreeNode root;
    Deque<TreeNode> deque;

//    public CBTInserter(TreeNode root) {
//        this.root = root;
//        deque = new LinkedList<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if(node.left == null || node.right == null){
//                // 注意队列是先进先出，所以从尾端插入
//                deque.offerLast(node);
//            }
//            if(node.left != null) queue.offer(node.left);
//            if(node.right != null) queue.offer(node.right);
//        }
//    }

    public int insert(int v) {
        TreeNode node = deque.peekFirst();
        // 将新节点也加入进来
        deque.offerLast(new TreeNode(v));
        if(node.left == null){
            node.left = deque.peekLast();
        }else{
            node.right = deque.peekLast();
            // 头结点弹出，因为已经满树了
            deque.pollFirst();
        }
        return node.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
