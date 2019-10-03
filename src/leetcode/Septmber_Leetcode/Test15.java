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
     * char可以将数字+'a'强转到响应的字母
     * compareTo()可以比较两个字符串的大小
     */
    String ans = "~";
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder res = new StringBuilder();
        helper(root, res);
        return res.toString();
    }

    public void helper(TreeNode root, StringBuilder res) {
        if (root == null) return;
        // 转换成字母
        res.append((char)(root.val+'a'));
        if(root.left == null && root.right==null){
            res.reverse();
            // 这样保证插入的是倒序
            String temp = res.toString();
            res.reverse();
            if(temp.compareTo(ans) < 0){
                ans = temp;
            }
        }
        helper(root.left,res);
        helper(root.right,res);
        // 退一个
        res.deleteCharAt(res.length()-1);
    }
}
