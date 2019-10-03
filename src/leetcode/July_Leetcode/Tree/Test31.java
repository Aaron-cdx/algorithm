package leetcode.July_Leetcode.Tree;

/**
 * @author caoduanxi
 * @2019/7/21 16:47
 */
public class Test31 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
//    Set<Integer> set = new HashSet<>();
//    public boolean findTarget(TreeNode root, int k) {
//        if(root == null) return false;
//
//        if(set.contains(root.val)){
//            return true;
//        }else{
//            set.add(k - root.val);
//        }
//
//        return findTarget(root.left,k) || findTarget(root.right,k);
//    }
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;

        return preOrder(root, root, k);
    }

    public TreeNode findV(TreeNode node, int v){
        if(node == null) return null;

        if(node.val == v) return node;

        if(v < node.val) return findV(node.left,v);
        else  return findV(node.right,v);
    }

    public boolean preOrder(TreeNode node,TreeNode root,int k){
        if (node == null) return false;
        int target = k - node.val;
        TreeNode foundNode =  findV(root,target);
        // 去除重复的点，就是防止自己等于自己
        if(foundNode != null && node != foundNode) return true;
        else{
            return preOrder(node.left,root, k) || preOrder(node.right,root,k);
        }
    }
}
