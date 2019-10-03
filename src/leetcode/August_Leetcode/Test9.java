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
        // �ҳ�ǰ���������������Ĺ�ͬ��
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
        // p+1+k-i p+1��ǰ������е�ͷ��㣬k-i��ʾ������˶��ٸ��������ұߴ����߾�����
        root.right = helper(preorder, p + 1 + k - i, inorder, k + 1, j);
        return root;
    }

    // ʹ��HashMap����������Ľڵ�
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
        // p_start+1,��һ����������ߵĻ�����p_start+1��ʼ����p_start+1+leftNum����
        // ��Ӧ���򣬴�i_start��ʼ����i_index����
        root.left = rebuild(preorder,p_start+1,p_start+1+leftNum,inorder,i_start,i_index,map);
        // ǰ���p_start+1��ʼ����p_start+1+leftNum�����������i_index+1��ʼ����i_end����
        root.right = rebuild(preorder,p_start+1+leftNum,p_end,inorder,i_index+1,i_end,map);
        return root;
    }
}
