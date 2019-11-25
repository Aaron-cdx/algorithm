package leetcode.October_Leetcode;

/**
 * @author caoduanxi
 * @2019/10/5 18:02
 */
public class Test1005 {
    // 解码
    // 将输入的非空字符串做一个解码的操作
    // 12  -> 1 2 AB | 12 L
    // 226 -> 2 2 6 ABF | 22 6 VF | 2 26 BZ
    public static int numDecodings1(String s) {
        int len = s.length();
        int[] dp = new int[27];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            if(i%10 == 0 || i<10){
                dp[i] = 1;
            }else{
                dp[i] = 2;
            }
        }
        int parseInt = Integer.parseInt(s);
        int res = 0;
        // 如何获取总的次数
        // 如果小于26，预先定义好的直接输出
        if(parseInt <= 26){
            res = dp[parseInt];
            return res;
            // 如果大于26，此时需要判断到底是多大
        }else{
            int bit = getBit(parseInt);
            for (int i = 0; i < bit - 1; i++) {
                String substring = s.substring(i, i + 2);
                int temp = Integer.parseInt(substring);
                if(temp <= 26){
                    res += dp[temp];
                }else{
                    for (int j = 0; j < 2; j++) {
                        res += dp[substring.charAt(j)-'0'];
                    }
                }
            }
        }
        return res;
    }


    /**
     * 获取num为几位数
     * @param num
     * @return
     */
    public static int getBit(int num){
        int count = 0;
        while(num != 0){
            count += 1;
            num /= 10;
        }
        return count;
    }

    // 时间复杂度O(n) 空间复杂度O(n)
    public static int numDecodings(String s) {
        int len = s.length();
        if(len == 0) return 0;

        int[] dp = new int[len+1];
        // 最后一个设置为1
        dp[len] = 1;
        // 如果是倒数第二个，为0则不设置，不为0设置为1
        dp[len - 1] = s.charAt(len-1) != '0' ? 1 : 0;
        // 从后向前计算，计算所有的结果归总到第一个dp[0]中
        for (int i = len - 2; i >= 0; i--) {
            // 如果为0，继续前一个
            if(s.charAt(i) == '0') continue;
            // 如果不为0的话，判断后面两位是否在26范围之内，在的话两个分别相加，否则取后面一个结果
            else dp[i] = (Integer.parseInt(s.substring(i,i+2)) <= 26) ? dp[i+1]+dp[i+2] : dp[i+1];
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("256"));
    }
}
