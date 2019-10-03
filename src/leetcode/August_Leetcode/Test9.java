package leetcode.August_Leetcode;

import java.util.HashMap;

/**
 * @author caoduanxi
 * @2019/8/6 22:05
 */
public class Test9 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        // 找出前序遍历和中序遍历的共同点
        // 3 9 20 15 7
        // 9 3 15 20 7
        return helper(preorder, 0, inorder, 0, inorder.length);
    }

    public TreeNode helper(int[] preorder, int p, int[] inorder, int i, int j) {
        if (i >= j) return null;
        TreeNode root = new TreeNode(preorder[p]);
        int k = 0;
        while (inorder[k] != root.val) {
            k++;
        }
        root.left = helper(preorder, p + 1, inorder, i, k);
        // p+1+k-i p+1是前序遍历中的头结点，k-i表示左边走了多少个，这样右边从这走就正好
        root.right = helper(preorder, p + 1 + k - i, inorder, k + 1, j);
        return root;
    }

    // 使用HashMap来保存中序的节点
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return rebuild(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    public TreeNode rebuild(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end, HashMap<Integer, Integer> map) {
        if(p_start == p_end) return null;
        TreeNode root = new TreeNode(preorder[p_start]);
        int i_index = map.get(root.val);
        int leftNum = i_index - i_start;
        // p_start+1,下一个，构建左边的话，从p_start+1开始，到p_start+1+leftNum结束
        // 对应中序，从i_start开始，到i_index结束
        root.left = rebuild(preorder,p_start+1,p_start+1+leftNum,inorder,i_start,i_index,map);
        // 前序从p_start+1开始，到p_start+1+leftNum结束，中序从i_index+1开始，到i_end结束
        root.right = rebuild(preorder,p_start+1+leftNum,p_end,inorder,i_index+1,i_end,map);
        return root;
    }
}
