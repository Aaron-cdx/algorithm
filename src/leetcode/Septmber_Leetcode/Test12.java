package leetcode.Septmber_Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caoduanxi
 * @2019/9/11 19:45
 */
public class Test12 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    // 翻转就是左节点变成有节点，右节点变成左节点
    List<Integer> res;
    int[] voyage;
    int index;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if (root == null) return res;
        res = new ArrayList<>();
        this.voyage = voyage;
        helper(root);
        // 这一步可以不添加，对于结果来说，只要是匹配不上已经是-1了
        /*if (!res.isEmpty() && res.get(0) == -1) {
            // 对于结果进行二次校验
            res.clear();
            res.add(-1);
            return res;
        }*/
        return res;
    }

    public void helper(TreeNode root) {
        if (root != null) {
            if (root.val != voyage[index++]) {
                // 如果头节点就不相等了，直接清空，加入-1
                res.clear();
                res.add(-1);
                return;
            }
            if (index < voyage.length && root.left != null
                    && root.left.val != voyage[index]) {
                res.add(root.val);
                // 进行翻转，左右交换，只翻转当前树的
                helper(root.right);
                helper(root.left);
            } else {
                helper(root.left);
                helper(root.right);
            }
        }
    }
}
