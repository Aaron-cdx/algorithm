package leetcode.November_Leetcode;

import java.util.HashMap;

/**
 * @author caoduanxi
 * @2019/11/3 18:30
 */
public class Test1103 {
    /**
     * 解题思路：注意不能重复使用整数
     * 1、自己选择一个最大的只要能够触及目标就算赢了
     * 2、找一个对方赢不了的数字，也是自己赢了
     */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // 里面有数字大于，直接获胜
        if (maxChoosableInteger >= desiredTotal) return true;
        // 所有值总和都小于，不可能获胜
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;
        // 使用map来存储选过的数字
        HashMap<Integer, Boolean> map = new HashMap<>();
        return canWin(maxChoosableInteger, desiredTotal, 0, map);
    }
    // 二进制各个位真值代表某个元素是否已经使用，比如used = “1101”代表使用了1，3，4
    private boolean canWin(int maxChoosableInteger, int desiredTotal, int used, HashMap<Integer, Boolean> map) {
        // 如果之前搜索过直接返回
        if (map.containsKey(used)) {
            return map.get(used);
        }
        for (int i = 0; i < maxChoosableInteger; i++) {
            // 1 2 4 8 16 32 一直到2^maxChoosableInteger
            // 第i位表示选择[1,2,3,...,maxChoosableInteger]选择i+1这个值?
            int cur = 1 << i;
            // 判断这个值是否使用过
            // 如果等于0表示没有使用过
            if ((cur & used) == 0) {
                // desiredTotal <= i+1表示达到了预期值
                // desiredTotal -(i+1)表示选了i+1
                // 表示自己赢的情况与对方输的情况
                if (desiredTotal <= i + 1 || !canWin(maxChoosableInteger, desiredTotal - (i + 1), cur | used, map)) {
                    map.put(used, true);
                    return true;
                }
            }
        }
        map.put(used, false);
        return false;
    }
}
