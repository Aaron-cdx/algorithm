package leetcode.July_Leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caoduanxi
 * @2019/7/14 20:42
 */
public class Test23 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }




    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> resList = new ArrayList<>();

        addList(root,sum,resList,new ArrayList<Integer>());
        return resList;
    }

    public void addList(TreeNode root, int sum, List<List<Integer>> resList, ArrayList<Integer> list){
        if(root == null) return;

        list.add(root.val);

        if(root.left == null && root.right == null && root.val - sum == 0){
            // ���ã���Ҫʹ��new ArrayList<>(list)
            resList.add(new ArrayList<>(list));
        }
        // һֱ�����о���ӣ�û�оͻ��ݣ�Ȼ������
        addList(root.left,sum - root.val, resList, list);
        addList(root.right, sum - root.val, resList, list);

        list.remove(list.size() - 1);
    }
}
