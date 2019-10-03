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
     * 二叉树寻路
     * 每次找出label距离二叉树最右侧的位置，然后算出两者之差diff。
     * 每上升一层diff除以2，并可以利用diff和当前行的奇偶性求出路径上的每一个值。
     * <p>
     * label的父节点是label/2的对称节点
     * <p>
     * 要求对称节点，首先需要获取上面所有的值加起来为多少
     *
     * @param label
     * @return
     */
    public List<Integer> pathInZigZagTree1(int label) {
        List<Integer> res = new LinkedList<>();
        int level = 1;
        int count = 1;
        while (count < label) {
            // 往下走
            level = level << 1;
            // 统计数值，为了求对称点
            count += level;
        }
        // 找到了label在哪一层了
        while (label != 1) {
            // 往回走
            level >>= 1;
            // 添加往回走的值
            res.add(0, label);
            // 查找到对称点在哪，对称点为当前
            label = level + (level << 1) - 1 - (label >> 1);
        }
        // 添加1
        res.add(0, 1);
        return res;
    }

    // 使用递归解法
    public List<Integer> pathInZigZagTree(int label) {
        int level = (int) (Math.log(label) / Math.log(2));
        List<Integer> res = new ArrayList<>();
        helper(label, level, res);
        return res;
    }

    private void helper(int label, int level, List<Integer> res) {
        int temp = label / 2;
        // 对称点
        int tmpTwo = (int) (Math.pow(2, level) + Math.pow(2, level - 1) - 1) - temp;
        // 终止条件
        if (level != 0) helper(tmpTwo, level - 1, res);
        res.add(label);
    }


}
