package leetcode.November_Leetcode;

/**
 * @author caoduanxi
 * @2019/11/1 19:23
 */
public class Test1101 {
    // 主要是递归的时候，这个值超出了范围，通过官方14/15
    public static int numberOfArithmeticSlices1(int[] A) {
        if (A.length == 0 || A.length == 1 || A.length == 2) return 0;
        int[] temp = new int[A.length - 1];
        for (int i = 1; i < A.length; i++) {
            temp[i - 1] = A[i] - A[i - 1];
        }
        int res = 0;
        for (int i = 1; i < temp.length; i++) {
            int cnt = 1;
            int index = i;
            while (index < temp.length && temp[index] == temp[index - 1]) {
                cnt += 1;
                index++;
            }
            if (cnt >= 2) {
                res += getNum(cnt);
            }
            if (index >= temp.length) {
                break;
            }
            if (index != i) {
                i = index - 1;
            }
        }
        return res;
    }

    public static int getNum(int num) {
        return doFactorial(num) / (doFactorial(2) * doFactorial(num - 2));
    }

    public static int doFactorial(int n) {
        if (n < 0) {
            return -1;//传入的数据不合法
        }
        if (n == 0) {
            return 1;
        } else if (n == 1) {//递归结束的条件
            return 1;
        } else {
            return n * doFactorial(n - 1);
        }
    }

    // 这里考虑一对出现的情况，不是一对直接就pass
    // A[i+2]-A[i+1] = A[i+1]-A[i]
    public static int numberOfArithmeticSlices2(int[] A) {
        int count = 0;
        // i<A.length-2这里主要是为了保证i+2<A.length
        for (int i = 0; i < A.length - 2; i++) {
            int d = A[i + 1] - A[i];
            for (int j = i + 2; j < A.length; j++) {
                if (A[j] - A[j - 1] == d) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    // 递归的写法
    static int sum = 0;

    public static int numberOfArithmeticSlices3(int[] A) {
        slices(A, A.length - 1);
        return sum;
    }

    private static int slices(int[] A, int i) {
        if (i < 2) return 0;
        int temp = 0;
        if (A[i - 1] - A[i - 2] == A[i] - A[i - 1]) {
            temp = 1 + slices(A, i - 1);
            sum += temp;
        } else {
            temp = slices(A, i - 1);
        }
        return temp;
    }

    // 动态规划
    public static int numberOfArithmeticSlices4(int[] A) {
        if (A.length < 2) {
            return 0;
        }
        int[] dp = new int[A.length + 1];
        int sum = 0;
        for (int i = 2; i < A.length; i++) {
            // 只有能凑成对的才加，否则不加
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }
    // 常数空间动态规划
    public static int numberOfArithmeticSlices(int[] A) {
        if (A.length < 2) {
            return 0;
        }
        int dp = 0;
        int sum = 0;
        for (int i = 2; i < A.length; i++) {
            // 只有能凑成对的才加，否则不加
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp = dp + 1;
                sum += dp;
            }else{
                // 类似于动态规划中那个dp[i]=0
                dp = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{}));
    }
}
