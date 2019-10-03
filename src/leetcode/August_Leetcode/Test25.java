package leetcode.August_Leetcode;

/**
 * @author caoduanxi
 * @2019/8/24 20:54
 */
public class Test25 {
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
        if (root == null) return "";
        String s = root.val + ",";
        s += serialize(root.left);
        s += serialize(root.right);
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] split = data.split(",");
        return builderTree(split, 0, split.length - 1);
    }

    public TreeNode builderTree(String[] strs, int l, int r) {
        if (l > r) {
            return null;
        }
        // 构建根节点
        TreeNode root = new TreeNode(Integer.valueOf(strs[l]));
        int index = r+1;
        for (int i = l+1; i <= r; i++) {
            // 找到第一个比根节点大的，作为下一个节点
            if (Integer.valueOf(strs[i]) > root.val) {
                index = i;
                break;
            }
        }
        // 构建左右子树
        root.left = builderTree(strs, l + 1, index - 1);
        root.right = builderTree(strs, index, r);
        return root;
    }
}
