package leetcode.August_Leetcode;

import java.util.*;

/**
 * @author caoduanxi
 * @2019/8/26 20:25
 */
public class Test28 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
    //  5
    //2   -3  结果为[5+2+-3, 2, -3]->[4, 2, -3]
    // 哈希表
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) return new int[0];
        HashMap<Integer,Integer> map = new HashMap<>();
        helper(root, map);
        int[] res = new int[map.size()];
        int num = 0;
        // 遍历map，获取键值
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == max){
                res[num++] = entry.getKey();
            }
        }
        // 截取所需要的值
        return Arrays.copyOfRange(res,0,num);
    }
    // 递归获取和，全局变量max统一最大这个概念
    public int helper(TreeNode root,Map<Integer,Integer> map){
        if(root == null) return 0;
        // 左边
        int left = helper(root.left,map);
        // 右边
        int right = helper(root.right,map);
        // 节点值
        int value = left + right + root.val;
        // 存储元素值与次数
        map.put(value,map.getOrDefault(value,0)+1);
        // 获取最大次数
        max = Math.max(max,map.get(value));
        return value;
    }
}
