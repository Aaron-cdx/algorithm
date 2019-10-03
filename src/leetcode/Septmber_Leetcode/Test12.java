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

    // ��ת������ڵ����нڵ㣬�ҽڵ�����ڵ�
    List<Integer> res;
    int[] voyage;
    int index;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if (root == null) return res;
        res = new ArrayList<>();
        this.voyage = voyage;
        helper(root);
        // ��һ�����Բ���ӣ����ڽ����˵��ֻҪ��ƥ�䲻���Ѿ���-1��
        /*if (!res.isEmpty() && res.get(0) == -1) {
            // ���ڽ�����ж���У��
            res.clear();
            res.add(-1);
            return res;
        }*/
        return res;
    }

    public void helper(TreeNode root) {
        if (root != null) {
            if (root.val != voyage[index++]) {
                // ���ͷ�ڵ�Ͳ�����ˣ�ֱ����գ�����-1
                res.clear();
                res.add(-1);
                return;
            }
            if (index < voyage.length && root.left != null
                    && root.left.val != voyage[index]) {
                res.add(root.val);
                // ���з�ת�����ҽ�����ֻ��ת��ǰ����
                helper(root.right);
                helper(root.left);
            } else {
                helper(root.left);
                helper(root.right);
            }
        }
    }
}
