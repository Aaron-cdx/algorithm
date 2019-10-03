package leetcode.August_Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author caoduanxi
 * @2019/8/5 22:16
 */
public class Test8 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = true;
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> res = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (flag) {
                    res.add(temp.val);
                } else {
                    res.addFirst(temp.val);
                }
                if (temp.left != null) {
                    queue.add(temp.left);

                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            flag = !flag;
            list.add(res);
        }
        return list;
    }

    public List<List<Integer>> zigzagLevelOrder3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root, 0);
        return res;
    }

    public void helper(List<List<Integer>> res, TreeNode root, int depth) {
        if (root == null) return;
        if (list.size() == depth) {
            list.add(new ArrayList<Integer>());
        }
        // 判断反转
        if (depth % 2 == 0) {
            res.get(depth).add(root.val);
        } else {
            // 只要写0,添加，那么后面的自然就会把前面的给移动到后面去
            res.get(depth).add(0, root.val);
        }
        // 什么时候反转
        if (root.left != null) {
            helper(res, root.left, depth + 1);
        }
        if (root.right != null) {
            helper(res, root.right, depth + 1);
        }
    }

    // 利用迭代来处理
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            res.add(new ArrayList<Integer>());
            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {
                TreeNode temp = queue.remove();
                if (level % 2 == 0) {
                    res.get(level).add(temp.val);
                } else {
                    res.get(level).add(0, temp.val);
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            level++;
        }
        return res;
    }

}
