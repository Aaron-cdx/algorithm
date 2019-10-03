package leetcode.Septmber_Leetcode;

import java.util.*;

/**
 * @author caoduanxi
 * @2019/9/3 19:47
 */
public class Test03 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // 节点相同就true
        if (root1 == root2) return true;
        // 如果其中有null，或者节点值不等，返回false
        if (root1 == null || root2 == null || root1.val != root2.val) return false;
        // 四种情况
        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)
                || flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
    }


    public boolean flipEquiv1(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        helper(root1, list1);
        helper(root2, list2);
        return list1.equals(list2);
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            // 自己设定一个标准，只要左边小于右边就从左边走
            // 左边大于右边就从右边走，这样获取到的值的顺序会是一致的，一致就true，否则false
            int L = root.left != null ? root.left.val : -1;
            int R = root.right != null ? root.right.val : -1;
            if (L < R) {
                helper(root.left, res);
                helper(root.right, res);
            } else {
                helper(root.right, res);
                helper(root.left, res);
            }
        }
    }

}
