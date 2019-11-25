package leetcode.October_Leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author caoduanxi
 * @2019/10/22 20:10
 */
public class Test1022 {
    //    // 暴力法，事件复杂度：O(k*n^k)指数级别
//    public static int coinChange(int[] coins, int amount) {
//        if (amount == 0) return 0;
//        int ans = Integer.MAX_VALUE;
//        for (int coin : coins) {
//            if (amount < coin) continue;
//            int subCoin = coinChange(coins, amount - coin);
//            if (subCoin == -1) continue;
//            ans = Math.min(ans, subCoin + 1);
//        }
//
//        return ans == Integer.MAX_VALUE ? -1 : ans;
//    }
//    // 备忘录法优化 时间复杂度O(k*n) 空间O(n)
//    public static int coinChange(int[] coins, int amount) {
//        int[] memo = new int[amount + 1];
//        Arrays.fill(memo, -2);
//        return helper(coins, amount, memo);
//    }
//
//    private static int helper(int[] coins, int amount, int[] memo) {
//        if (amount == 0) return 0;
//        // 这个剩余的钱是否已经匹配硬币
//        if (memo[amount] != -2) return memo[amount];
//        // 用来衡量这个结果是否变了，也就是有无匹配到硬币
//        int ans = Integer.MAX_VALUE;
//        for (int coin : coins) {
//            if (amount < coin) continue;
//            int subCoin = helper(coins, amount - coin, memo);
//            if (subCoin == -1) continue;
//            // 如果有的话就+1
//            ans = Math.min(ans, subCoin + 1);
//        }
//        return memo[amount] = ans == Integer.MAX_VALUE ? -1 : ans;
//    }
    // 将备忘录独立出来成为一张表，叫做dp table
    // 时间复杂度O(n*k) 空间复杂度O(N)
    public static int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int dp[] = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        // 将备忘录独立出来变为一张dp表，此时在备忘录中遍历
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                // 如果大于，继续
                if(coin > i){
                    continue;
                }else{
                    // 否则比较填充进入这里的与计算出的哪个小,1+dp[i-coin]的话，如果是不能兑换，则会一直往后走
                    dp[i] = Math.min(dp[i],1+dp[i-coin]);
                }
            }
        }
        // 最后判别其中的是否被修改，修改的话就返回结果，否则返回-1
        return dp[amount] > amount ? -1 : dp[amount];
    }


//        if(amount == 0) return 0;
//        Arrays.sort(coins);
//        for (int i = coins.length - 1; i >= 0 ; i--) {
//           if(amount < coins[i]){
//               continue;
//           }else if(amount >= coins[i]){
//               if(amount > coins[i]){
//                   return coinChange(coins,amount-coins[i]) == -1 ? -1: 1 + coinChange(coins,amount-coins[i]);
////                   return 1+coinChange(coins,amount-coins[i]);
//               }else{
//                   return 1;
//               }
//           }
//        }
//        if(amount == 0) return 0;
//        Arrays.sort(coins);
//        for (int i = coins.length - 1; i >= 0 ; i--) {
//            if(amount < coins[i] ){
//                continue;
//            }else if(amount >= coins[i]){
//                // 可以整除
//                if(amount % coins[i] == 0){
//                    // 获取多少个硬币
//                    return amount/coins[i];
//                }else{
//                    // 不能整除的情况
//                    return (amount/coins[i]) + coinChange(coins,amount%coins[i]);
//                }
//            }
//        }
//        return -1;

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }


    public static int coinChange1(int[] coins, int amount) {
        Arrays.sort(coins);
        for (int i = coins.length - 1; i >= 0; i--) {


        }

        return 0;
    }
}
