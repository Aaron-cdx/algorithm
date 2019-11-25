package leetcode.October_Leetcode;

import java.util.*;

/**
 * @author caoduanxi
 * @2019/10/8 20:18
 */
public class Test1008 {

    // catsanddog   cat sand dog  cats and dog
    // 暴力法，直接第一个，然后回溯后面所有的，然后再继续再回溯
    // 时间复杂度O(n^n)n个嵌套n个 空间复杂度O(n^3)深度为n，每层可能n个字符，字符长度可能为n
    public static List<String> wordBreak1(String s, List<String> wordDict) {
//        boolean dp[] = new boolean[s.length() + 1];
        // 去重复
        Set<String> wordSet = new HashSet<>();
        for (int i = 0; i < wordDict.size(); i++) {
            wordSet.add(wordDict.get(i));
        }

        return word(s, wordSet, 0);
    }

    public static List<String> word(String s, Set<String> wordSet, int start) {
        List<String> res = new ArrayList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordSet.contains(s.substring(start, end))) {
                List<String> list = word(s, wordSet, end);
                for (String s1 : list) {
                    res.add(s.substring(start, end) + (s1.equals("") ? "" : " " + s1));
                }
            }
        }
        return res;
    }
    // 记忆化回溯：用map来存储，一旦发现相同的下标直接返回对应的list即可
    // 时间复杂度O(n^3)回溯树最多为n^2 创建表需要n
    public List<String> wordBreak(String s, List<String> wordDict) {
//        boolean dp[] = new boolean[s.length() + 1];
        // 去重复
        Set<String> wordSet = new HashSet<>();
        for (int i = 0; i < wordDict.size(); i++) {
            wordSet.add(wordDict.get(i));
        }

        return word_break(s, wordSet, 0);
    }
    HashMap<Integer,List<String>> map = new HashMap<>();
    public List<String> word_break(String s, Set<String> wordSet, int start) {
        if(map.containsKey(start)){
            return map.get(start);
        }
        List<String> res = new ArrayList<>();
        if (start == s.length()) {
            res.add("");
        }

        for (int end = start + 1; end <= s.length(); end++) {
            if (wordSet.contains(s.substring(start, end))) {
                List<String> list = word_break(s, wordSet, end);
                for (String s1 : list) {
                    res.add(s.substring(start, end) + (s1.equals("") ? "" : " " + s1));
                }
            }
        }
        map.put(start,res);
        return res;
    }
    // 动态规划法:时间复杂度O(n^3)循环n^2 添加一个list一个n
    // 空间复杂度:O(n^3) dp数组为n,循环有n^2
    public static List<String> wordBreak2(String s, List<String> wordDict) {
        LinkedList<String>[] dp = new LinkedList[s.length() + 1];
        LinkedList<String> initial = new LinkedList<>();
        initial.add("");
        dp[0] = initial;
        for (int i = 1; i <= s.length(); i++) {
            LinkedList<String> list = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {
                    for (String l : dp[j]) {
                        list.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));
                    }
                }
            }
            dp[i] = list;
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(wordBreak2("catsanddog",Arrays.asList("cat", "cats", "and", "sand", "dog")));
    }

}
