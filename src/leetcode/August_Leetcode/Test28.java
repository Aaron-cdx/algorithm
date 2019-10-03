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
    //2   -3  ���Ϊ[5+2+-3, 2, -3]->[4, 2, -3]
    // ��ϣ��
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) return new int[0];
        HashMap<Integer,Integer> map = new HashMap<>();
        helper(root, map);
        int[] res = new int[map.size()];
        int num = 0;
        // ����map����ȡ��ֵ
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == max){
                res[num++] = entry.getKey();
            }
        }
        // ��ȡ����Ҫ��ֵ
        return Arrays.copyOfRange(res,0,num);
    }
    // �ݹ��ȡ�ͣ�ȫ�ֱ���maxͳһ����������
    public int helper(TreeNode root,Map<Integer,Integer> map){
        if(root == null) return 0;
        // ���
        int left = helper(root.left,map);
        // �ұ�
        int right = helper(root.right,map);
        // �ڵ�ֵ
        int value = left + right + root.val;
        // �洢Ԫ��ֵ�����
        map.put(value,map.getOrDefault(value,0)+1);
        // ��ȡ������
        max = Math.max(max,map.get(value));
        return value;
    }
}
