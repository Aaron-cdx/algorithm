package leetcode.October_Leetcode;

/**
 * @author caoduanxi
 * @2019/10/2 20:02
 */
public class Test1002 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // ��һ����������Լ������ϰ����ô�ʹ˽���������Ϊ1
                if (i == 0 && j == 0) {
                    if (obstacleGrid[i][j] == 1) {
                        return 0;
                    } else {
                        dp[i][j] = 1;
                    }
                }
                if (i == 0 && j != 0) {
                    // �߽��������0�����Լ���һ��Ҳ��0����ô��ʾû�������ϰ���
                    // ����Ϊ�˱���֮ǰ�������ϰ������ʹ���Լ���ͬ��ǰһ��
                    if (obstacleGrid[i][j] == 0 && obstacleGrid[i][j - 1] == 0) {
                        dp[i][j] = dp[i][j - 1];
                    }
                    // ���ϰ������ǰһ�����ϰ���Ļ�����������0
                }
                // ͬ��
                if (j == 0 && i != 0) {
                    if (obstacleGrid[i][j] == 0 && obstacleGrid[i - 1][j] == 0) {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
                // ������Ǳ߽磬�漰����������
                if (i != 0 && j != 0) {
                    if (obstacleGrid[i][j] == 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /*public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                // ��һ����������Լ������ϰ����ô�ʹ˽���������Ϊ1
                if (i == 0 && j == 0) {
                    if (obstacleGrid[i][j] == 1) {
                        return 0;
                    } else {
                        obstacleGrid[i][j] = 1;
                    }
                }
                if (i == 0 && j != 0) {
                    // �߽��������0�����Լ���һ��Ҳ��0����ô��ʾû�������ϰ���
                    // ����Ϊ�˱���֮ǰ�������ϰ������ʹ���Լ���ͬ��ǰһ��
                    if (obstacleGrid[i][j] == 0 && obstacleGrid[i][j - 1] == 0) {
                        obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                    }
                    // ���ϰ������ǰһ�����ϰ���Ļ�����������0
                }
                // ͬ��
                if (j == 0 && i != 0) {
                    if (obstacleGrid[i][j] == 0 && obstacleGrid[i - 1][j] == 0) {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                    }
                }
                // ������Ǳ߽磬�漰����������
                if (i != 0 && j != 0) {
                    if (obstacleGrid[i][j] == 0) {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                    }
                }
            }
        }
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }*/
}
