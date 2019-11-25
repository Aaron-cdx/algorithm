package leetcode.October_Leetcode;

/**
 * @author caoduanxi
 * @2019/10/17 19:23
 */
public class Test1017 {
    int [] memo ;
    // 找出能组成和的完全平方数个数最少
    public int numSquares(int n) {
        memo = new int[n+1];
        return numSqu(n);
    }

    private int numSqu(int n) {
        // 记忆化是用一个全局变量来实现
        if(memo[n] != 0){
            return memo[n];
        }
        int val = (int)Math.sqrt(n);
        if(val*val == n) return memo[n] = 1;
        // 这里就是往回一直查找递归
        int res = Integer.MAX_VALUE;
        for (int i = 1; i*i < n; i++) {
            res = Math.min(res,numSqu(n-i*i)+1);
        }
        return memo[n]=res;
    }
    // 时间复杂度O(n*sqrt(n))
    public static int numSquares111(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }
        // 这里主要是针对上面的改版
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; i - j*j >= 0 ; j++) {
                // 第一个不赋值就是因为当正好为平方时，此时+1就正好是一个
                dp[i] = Math.min(dp[i],1+dp[i-j*j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares111(7));
    }
    // 自己的方法
//    public int numSquares111(int n) {
//        if(n==0) return 0;
//        int num = (int)Math.sqrt(n);
//        int[] dp = new int[num];
//        dp[0] = n/1;
//        for (int i = 1; i <= num; i++) {
//            if(n % i*i == 0){
//                if(n - i*i == 0){
//                    dp[i] = Math.min(dp[i-1],1);
//                }else{
//                    dp[i] = 1+ numSquares(n - i*i);
//                }
//            }
//        }
//        return dp[num-1];
//    }
}
