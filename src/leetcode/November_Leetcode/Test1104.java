package leetcode.November_Leetcode;

/**
 * @author caoduanxi
 * @2019/11/4 21:58
 */
public class Test1104 {
    // 需要获取环绕字符串的子串个数
    public int findSubstringInWraproundString1(String p) {
        if (p.length() == 0) return 0;
        if (p.length() == 1) return 1;
        int[] dp = new int[26];
        char[] chars = p.toCharArray();
        dp[chars[0] - 'a'] = 1;
        int last = 1;
        for (int i = 1; i < chars.length; i++) {
            // 这里对判断过的已经做了赋值
            if (dp[chars[i] - 'a'] == 0) {
                dp[chars[i] - 'a'] = 1;
            }
            int j = i - 1;
            // 判断是否在自己前面
            if ((chars[i] - chars[j] + 26) % 26 == 1) {
                // 这是判断前面一个数是不是接着连续的来的子串
                // 如果是的话，就接着前面的加一，否则只是总的+1
                if (1 + last > dp[chars[i] - 'a']) {
                    dp[chars[i] - 'a'] = last + 1;
                }
                last += 1;
                // 如果不在自己前面的话表示不能成立子串，last归1
            } else {
                last = 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += dp[i];
        }
        return res;
    }


    public static int findSubstringInWraproundString(String p) {
        if (p.length() == 0) return 0;
        if (p.length() == 1) return 1;
        int[] dp = new int[26];
        char[] chars = p.toCharArray();
        // 获取第一个值的位置，将其置为1
        dp[chars[0] - 'a'] = 1;
        // 作为判断每一个dp中个数的标准，至少是1，因为自己可以单独成立子串
        int last = 1;
        // 因为0已经用过，所以从1开始
        for (int i = 1; i < chars.length; i++) {
            // 首先需要做判断是否这个值为0
            if (dp[chars[i] - 'a'] == 0) {
                // 此时表示之前没有出现过。赋值1
                dp[chars[i] - 'a'] = 1;
            }
            // 如果出现过，则不赋值1
            // 此时需要寻找自己的前一个，判断自己的前一个是否为自己的相邻元素
            int j = i - 1;
            // 如果是自己的前一个
            if ((chars[i] - chars[j] + 26) % 26 == 1) {
                // 判断前面是否与前面的前面是连续的
                // 这里判断的意义是什么？？: 这里的意义是如果一个数是它之前的，但是出现过很多次，此时如果last还是1的话会丢失数据
                if (dp[chars[i] - 'a'] < last + 1) {
                    dp[chars[i] - 'a'] = last + 1;
                }
                last += 1;
            } else {
                // 如果不是自己的前一个，就赋值last为1
                last = 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += dp[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findSubstringInWraproundString("zab"));
    }
}
