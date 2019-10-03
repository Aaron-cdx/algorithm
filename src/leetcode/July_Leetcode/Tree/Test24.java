package leetcode.July_Leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caoduanxi
 * @2019/7/18 21:17
 */
public class Test24 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    List<Integer> list = new ArrayList<>();
    int max = 0;
    int cur = 1;
    TreeNode pre;
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[]{};
        inorder(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);

        if(pre != null){
            if(pre.val == root.val){
                cur += 1;
            }else{
                cur = 1;
            }
        }

        if(cur == max){
            list.add(root.val);
        }

        if(cur > max){
            list.clear();
            list.add(root.val);
            max = cur;
        }
        pre = root;

        inorder(root.right);
    }
}

