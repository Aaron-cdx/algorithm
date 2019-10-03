package leetcode.Septmber_Leetcode;

/**
 * @author caoduanxi
 * @2019/9/27 19:23
 */
public class Test26 {
    // 利用动态规划获取最长的回文子串
    // 暴力法：时间复杂度两个for循环O(n^2)第二个循环中的嵌套O(n),总的O(n^3)
    // 空间复杂度O(1)--------时间复杂度太高
    public String longestPalindrome1(String s) {
        String ans = "";
        int max = 0;
        int length = s.length();
        // 判断所有的子串是否含有回文子串
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

    // 判断此区间的是否是回文子串，只要前后判断即可
    // 每一个字符串的第一个和最后一个比较，len/2作为一个分界
    public boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 动态规划解题
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
