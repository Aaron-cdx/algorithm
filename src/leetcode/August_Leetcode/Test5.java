package leetcode.August_Leetcode;

import java.util.Stack;

/**
 * @author caoduanxi
 * @2019/8/3 21:19
 */
public class Test5 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        // ������С�ڵ�ǰ�ڵ㣬���������ڵ�ǰ�ڵ㣬������������������Ҳ�����Ƕ���������
        if (root == null) return false;
        return isSubBST(root, null, null);
    }

    // �ж����������Ƿ��Ƕ���������
    public boolean isSubBST(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        // ����һ�����ֵ��һ����Сֵ�������Сֵ��Ϊnull���ҵ�ǰֵС����Сֵ������false
        int val = root.val;
        if ((lower != null && val <= lower)) {
            return false;
        }
        // ������ֵ��Ϊnull���ҵ�ǰֵ�������ֵ������false
        if (upper != null && val >= upper) {
            return false;
        }
        // �����������Ͻ죬���½�
        if (!isSubBST(root.right, val, upper)) return false;
        // �����������½磬���Ͻ�
        if (!isSubBST(root.left, lower, val)) return false;
        return true;
    }

    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (pre != null || pre.val >= p.val) return false;
            pre = p;
            p = p.right;
        }
        return true;
    }

    TreeNode p = null;

    public boolean isValidBST3(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST3(root.left)) return false;

        if(p != null && p.val >= root.val) return false;
        p = root;// p��Զ��Ϊ�м�ڵ�

        return isValidBST3(root.right);

    }
}
