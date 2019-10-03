package leetcode.Septmber_Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caoduanxi
 * @2019/9/9 21:15
 */
public class Test10 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
    // ��ʵ�������ҷ�����Ŀ������
    // N=7
    //       ���5 �ұ�1      ���3 �ұ�3          ���1 �ұ�5
    // ���1 �ұ�3  ���3 �ұ�1               ���3 �ұ�1 ���1 �ұ�3

    public List<TreeNode> allPossibleFBT(int N) {
        if (N % 2 == 0) {
            new ArrayList<>(0);
        }
        List<TreeNode> list = new ArrayList<>();
        if (N == 1) {
            TreeNode root = new TreeNode(0);
            list.add(root);
            return list;
        }
        N--;
        for (int i = 1; i <= N; i+=2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
    }

}
