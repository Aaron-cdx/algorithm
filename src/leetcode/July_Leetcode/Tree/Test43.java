package leetcode.July_Leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caoduanxi
 * @2019/7/28 22:25
 */
public class Test43 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getList(root,list);
        TreeNode tree = new TreeNode(0);
        tree.left = null;
        TreeNode p = tree;
        for (int x : list) {
            TreeNode node = new TreeNode(x);
            node.left = null;
            p.right = node;
            p = p.right;
            p.val = node.val;
        }
        return tree.right;
    }

    public void getList(TreeNode root, List<Integer> list){
        if(root == null) return;

        getList(root.left,list);

        list.add(root.val);

        getList(root.right,list);
    }
}
