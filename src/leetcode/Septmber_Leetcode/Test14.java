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
        // 对象比较需要重写compareTo方法
        @Override
        public int compareTo(Object o) {
            Arr arr = (Arr) o;
            // 列相同
            if (this.x == arr.x) {
                // 行相同
                if (this.y == arr.y) {
                    // 同一位置，取值小的
                    return val - arr.val;
                } else {
                    // 不同位置，取行大的
                    return arr.y - y;
                }
            } else {
                // 列不相同，去列大的
                return x - arr.x;
            }
        }
    }

    ArrayList<Arr> arrs = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // 从之前的层次遍历的层换成二维数组中的[列，层]
        helper(root, 0, 0);
        // 排序排好了，表名相同列的都在一起
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

    // 这只能获取到map中的所有的垂直排序而已
    public void helper(TreeNode root, int X, int Y) {
        if (root == null) return;
        arrs.add(new Arr(X,Y,root.val));
        helper(root.left, X - 1, Y - 1);
        helper(root.right, X + 1, Y - 1);
    }
}
