package leetcode.October_Leetcode;

/**
 * @author caoduanxi
 * @2019/10/15 19:50
 */
public class Test1015 {
    // 暴力法 时间复杂度太高了
//    public static int nthUglyNumber1(int n) {
//        int max = Integer.MAX_VALUE;
//        for (int i = 1; i < max; i++) {
//            if(isUgly(i)){
//                n--;
//                if(n==0){
//                    return i;
//                }
//            }
//        }
//        return 0;
//    }
    public static int nthUglyNumber(int n) {
        // 用来存储记忆结果,记忆回溯法
        int[] dp = new int[n];
        // 找出第n个丑数
        if (n == 1) {
            return 1;
        }
        dp[0] = 1;
        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
        for (int i = 1; i < n; i++) {
            // 选取其中最小的来作为排序，以此敲定前n个数
            dp[i] = Math.min(2 * dp[n1], Math.min(3 * dp[n2], 5 * dp[n3]));
            // 每一个数记过之后就往下一个走
            if(dp[i] >= 2*dp[n1]) n1++;
            if(dp[i] >= 3*dp[n2]) n2++;
            if(dp[i] >= 5*dp[n3]) n3++;
        }
        return dp[n-1];
    }


    public static boolean isUgly1(int num) {
        // 1与任何正整数都是互质
        if (num == 1) {
            return true;
        }
        if (num == 2 || num == 3 || num == 5) {
            return true;
        }
        if (num > 2 && num % 2 == 0) {
            return isUgly1(num / 2);
        }
        if (num > 3 && num % 3 == 0) {
            return isUgly1(num / 3);
        }
        if (num > 5 && num % 5 == 0) {
            return isUgly1(num / 5);
        }
        return false;
    }

    public static void isUgly(int num, Boolean[] dp) {
        // 连续判断
        if (num < 1) return;
        while (num != 1) {
            if (dp[num] != null) continue;
            if (num % 2 == 0) {
                num /= 2;
                continue;
            }
            if (num % 3 == 0) {
                num /= 3;
                continue;
            }
            if (num % 5 == 0) {
                num /= 5;
                continue;
            }
            dp[num] = false;
        }
        dp[num] = true;
    }


    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(nthUglyNumber(1690));
    }
}
