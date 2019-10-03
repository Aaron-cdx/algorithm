package leetcode.August_Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author caoduanxi
 * @2019/8/1 21:52
 */
public class Test2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    // �����ķ���
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if((temp.left == null && temp.right == null)
                || (pre != null && (pre == temp.right || pre == temp.left))){
                list.add(temp.val);
                pre = temp;
                stack.pop();
            }else{
                // �ֲ��账��ģ���¼ÿһ���ڵ㣬���������Ĳŵ���������һֱ���
                if(temp.right != null) stack.push(temp.right);
                if(temp.left != null) stack.push(temp.left);
            }
        }
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = root;
        while(!stack.isEmpty() || pre != null){
            while(pre != null){
                // һֱ������
                stack.push(pre);
                pre = pre.left;
            }
            TreeNode temp = stack.pop();
            list.add(temp.val);
            pre = temp.right;
        }
        return list;
    }
}
