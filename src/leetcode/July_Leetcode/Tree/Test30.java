package leetcode.July_Leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author caoduanxi
 * @2019/7/21 15:56
 */
public class Test30 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    // ��ʱ����Ҫ���ƹ���˼ά�����ܾ�������������Ŀ����ȫ�����õݹ�
    // ���ⰴ��ԭ�ȵ�˼·������˵�ʱ�򣬿��Ի�ͷ������
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if(root == null) return list;
        // ���ö������洢��ǰ�ڵ�
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            // ��ǰ�ڵ�ĸ���
            int size = queue.size();
            double ave = 0;
            for (int i = 0; i < size; i++) {
                // ͨ�������洢��һ����Ҫ����Ľڵ����
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                // ��ֵ�洢����
                ave += node.val;
            }
            // ���㲢���뵽list��
            list.add(ave/size);
        }
        return list;
    }
}
