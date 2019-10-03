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
        // �����ָ��ָ������һ���ڵ���Ҳ�ڵ�
        if (root == null) return null;
        if (root.left != null) {
            // �ڵ���ڵ���һ���ڵ��Ӧ�ڵ��ҽڵ�
            root.left.next = root.right;
            // �жϽڵ���һ���ڵ��Ƿ�Ϊ��
            if (root.next != null) {
                // ��Ϊ�����ҽڵ����һ���ڵ�����һ���ڵ����ڵ�������
                root.right.next = root.next.left;
            }
        }
        connect1(root.left);
        connect1(root.right);
        return root;
    }

    // ����д��
    public Node connect2(Node root) {
        if (root == null) return null;
        Node pre = root;
        while (pre != null) {
            // ��һ����ʱ�ڵ�
            Node cur = pre;
            while (cur != null) {
                // ��߲�Ϊnull,��ѡ����һ���ڵ�Ϊ�ҽڵ�
                if (cur.left != null) cur.left.next = cur.right;
                // �ұ߲�Ϊnull������һ�ڵ���ڣ���ѡ����һ�ڵ�Ϊnext����ڵ�
                if (cur.right != null && cur.next != null) cur.right.next = cur.next.left;
                // ʵ���������ұ�ǰ��
                cur = cur.next;
            }
            // ÿ���������
            pre = pre.left;
        }
        return root;
    }
}
