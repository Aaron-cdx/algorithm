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
//                // ע��������Ƚ��ȳ������Դ�β�˲���
//                deque.offerLast(node);
//            }
//            if(node.left != null) queue.offer(node.left);
//            if(node.right != null) queue.offer(node.right);
//        }
//    }

    public int insert(int v) {
        TreeNode node = deque.peekFirst();
        // ���½ڵ�Ҳ�������
        deque.offerLast(new TreeNode(v));
        if(node.left == null){
            node.left = deque.peekLast();
        }else{
            node.right = deque.peekLast();
            // ͷ��㵯������Ϊ�Ѿ�������
            deque.pollFirst();
        }
        return node.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
