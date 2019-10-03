package leetcode.Septmber_Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author caoduanxi
 * @2019/9/2 19:42
 */
public class Test02 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    int maxWidth = 0;

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        helper(root, 1, 1, new ArrayList<Integer>());
        return maxWidth;
    }
    // ע��list����������Ժ�level�����Ͳ������size�ˣ�����һֱ���еľ���index֮�������
    private void helper(TreeNode root, int level, int index, ArrayList<Integer> list) {
        if (root == null) return;
        // ��������list��size����
        if (level > list.size()) {
            // ֻҪlevel�󣬾����
            list.add(index);
        }
        // �б����ֵ����ǰ��index����ߵ�����index�Ƚϣ���Ϊlist�����ľ�����ߵ�list
        maxWidth = Math.max(maxWidth, index - list.get(level - 1) + 1);
        // ������ߣ�һֱȡ����index
        helper(root.left, level + 1, index * 2, list);
        // ���ұ�
        helper(root.right, level + 1, index * 2 + 1, list);
    }

    public int widthOfBinaryTree1(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> indexQueue = new LinkedList<>();
        queue.add(root);
        // ���볤��
        int len = 1;
        // ����λ��
        indexQueue.add(1);
        while (!queue.isEmpty()) {
            // ��ʱ�洢�ڵ�
            Queue<TreeNode> qQueue = new LinkedList<>();
            // ��ʱ�洢λ��
            LinkedList<Integer> nQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                // �ڵ��λ�õ���
                TreeNode node = queue.poll();
                int num = indexQueue.poll();
                // ��ӽڵ����Ӧ��λ��
                if (node.left != null) {
                    qQueue.add(node.left);
                    nQueue.add(2 * num);
                }
                if (node.right != null) {
                    qQueue.add(node.right);
                    nQueue.add(2 * num + 1);
                }
            }
            int pLen = 0;
            // �󳤶�
            if (nQueue.size() > 0) {
                pLen = nQueue.getLast() - nQueue.getFirst() + 1;
            }
            len = Math.max(len, pLen);
            // ��ֵ
            queue = qQueue;
            indexQueue = nQueue;
        }
        return len;
    }
}
