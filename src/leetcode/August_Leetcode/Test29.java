package leetcode.August_Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caoduanxi
 * @2019/8/27 19:26
 */
public class Test29 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
    // 也可以使用迭代，一个全局变量保存第一个元素（这种方法等同迭代）
    List<List<Integer>> res = new ArrayList<>();

    public int findBottomLeftValue1(TreeNode root) {
        helper(root, 0);
        // 获取最后一个list的第一个元素即可
        return res.get(res.size()).get(0);
    }

    public void helper(TreeNode root, int depth) {
        if (root == null) return;
        if (res.size() == depth) {
            res.add(new ArrayList<Integer>());
        }
        res.get(depth).add(root.val);
        helper(root, depth + 1);
        helper(root, depth + 1);
    }
    int maxDepth = -1,maxLeft = -1;
    public int findBottomLeftValue(TreeNode root) {
        find(root, 0);
        return maxLeft;
    }
    // 使用中序遍历，左中右顺序
    private void find(TreeNode root, int depth) {
        if(root == null) return;
        // 左
        find(root.left,depth + 1);
        if(depth > maxDepth){
            maxLeft = root.val;
        }
        find(root.right,depth+1);
    }

}
