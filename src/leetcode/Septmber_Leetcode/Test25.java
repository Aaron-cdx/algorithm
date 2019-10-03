package leetcode.Septmber_Leetcode;

/**
 * @author caoduanxi
 * @2019/9/26 19:22
 */
public class Test25 {
    boolean flag = true; // ����˿ֻ��ȡż��ʱ��ļ�����

    public boolean divisorGame(int N) {
        int[] num = getNum(N);
        // ����˿�غ�
        if (flag) {
            if (num[0] != 0) {
                flag = false;
                return divisorGame(num[1]);
            }
            return false;
        }
        // �����غ�
        else {
            if (num[0] != 0) {
                flag = true;
                return divisorGame(num[1]);
            }
            return true;
        }
    }

    public static int[] getNum(int N) {
        for (int i = 1; i < N; i++) {
            if (N % i == 0) {
                return new int[]{i, N - i};
            }
        }
        return new int[]{0, 0};
    }

    public boolean divisorGame1(int N) {
        if (N < 2) return false;
        boolean[] dp = new boolean[N + 1];
        dp[1] = false;
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                // �����ϵ��ֻ�ǰ���˿�Ƿ��ܹ�Ӯ�����Ի�ȡ��dpҲ�ǰ���˿�Ƿ���ʤ����
                if (!dp[i - j] && i % j == 0) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N] ;
    }
}
