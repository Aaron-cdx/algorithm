package leetcode.October_Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author caoduanxi
 * @2019/10/6 19:25
 */
public class Test1006 {
    // 将字符串s以空格拆分，判断是否为在wordDict中出现一次或者多次
    // 动态规划法 时间复杂度:O(n^2) 空间复杂度O(n)
    public static boolean wordBreak1(String s, List<String> wordDict) {
        int n = wordDict.size();
        if (wordDict == null || n == 0) {
            return false;
        }
        int sLen = s.length();
        boolean dp[] = new boolean[sLen+1];
        dp[0] = true;
        // 如果是待拆分的数据"bb"  "a" "b" "bbb" "bbbb" 结果为true
        for (int i = 1; i < sLen; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;// 结束本次循环，直接下一次循环
                }
            }
        }
        return dp[sLen];
    }
    /*
    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
    ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
     */
    // 回溯法 递归 时间复杂度(n^n) 空间复杂度O(n) 数的深度为n
    // 时间复杂度过高，会超时
    public static boolean wordBreak2(String s, List<String> wordDict) {
        return word_break1(s,new HashSet<>(wordDict),0);
    }

    private static boolean word_break1(String s, Set<String> wordDict, int start) {
        if(start == s.length()){
            return true;
        }
        // 这是找到一个之后理科嵌套下一个，如果一直为true表示都都可以通过切分来实现，
        // 通过if，返回true，否则直到结束，返回false
        for(int end=start+1; end <= s.length(); end++){
            if(wordDict.contains(s.substring(start,end)) && word_break1(s,wordDict,end)){
                return true;
            }
        }
        return false;
    }
    // 记忆化回溯法时间复杂度O(n^2) 时间复杂度O(n)树的深度可以达到n
    // 还没有完全看懂为什么需要加一个存储！！！！
    public static boolean wordBreak(String s, List<String> wordDict) {
        return word_break(s,new HashSet<>(wordDict),0,new Boolean[s.length()]);
    }
    private static boolean word_break(String s, Set<String> wordDict, int start,Boolean[] memo) {
        if(start == s.length()){
            return true;
        }
        if(memo[start] != null){
            return memo[start];
        }
        // 这是找到一个之后理科嵌套下一个，如果一直为true表示都都可以通过切分来实现，
        // 通过if，返回true，否则直到结束，返回false
        for(int end=start+1; end <= s.length(); end++){
            if(wordDict.contains(s.substring(start,end)) && word_break(s,wordDict,end,memo)){
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }



    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "pen");
        System.out.println(wordBreak("applepenapple",list));
    }
}
