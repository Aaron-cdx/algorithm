package leetcode.Septmber_Leetcode;

/**
 * @author caoduanxi
 * @2019/9/21 18:50
 */
public class Test22 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    class ANode {
        TreeNode node;
        int dep;

        public ANode(TreeNode node, int dep) {
            this.node = node;
            this.dep = dep;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) return null;
        // ���ؽڵ�
        return helper(new ANode(root,0)).node;
    }

    // �ҵ���ߵ�����ڵ㸸�ڵ㣬�ҵ��ұ�����ڵ㸸�ڵ㣬������������ͬ
    // ���ظ��ڵ�
    public ANode helper(ANode aNode) {
        if (aNode.node == null) return null;
        // ���������������
        ANode leftNode = helper(new ANode(aNode.node.left, aNode.dep + 1));
        ANode rightNode = helper(new ANode(aNode.node.right, aNode.dep + 1));
        // ������Ҷ���Ϊ�գ��ж����Ҹ߶ȣ��߶���ͬ
        // �������Ƚڵ㣬ͬʱ�����Ƚڵ����Ϊ�ӽڵ����
        if(leftNode != null && rightNode != null){
            if(leftNode.dep > rightNode.dep){
                return leftNode;
            }else if(leftNode.dep < rightNode.dep){
                return rightNode;
            }else{
                aNode.dep = leftNode.dep;
                return aNode;
            }
        }
        // ���Ϊ�գ������ұ�
        if(leftNode == null && rightNode != null){
            return rightNode;
        }
        // �ұ�Ϊ�գ��������
        if(rightNode == null && leftNode != null){
            return leftNode;
        }
        // ֱ�ӷ��ظ��ڵ�
        return aNode;
    }
}
