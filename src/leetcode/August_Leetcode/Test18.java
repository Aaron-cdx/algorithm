package leetcode.August_Leetcode;

/**
 * @author caoduanxi
 * @2019/8/20 19:47
 */
public class Test18 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
    // 左右子树，如果高度相等，则左边满树(前提加上父节点)，统计右边即可
    // 高度不相等，则右边树满树，统计左节点
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = getLevel(root.left);
        int right = getLevel(root.right);

        if (left == right) {
            return countNodes(root.right) + (1 << left);
        }else{
            return countNodes(root.left) + (1 << right);
        }
    }

    public int getLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            level += 1;
            root = root.left;
        }
        return level;
    }

    // 左右递归
    int sum = 1;

    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null) {
            sum += 1;
        }
        if (root.right != null) {
            sum += 1;
        }
        countNodes2(root.left);
        countNodes2(root.right);
        return sum;
    }

    // 直接左右+1父节点个数
    public int countNodes4(TreeNode root) {
        if (root == null) return 0;
        return countNodes4(root.left) + countNodes4(root.right) + 1;
    }
}
