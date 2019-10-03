package leetcode.July_Leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caoduanxi
 * @2019/7/24 21:19
 */
public class Test34 {
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

    /**
     * �����������Ҫ���������⣡������
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, 0, res);
        return res;
    }

    public void helper(Node root, int depth, List<List<Integer>> res) {
        if (root == null) return;
        // ���������ߣ�����ÿһ����һ���յ�list��������������
        if (depth + 1 > res.size()) {
            res.add(new ArrayList<Integer>());
        }
        res.get(depth).add(root.val);

        for (Node child : root.children) {
            if (child != null) {
                helper(child, depth + 1, res);
            }
        }
    }
}
