package leetcode.Septmber_Leetcode;

import java.util.*;

/**
 * @author caoduanxi
 * @2019/9/3 20:38
 */
public class Test04 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return true;
        List<ANode> res = new ArrayList<>();
        // ����һ�����Žڵ�͸���
        res.add(new ANode(root,1));
        int i = 0;
        while(i < res.size()){
            // ��ȡ����һ��
            ANode aNode = res.get(i++);
            if(aNode.node != null){
                // ֻҪnode��Ϊnull���������ж�
                res.add(new ANode(aNode.node.left,2*aNode.code));
                // �ұ�
                res.add(new ANode(aNode.node.right,2*aNode.code+1));
            }
        }
        // ��ȡ���ڵ���ܺͣ��ж���res.size�Ƿ���ͬ����ͬΪtrue����ͬΪfalse
        return res.get(i-1).code == res.size();
    }

    class ANode{
        TreeNode node;
        int code;
        public ANode(TreeNode node, int code) {
            this.node = node;
            this.code = code;
        }
    }

    public boolean isCompleteTree1(TreeNode root) {
        if(root == null) return true;
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        res.add(root.val);
        while (!queue.isEmpty()){
            int num = queue.size();
            for (int i = 0; i < num; i++) {
                TreeNode node = queue.poll();
                if(node.left != null){
                    res.add(node.left.val);
                    queue.add(node.left);
                }else{
                    // null�Ļ���ֱ�����-1
                    res.add(-1);
                }
                if(node.right != null){
                    res.add(node.right.val);
                    queue.add(node.right);
                }else{
                    res.add(-1);
                }
            }
        }
        for (int i = 1; i < res.size(); i++) {
            // ֻҪ��-1�ĺ�����ַ�-1��ֵ��ֱ���ж�Ϊfalse
            if(res.get(i-1)==-1 && res.get(i) != -1){
                return false;
            }
        }
        return true;
    }
}
