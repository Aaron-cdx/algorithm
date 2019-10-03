package leetcode.October_Leetcode;

/**
 * @author caoduanxi
 * @2019/10/3 19:46
 * <p>
 * ��Ŀ����¥�ݣ���Ҫn�׵�¥��
 * ÿ�ο���ѡ��1��¥�ݻ�������¥��
 * ���ж����з�����¥
 */
public class Test1003 {
    // ������Ŀ��������һ��쳲����������⣬
    // ����֪����ǰ��ֵ����i-1��i-2��ֵ���
    // ʱ�临�Ӷ�ΪO(n) �ռ临�Ӷ�O(n)
    public static int climbStairs1(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    // ����������1��2�ֱ����ߵĸ������
    // ʱ�临�Ӷ�O(2^n) �ռ临�Ӷ�O(1)
    public static int climbStairs2(int n) {
        return climbStairs(0, n);
    }

    public static int climbStairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climbStairs(i + 1, n) + climbStairs(i + 2, n);
    }

    // �����͵ݹ飬��һ�������������µݹ鵽�������ֵ
    // ʱ�临�Ӷ�O(n)  �ռ临�Ӷ�O(n)
    public static int climbStairs(int n) {
        int[] memo = new int[n+1];
        return climb_stairs(0,n,memo);
    }

    private static int climb_stairs(int i, int n, int[] memo) {
        if(i > n){
            return 0;
        }
        if(i == n){
            return 1;
        }
        // ������û��֮ǰ�������ֵ���еĻ�ֱ�ӷ��أ��Ӷ���ʡ�˼���ʱ��
        if(memo[i] > 0){
            return memo[i];
        }
        memo[i] = climb_stairs(i+1,n,memo)+climb_stairs(i+2,n,memo);
        return memo[i];
    }


    public static void main(String[] args) {
        System.out.println(climbStairs(44));
    }
}
