package leetcode.October_Leetcode;

/**
 * @author caoduanxi
 * @2019/10/7 20:11
 */
public class Test1007 {
    // 版本比较version1 version2  大于：1 小于：-1 等于：0
    public static int compareVersion1(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        // 使用双指针来做
        int a = 0;
        int b = 0;
        while(a < split1.length && b < split2.length){
            if(Integer.parseInt(split1[a]) == 0){
                if(Integer.parseInt(split2[b]) == 0){
                    a++;
                    b++;
                    continue;
                }else{
                    return -1;
                }
            }
            if(Integer.parseInt(split2[b]) == 0){
                if(Integer.parseInt(split1[a]) == 0){
                    a++;
                    b++;
                    continue;
                }else{
                    return 1;
                }
            }
            if(Integer.parseInt(split1[a]) == Integer.parseInt(split2[b])){
                a++;
                b++;
                continue;
            }
            if(Integer.parseInt(split1[a]) > Integer.parseInt(split2[b])){
                return 1;
            }
            if(Integer.parseInt(split1[a]) < Integer.parseInt(split2[b])){
                return -1;
            }
        }
        while(a < split1.length){
            if(Integer.parseInt(split1[a++]) != 0){
                return 1;
            }
        }
        while(b < split2.length){
            if(Integer.parseInt(split2[b++]) != 0){
                return -1;
            }
        }
        return 0;
    }
    // 时间复杂度O(n) 空间复杂度O(n)
    public static int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int len = Math.max(split1.length,split2.length);
        for (int i = 0; i < len; i++) {
            // 长度短的直接补0比较即可，不用去除
            int i1 = i < split1.length ? Integer.parseInt(split1[i]) : 0;
            int i2 = i < split2.length ? Integer.parseInt(split2[i]) : 0;
            if(i1 == i2) continue;
            if(i1 < i2){
                return -1;
            }else return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(compareVersion("0.1","1.1"));
    }
}
