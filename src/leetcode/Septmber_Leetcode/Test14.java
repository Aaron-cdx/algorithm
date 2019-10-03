package leetcode.Septmber_Leetcode;

import java.util.*;

/**
 * @author caoduanxi
 * @2019/9/15 17:11
 */
public class Test14 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    class Arr implements Comparable {
        int x;
        int y;
        int val;

        public Arr() {
        }

        public Arr(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        // ����Ƚ���Ҫ��дcompareTo����
        @Override
        public int compareTo(Object o) {
            Arr arr = (Arr) o;
            // ����ͬ
            if (this.x == arr.x) {
                // ����ͬ
                if (this.y == arr.y) {
                    // ͬһλ�ã�ȡֵС��
                    return val - arr.val;
                } else {
                    // ��ͬλ�ã�ȡ�д��
                    return arr.y - y;
                }
            } else {
                // �в���ͬ��ȥ�д��
                return x - arr.x;
            }
        }
    }

    ArrayList<Arr> arrs = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // ��֮ǰ�Ĳ�α����Ĳ㻻�ɶ�ά�����е�[�У���]
        helper(root, 0, 0);
        // �����ź��ˣ�������ͬ�еĶ���һ��
        Collections.sort(arrs);
        List<List<Integer>> res = new ArrayList<>();
        int pre = -1002;
        List<Integer> temp = null;
        for (int i = 0; i < arrs.size(); i++) {
            if(arrs.get(i).x != pre){
                if(arrs.get(i).x != -1002 && temp != null){
                    res.add(temp);
                }
                temp = new ArrayList<>();
                temp.add(arrs.get(i).val);
            }else{
                temp.add(arrs.get(i).val);
            }
            pre = arrs.get(i).x;
        }
        if(temp != null) res.add(temp);
        return res;
    }

    // ��ֻ�ܻ�ȡ��map�е����еĴ�ֱ�������
    public void helper(TreeNode root, int X, int Y) {
        if (root == null) return;
        arrs.add(new Arr(X,Y,root.val));
        helper(root.left, X - 1, Y - 1);
        helper(root.right, X + 1, Y - 1);
    }
}
