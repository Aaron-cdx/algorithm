package leetcode.Septmber_Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author caoduanxi
 * @2019/9/6 20:24
 */
public class Test07 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    List<Integer> res;
    TreeNode target;
    int K;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        res = new LinkedList<>();
        this.target = target;
        this.K = K;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) return -1;
        if (root == target) {
            subAdd(root, 0);
            return 1;
        }else{
            int L = dfs(root.left);// 计算左边的值
            int R = dfs(root.right);// 计算右边的值
            // 如果左边的不为-1，且为K，则此时计算右边与自己之间相差K-L-1的点
            if(L!=-1){
                if(L == K) res.add(root.val);
                subAdd(root.right,L+1);
                return L+1;
                // 否则判断左边不为-1，且为K，则此时计算左边与自己之间相差K-R-1的点
            }else if(R != -1){
                if(R==K) res.add(root.val);
                subAdd(root.left,R+1);
                return R+1;
            }
        }
        return -1;
    }

    public void subAdd(TreeNode node, int dist) {
        if (node == null) return;
        if (dist == K) {
            res.add(node.val);
        }
        subAdd(node.left, dist + 1);
        subAdd(node.right, dist + 1);
    }


    class ANode {
        TreeNode node;
        int len;

        public ANode(TreeNode node, int len) {
            this.node = node;
            this.len = len;
        }
    }

    public List<Integer> distanceK1(TreeNode root, TreeNode target, int K) {
        List<ANode> nodeList = new ArrayList<>();
        helper(root, nodeList, 0);
        List<Integer> res = new ArrayList<>();
        int depth = 0;
        System.out.println(nodeList);
        for (ANode aNode : nodeList) {
            if (aNode.node.val == target.val) {
                depth = aNode.len;
                break;
            }
        }
        // 遍历取出有k大小的
        for (ANode aNode : nodeList) {
            if ((aNode.len + depth == K) || Math.abs(aNode.len - depth) == K) {
                if (aNode.node.val != target.val) {
                    res.add(aNode.node.val);
                }
            }
        }
        return res;
    }

    private void helper(TreeNode root, List<ANode> nodeList, int depth) {
        if (root == null) return;
        if (depth <= nodeList.size()) {
            ANode node = new ANode(root, depth);
            nodeList.add(node);
        }
        helper(root.left, nodeList, depth + 1);
        helper(root.right, nodeList, depth + 1);
    }
}
