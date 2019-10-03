package leetcode.August_Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author caoduanxi
 * @2019/8/1 21:04
 */
public class Test1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    public void helper(TreeNode root, List<Integer> list) {
        if (root == null) return;

        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }

    // ������
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        // ��һ��ָ��ģ����ʹ���
        TreeNode pre = root;
        while(!stack.isEmpty() || pre != null){
            while(pre != null){
                stack.push(pre);
                pre = pre.left;
            }
            TreeNode temp = stack.pop();
            list.add(temp.val);
            // ǿ��ת�Ƶ��ұߣ���ΪΪnull���������ȥ��������Ӱ��
            pre = temp.right;
        }
        return list;
    }

}
