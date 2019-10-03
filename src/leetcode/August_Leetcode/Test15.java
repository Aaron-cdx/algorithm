package leetcode.August_Leetcode;

/**
 * @author caoduanxi
 * @2019/8/18 18:43
 */
public class Test15 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    // 字符串拼接
    int sum = 0;

    public int sumNumbers1(TreeNode root) {
        helper(root, new StringBuilder());
        return sum;
    }

    public void helper(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val);
        // 判断是否是叶子节点，是叶子节点就加入到sum中
        if (root.left == null && root.right == null) {
            sum += Integer.parseInt(sb.toString());
        }
        helper(root.left, sb);
        helper(root.right, sb);
        // 回退的操作没做--因为sb是全局变量，不回退的话是没法继续运算的
        sb.delete(sb.length() - 1, sb.length());
    }

    // 直接数值运算
    int res = 0;

    public int sumNumbers(TreeNode root) {
        newHelper(root, 0);
        return res;
    }

    public void newHelper(TreeNode root, int temp) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sum += temp * 10 + root.val;
        }
        newHelper(root.left, temp * 10 + root.val);
        newHelper(root.right, temp * 10 + root.val);
    }
}
