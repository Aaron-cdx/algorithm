package leetcode.Septmber_Leetcode;

/**
 * @author caoduanxi
 * @2019/9/24 18:34
 */
public class Test24 {
    // 判断是否是子序列
    public boolean isSubsequence1(String s, String t) {
        if (s.length() == 0 || s == null) return false;
        char[] chars = s.toCharArray();
        char[] array = t.toCharArray();
        int a = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == chars[a]) {
                a++;
            }
            if (a == chars.length) return true;
        }
        return false;
    }

    // 贪心算法，无效性，只关注当前的值，局部最优解
    public boolean isSubsequence2(String s, String t) {
        String str = t;
        boolean flag = true;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int idx = str.indexOf(chars[i]);
            if (idx > -1) {
                str = str.substring(idx + 1);
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    // 变身的代码
    /*int index = -1;
        for (char c : s.toCharArray()){
        index = t.indexOf(c, index+1);
        if (index == -1) return false;
    }
        return true;*/
    // 动态规划
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (t.length() == 0) return false;

        int len = s.length();
        int[] data = new int[t.length()];
        // 需要给第一个值赋初值
        data[0] = s.charAt(0) == t.charAt(0) ? 1 : 0;
        for (int i = 1; i < t.length(); i++) {
            // 这里主要是防止如果不等的情况发生，所以比较两次
            // 这里的data[i-1]可以获取到s的下标值，而且一直动态的向后递增
            if (s.charAt(data[i - 1]) == t.charAt(i)) {
                data[i] = data[i - 1] + 1;
                if (data[i] == len) return true;
            } else {
                data[i] = data[i - 1];
            }
        }
        return false;
    }
}
