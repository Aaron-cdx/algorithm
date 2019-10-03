package leetcode.Septmber_Leetcode;

import java.util.Arrays;

/**
 * @author caoduanxi
 * @2019/9/8 21:50
 */
public class Test09 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int len = pre.length;
        if(len == 0) return null;
        TreeNode root = new TreeNode(pre[0]);
        if(len == 1) return root;

        int L = 0;
        for (int i = 0; i < len; i++) {
            if(post[i] == pre[1]){
                L = i+1;
            }
        }
        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, L+1),
                Arrays.copyOfRange(post, 0, L));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, L+1, len),
                Arrays.copyOfRange(post, L, len-1));
        return root;
    }
}
