package leetcode.July_Leetcode.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author caoduanxi
 * @2019/7/26 21:12
 */
public class Test38 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 使用一个临时节点
        Node pre = null;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.peek();
            // 当子节点为空的时候，或者pre有值的时候且当前的子节点包含pre，此时可以断定pre已经加入了运算
            // pre逐渐往前走，直到结束
            if (cur.children.size() == 0 || (pre != null && cur.children.contains(pre))) {
                res.add(cur.val);
                stack.pop();
                pre = cur;
            } else {
                List<Node> childList = cur.children;
                for (int i = childList.size() - 1; i >= 0; i--) {
                    stack.push(childList.get(i));
                }
            }
        }
        return res;
    }
}
