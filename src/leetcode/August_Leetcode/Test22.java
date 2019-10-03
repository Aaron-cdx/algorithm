package leetcode.August_Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author caoduanxi
 * @2019/8/22 21:09
 */
public class Test22 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder helper = helper(root, new StringBuilder());
        return helper.toString();
    }

    public StringBuilder helper(TreeNode root, StringBuilder s) {
        if (root == null) {
            s.append("null,");
            return s;
        } else {
            s.append(root.val).append(",");
            s = helper(root.left, s);
            s = helper(root.right, s);
        }
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        LinkedList<String> strings = new LinkedList<>(Arrays.asList(split));
        return redeserialize(strings);
    }

    public TreeNode redeserialize(List<String> s) {
        if (s.get(0).equals("null")) {
            s.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(s.get(0)));
        // ÒÆ³ý
        s.remove(0);
        root.left = redeserialize(s);
        root.right = redeserialize(s);
        return root;
    }

}
