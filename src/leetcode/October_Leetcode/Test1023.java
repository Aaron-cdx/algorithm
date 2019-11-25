package leetcode.October_Leetcode;

/**
 * @author caoduanxi
 * @2019/10/23 19:36
 */
public class Test1023 {
    // 暴力法：时间复杂度O(n*sizeof(num))
//    public int[] countBits(int num) {
//        int res[] = new int[num+1];
//        for (int i = 0; i < num; i++) {
//            res[i] = getBit(i);
//        }
//        return res;
//    }
//    public static int getBit(int num){
//        int count = 0;
//        while(num != 0){
//            count += num % 2;
//            num /= 2;
//        }
//        return count;
//    }
    // 动态规划：时间复杂度O(n)  空间复杂度O(n)
    public static int[] countBits(int num) {
        int dp[] = new int[num+1];
        dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            dp[i] = i%2 + dp[i/2];
        }
        return dp;
    }
    public static void main(String[] args) {
    }
}
