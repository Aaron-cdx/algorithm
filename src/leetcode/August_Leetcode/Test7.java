package leetcode.August_Leetcode;

import java.util.*;

/**
 * @author caoduanxi
 * @2019/8/5 21:40
 */
public class Test7 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> res = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                res.add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                    
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            list.add(res);
        }
        return list;
    }

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) return list;
        helper(root, 0);
        return list;
    }

    public void helper(TreeNode root, int level) {
        if (root == null) return;
        if (list.size() == level) {
            list.add(new ArrayList<Integer>());
        }
        // ¼ÇÂ¼²ãÊý
        list.get(level).add(root.val);

        if (root.left != null) {
            helper(root.left, level + 1);
        }
        if (root.right != null) {
            helper(root.right, level + 1);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            list.add(new ArrayList<Integer>());
            int level_length = queue.size();
            for (int i = 0; i < level_length; i++) {
                TreeNode temp = queue.remove();

                list.get(level).add(temp.val);

                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            level++;
        }
        return list;
    }

}
