package leetcode.July_Leetcode.Tree;

/**
 * @author caoduanxi
 * @2019/7/12 20:35
 */
public class Test15 {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;

        if(p == null || q == null) return false;

        if(p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right,q.right);

    }

    public boolean isSameTree1(TreeNode p, TreeNode q) {
        // �ж��������Ƿ�����ͬ�������ṹ��ͬ��ֵҲ��ͬ
        // �����ǵݹ����������
        // �ݹ���Ҫһ����ֹ����
        if(p != null && q != null){
            if(p.val != q.val){
                return false;
            }else{
//                return isSameTree1(p.left, q.left) ? (isSameTree1(p.right, q.right)==true ? true : false) : false ;
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }else if(p!= null && q==null || p == null && q != null){
            return false;
        }
        return true;
    }
}
