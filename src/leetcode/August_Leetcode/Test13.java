package leetcode.August_Leetcode;

/**
 * @author caoduanxi
 * @2019/8/15 21:15
 */
public class Test13 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) return null;
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = findLeftChild(root);
            }
        }
        if(root.right != null){
            root.right.next = findLeftChild(root);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }

    private Node findLeftChild(Node root) {
        while(root.next != null){
            if(root.next.left != null) return root.next.left;
            if(root.next.right != null) return root.next.right;
            root = root.next;
        }
        return null;
    }


    public Node connect1(Node root) {
        // 让这个指针指向其下一个节点的右侧节点
        if (root == null) return null;
        if (root.left != null) {
            // 节点左节点下一个节点对应节点右节点
            root.left.next = root.right;
            // 判断节点下一个节点是否为空
            if (root.next != null) {
                // 不为空则将右节点的下一个节点与另一个节点的左节点相连接
                root.right.next = root.next.left;
            }
        }
        connect1(root.left);
        connect1(root.right);
        return root;
    }

    // 迭代写法
    public Node connect2(Node root) {
        if (root == null) return null;
        Node pre = root;
        while (pre != null) {
            // 用一个临时节点
            Node cur = pre;
            while (cur != null) {
                // 左边不为null,则选择下一个节点为右节点
                if (cur.left != null) cur.left.next = cur.right;
                // 右边不为null，且下一节点存在，则选择下一节点为next的左节点
                if (cur.right != null && cur.next != null) cur.right.next = cur.next.left;
                // 实质是在往右边前进
                cur = cur.next;
            }
            // 每次向左边走
            pre = pre.left;
        }
        return root;
    }
}
