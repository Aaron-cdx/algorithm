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
    // ���ַ���s�Կո��֣��ж��Ƿ�Ϊ��wordDict�г���һ�λ��߶��
    // ��̬�滮�� ʱ�临�Ӷ�:O(n^2) �ռ临�Ӷ�O(n)
    public static boolean wordBreak1(String s, List<String> wordDict) {
        int n = wordDict.size();
        if (wordDict == null || n == 0) {
            return false;
        }
        int sLen = s.length();
        boolean dp[] = new boolean[sLen+1];
        dp[0] = true;
        // ����Ǵ���ֵ�����"bb"  "a" "b" "bbb" "bbbb" ���Ϊtrue
        for (int i = 1; i < sLen; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;// ��������ѭ����ֱ����һ��ѭ��
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
    // ���ݷ� �ݹ� ʱ�临�Ӷ�(n^n) �ռ临�Ӷ�O(n) �������Ϊn
    // ʱ�临�Ӷȹ��ߣ��ᳬʱ
    public static boolean wordBreak2(String s, List<String> wordDict) {
        return word_break1(s,new HashSet<>(wordDict),0);
    }

    private static boolean word_break1(String s, Set<String> wordDict, int start) {
        if(start == s.length()){
            return true;
        }
        // �����ҵ�һ��֮�����Ƕ����һ�������һֱΪtrue��ʾ��������ͨ���з���ʵ�֣�
        // ͨ��if������true������ֱ������������false
        for(int end=start+1; end <= s.length(); end++){
            if(wordDict.contains(s.substring(start,end)) && word_break1(s,wordDict,end)){
                return true;
            }
        }
        return false;
    }
    // ���仯���ݷ�ʱ�临�Ӷ�O(n^2) ʱ�临�Ӷ�O(n)������ȿ��Դﵽn
    // ��û����ȫ����Ϊʲô��Ҫ��һ���洢��������
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
        // �����ҵ�һ��֮�����Ƕ����һ�������һֱΪtrue��ʾ��������ͨ���з���ʵ�֣�
        // ͨ��if������true������ֱ������������false
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
