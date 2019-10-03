package leetcode.Septmber_Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author caoduanxi
 * @2019/9/21 19:41
 */
public class Test23 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
    // Ѱ��x�ڵ�ĸ���
    // Ѱ��y�ڵ�ĸ���
    // ���y>x�Ļ������ʤ
    // ˼·���ǻ�ȡx�ĸ��ڵ��������ɫ��
    // ��ȡx����ڵ���ɫ����x���ҽڵ���ɫ�����Լ�x����ɫ��+��x�����ɫ��
    TreeNode cur = null;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        if(root == null) return false;
        findNode(root,x);
        // ��߽ڵ�
        int curLeftNum = helper(cur.left);
        // �ұ߽ڵ�
        int curRightNum = helper(cur.right);
        // ���ڵ����
        int parentNum = n - curLeftNum - curRightNum - 1;
        // ÿ�λ�����еĽڵ��Ϊ�����֣�x�ĸ��ڵ������x����ڵ������x���ҽڵ����
        return (parentNum > curLeftNum+curRightNum || curLeftNum > parentNum + curRightNum
                || curRightNum > curLeftNum + parentNum );
    }
    // Ѱ�ҵ�x�Ľڵ�
    public void findNode(TreeNode root,int x){
        if(root == null) return;
        if(root.val == x){
            cur = root;
        }
        findNode(root.left,x);
        findNode(root.right,x);
    }
    // ��ȡ�ڵ����
    public int helper(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                res.add(node.val);
            }
        }
        return res.size();
    }
}
