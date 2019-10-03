package leetcode.July_Leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caoduanxi
 * @2019/7/28 21:49
 */
public class Test41 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        getList(root1,list1);
        List<Integer> list2 = new ArrayList<>();
        getList(root2,list2);
        return list1.equals(list2);
    }


    public void getList(TreeNode root, List<Integer> list) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        getList(root.left, list);
        getList(root.right, list);
    }
}
