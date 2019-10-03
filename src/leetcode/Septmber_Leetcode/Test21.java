package leetcode.Septmber_Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author caoduanxi
 * @2019/9/20 21:48
 */
public class Test21 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }


    /**
     * ������Ѱ·
     * ÿ���ҳ�label������������Ҳ��λ�ã�Ȼ���������֮��diff��
     * ÿ����һ��diff����2������������diff�͵�ǰ�е���ż�����·���ϵ�ÿһ��ֵ��
     * <p>
     * label�ĸ��ڵ���label/2�ĶԳƽڵ�
     * <p>
     * Ҫ��Գƽڵ㣬������Ҫ��ȡ�������е�ֵ������Ϊ����
     *
     * @param label
     * @return
     */
    public List<Integer> pathInZigZagTree1(int label) {
        List<Integer> res = new LinkedList<>();
        int level = 1;
        int count = 1;
        while (count < label) {
            // ������
            level = level << 1;
            // ͳ����ֵ��Ϊ����ԳƵ�
            count += level;
        }
        // �ҵ���label����һ����
        while (label != 1) {
            // ������
            level >>= 1;
            // ��������ߵ�ֵ
            res.add(0, label);
            // ���ҵ��ԳƵ����ģ��ԳƵ�Ϊ��ǰ
            label = level + (level << 1) - 1 - (label >> 1);
        }
        // ���1
        res.add(0, 1);
        return res;
    }

    // ʹ�õݹ�ⷨ
    public List<Integer> pathInZigZagTree(int label) {
        int level = (int) (Math.log(label) / Math.log(2));
        List<Integer> res = new ArrayList<>();
        helper(label, level, res);
        return res;
    }

    private void helper(int label, int level, List<Integer> res) {
        int temp = label / 2;
        // �ԳƵ�
        int tmpTwo = (int) (Math.pow(2, level) + Math.pow(2, level - 1) - 1) - temp;
        // ��ֹ����
        if (level != 0) helper(tmpTwo, level - 1, res);
        res.add(label);
    }


}
