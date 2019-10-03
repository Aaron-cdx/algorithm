package leetcode.August_Leetcode;

/**
 * @author caoduanxi
 * @2019/8/2 20:53
 */
public class Test3 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public int numTrees(int n) {
        // 求不同的二叉搜索树的个数
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }

        return G[n];
    }
}
