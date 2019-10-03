package leetcode.August_Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author caoduanxi
 * @2019/8/24 20:54
 */
public class Test24 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        return reserialize(root,res).toString();
    }
    public StringBuilder reserialize(TreeNode root,StringBuilder res){
        if(root == null){
            return res.append("null,");
        }
        res.append(root.val).append(",");
        res = reserialize(root.left,res);
        res = reserialize(root.right,res);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(split));
        return redeserialize(list);
    }
    public TreeNode redeserialize(List<String> list){
        if(list.get(0).equals("null")){
            list.remove(0);
            return null;
        }
        TreeNode res = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        res.left = redeserialize(list);
        res.right = redeserialize(list);
        return res;
    }
}
