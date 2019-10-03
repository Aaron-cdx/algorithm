package leetcode.July_Leetcode.Tree;

import java.util.List;

/**
 * @author caoduanxi
 * @2019/7/25 20:58
 */
public class Test35 {
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


    public int maxDepth(Node root) {
        if (root == null) return 0;
        int max = 0;
        for (Node child : root.children) {
            if (child != null) {
                int depth = maxDepth(child);
                max = Math.max(max, depth);
            }
        }
        return max + 1;
    }
}
