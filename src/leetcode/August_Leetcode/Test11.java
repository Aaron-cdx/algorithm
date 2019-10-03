package leetcode.August_Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author caoduanxi
 * @2019/8/14 21:13
 */
public class Test11 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, 0, res);
        return res;
    }

    public void helper(TreeNode root, int depth, List<List<Integer>> res) {
        if (root == null) return;
        if (res.size() <= depth) {
            res.add(0, new ArrayList<Integer>());
        }
        // 0 1 2 3 4
        // 4 3 2 1 0
        res.get(res.size() - 1 - depth).add(root.val);

        helper(root.left, depth + 1, res);
        helper(root.right, depth + 1, res);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> subList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node != null) {
                    subList.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (subList.size() > 0) {
                res.add(0, subList);
            }
        }
        return res;
    }
}
