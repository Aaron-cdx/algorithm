package leetcode.Septmber_Leetcode;

/**
 * @author caoduanxi
 * @2019/9/16 19:58
 */
public class Test15 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    /**
     * char���Խ�����+'a'ǿת����Ӧ����ĸ
     * compareTo()���ԱȽ������ַ����Ĵ�С
     */
    String ans = "~";
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder res = new StringBuilder();
        helper(root, res);
        return res.toString();
    }

    public void helper(TreeNode root, StringBuilder res) {
        if (root == null) return;
        // ת������ĸ
        res.append((char)(root.val+'a'));
        if(root.left == null && root.right==null){
            res.reverse();
            // ������֤������ǵ���
            String temp = res.toString();
            res.reverse();
            if(temp.compareTo(ans) < 0){
                ans = temp;
            }
        }
        helper(root.left,res);
        helper(root.right,res);
        // ��һ��
        res.deleteCharAt(res.length()-1);
    }
}
