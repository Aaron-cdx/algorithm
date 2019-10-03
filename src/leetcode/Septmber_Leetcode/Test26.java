package leetcode.Septmber_Leetcode;

/**
 * @author caoduanxi
 * @2019/9/27 19:23
 */
public class Test26 {
    // ���ö�̬�滮��ȡ��Ļ����Ӵ�
    // ��������ʱ�临�Ӷ�����forѭ��O(n^2)�ڶ���ѭ���е�Ƕ��O(n),�ܵ�O(n^3)
    // �ռ临�Ӷ�O(1)--------ʱ�临�Ӷ�̫��
    public String longestPalindrome1(String s) {
        String ans = "";
        int max = 0;
        int length = s.length();
        // �ж����е��Ӵ��Ƿ��л����Ӵ�
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= length; j++) {
                String temp = s.substring(i, j);
                if (isPalindrome(temp) && temp.length() > max) {
                    ans = s.substring(i, j);
                    max = temp.length();
                }
            }
        }
        return ans;
    }

    // �жϴ�������Ƿ��ǻ����Ӵ���ֻҪǰ���жϼ���
    // ÿһ���ַ����ĵ�һ�������һ���Ƚϣ�len/2��Ϊһ���ֽ�
    public boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // ��̬�滮����
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;

        boolean[][] dp = new boolean[len][len];
        String res = s.substring(0,1);

        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && ((r - l <= 2) || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > res.length()) {
                        res = s.substring(l, r+1);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

}
