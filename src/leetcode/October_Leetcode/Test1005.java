package leetcode.October_Leetcode;

/**
 * @author caoduanxi
 * @2019/10/5 18:02
 */
public class Test1005 {
    // ����
    // ������ķǿ��ַ�����һ������Ĳ���
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
        // ��λ�ȡ�ܵĴ���
        // ���С��26��Ԥ�ȶ���õ�ֱ�����
        if(parseInt <= 26){
            res = dp[parseInt];
            return res;
            // �������26����ʱ��Ҫ�жϵ����Ƕ��
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
     * ��ȡnumΪ��λ��
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

    // ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(n)
    public static int numDecodings(String s) {
        int len = s.length();
        if(len == 0) return 0;

        int[] dp = new int[len+1];
        // ���һ������Ϊ1
        dp[len] = 1;
        // ����ǵ����ڶ�����Ϊ0�����ã���Ϊ0����Ϊ1
        dp[len - 1] = s.charAt(len-1) != '0' ? 1 : 0;
        // �Ӻ���ǰ���㣬�������еĽ�����ܵ���һ��dp[0]��
        for (int i = len - 2; i >= 0; i--) {
            // ���Ϊ0������ǰһ��
            if(s.charAt(i) == '0') continue;
            // �����Ϊ0�Ļ����жϺ�����λ�Ƿ���26��Χ֮�ڣ��ڵĻ������ֱ���ӣ�����ȡ����һ�����
            else dp[i] = (Integer.parseInt(s.substring(i,i+2)) <= 26) ? dp[i+1]+dp[i+2] : dp[i+1];
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("256"));
    }
}
