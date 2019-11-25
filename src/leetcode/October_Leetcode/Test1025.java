package leetcode.October_Leetcode;

/**
 * @author caoduanxi
 * @2019/10/25 19:52
 */
public class Test1025 {
    // 需要求的是每一位都不相同的数
    // 11 22 33 44 55 66 77 88 99
    // 1011 1022 1102 1122
//    public static int countNumbersWithUniqueDigits(int n) {
//        if (n == 0) return 1;
//        if (n == 1) return 9;
//        int count = 0;
//        int dp[] = new int[(int) Math.pow(10, n) + 1];
//        dp[11] = 1;
//        dp[22] = 1;
//        dp[33] = 1;
//        dp[44] = 1;
//        dp[55] = 1;
//        dp[66] = 1;
//        dp[77] = 1;
//        dp[88] = 1;
//        dp[99] = 1;
//        for (int i = 2; i <= n; i++) {
//            int start = (int)Math.pow(10,i-1);
//            int num = (int) Math.pow(10, i);
//            for (int j = start; j < num; j++) {
//                int temp = j;
//                while (temp != 0) {
//                    dp[j] += dp[temp % num];
//                    temp /= num;
//                }
//                if (dp[j] != 0) count++;
//            }
//        }
//        return (int) Math.pow(10, n) - count;
//    }
    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int temp = 1;
        // 这里可以得到，由于n最多为10
        // 9*9*8*....*(10-i)   第一位不能为0，所以也是9
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + temp * 9;
            temp *= (10 - i);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(4));
    }
}
