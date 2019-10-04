package leetcode.October_Leetcode;

/**
 * @author caoduanxi
 * @2019/10/4 19:55
 */
public class Test1004 {
    // ʱ�临�Ӷ�O(mxn)
    // �ռ临�Ӷ�O(mxn)
    // ���Խ�dp[i-1][j-1]�����滻����
    // dp[i-1][j]����ɾ������
    // dp[i][j-1]�����������
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int dp[][] = new int[m+1][n+1];
        // ��һ��
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i-1][0] + 1;
        }
        // ��һ��
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j-1] +1;
        }
        // ����ǵ�һ�к͵�һ�е����
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // �����ȣ���ȡ��һ�ε����Ž�
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    // ���ȵĻ����ͱȽ���һ�ε����Ž⣬������˭��С��ȡ˭
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
                }
            }
        }
        // �������Ž�
        return dp[m][n];
    }
}
