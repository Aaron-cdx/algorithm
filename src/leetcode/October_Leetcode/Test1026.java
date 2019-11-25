package leetcode.October_Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author caoduanxi
 * @2019/10/26 18:06
 */
public class Test1026 {
    // 需要找的是最大的整除子集
    // [1,2,3] => 1%2=1 | 2%1=0 =>[1,2] -- 1%3=1 | 3%1=0 =>[1,3]  ==>[1,2]或者[1,3]
    // 这里使用两个数组
    // 一个数组用于存储最大的数组元素个数
    // 一个数组用于维护最大数组元素个数的前一个数组元素的下标值，只找能除断的，不能除断的为-1，最后添加的时候去除-1即可
    // 时间复杂度O(n^2)  空间复杂度O(2n)
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        // 进行排序
        Arrays.sort(nums);
        int[] dp = new int[nums.length + 1];
        int[] pre = new int[nums.length + 1];
        Arrays.fill(dp, 1);
        Arrays.fill(pre, -1);
        for (int i = 1; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        pre[i] = j;
                    }
                }
            }
        }
        int index = 0;
        // 获取最大的索引值
        for (int i = 1; i < nums.length; i++) {
            if (dp[i] > dp[index]) {
                index = i;
            }
        }
        while (index != -1) {
            res.add(nums[index]);
            index = pre[index];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(1 % 3 + "--" + 1 % 2);
    }
}
