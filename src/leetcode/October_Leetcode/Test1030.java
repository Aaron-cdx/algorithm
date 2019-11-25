package leetcode.October_Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author caoduanxi
 * @2019/10/30 19:09
 */
public class Test1030 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) return null;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combin(candidates, target, res, 0, new ArrayList<>());
        return res;
    }

    public void combin(int[] candidates, int target, List<List<Integer>> res, int start, List<Integer> list) {
        // 到头了。不用计算了
        if (start < 0) return;
        // 等于零的话，证明到底了，此时需要执行回溯收取正确的值
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) break;
            list.add(candidates[i]);
            combin(candidates, target - candidates[i], res, i, list);
            // 注意啊，回溯啊
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) return null;
        List<List<Integer>> res = new ArrayList<>();
        // 需要执行一个去重操作
        Arrays.sort(candidates);
        combin2(candidates, target, res, 0, 0, new ArrayList<>());
        return res;
    }

    public void combin2(int[] candidates, int target, List<List<Integer>> res, int num, int start, List<Integer> list) {
        // 到头了。不用计算了
        if (start < 0) return;
        // 等于零的话，证明到底了，此时需要执行回溯收取正确的值
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (num + candidates[i] > target) break;
            // 怎么做到去重的，因为它排序了，所以与当前值相同的数一定是在他前面。
            // i>start是保证不是第一次使用这个加数，如果不i>start，则[1,1,6]这个解会丢失
            // 这是为了在同一个list组合中判断，所以当调用combin2的时候，此时的i进来一定会大于的，如果只用一个条件判断
            // 1 1 6这里面的第二个1就会被丢弃，答案出错
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            list.add(candidates[i]);
            combin2(candidates, target - candidates[i], res, num, i + 1, list);
            // 注意啊，回溯啊
            list.remove(list.size() - 1);
        }
    }


//    public boolean isExist(int num, int[] candidates){
//        for (int candidate : candidates) {
//            if(candidate == num){
//                return true;
//            }
//        }
//        return false;
//    }
}
