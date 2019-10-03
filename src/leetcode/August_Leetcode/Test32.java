package leetcode.August_Leetcode;

import java.util.*;

/**
 * @author caoduanxi
 * @2019/8/29 19:57
 */
public class Test32 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    // 将节点值序列化成值
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();
        helper(root, res, map);
        return res;
    }

    public String helper(TreeNode root, List<TreeNode> res, Map<String, Integer> map) {
        if (root == null) return "";
        // 序列化值比较是否相等
        String nodeValue = root.val + "," + helper(root.left, res, map) + "," + helper(root.right, res, map);
        if(map.get(nodeValue)!= null && map.get(nodeValue) == 1){
            res.add(root);
        }
        map.put(nodeValue,map.getOrDefault(nodeValue,0)+1);
        return nodeValue;
    }
}
