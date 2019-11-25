package leetcode.October_Leetcode;

import java.util.Arrays;

/**
 * @author caoduanxi
 * @2019/10/26 22:31
 */
public class Test1027 {
    public int guessNumber(int n) {
        // -1表示比较小 0相等 1表示比较大
        int begin = 1;
        int end = n;
        while (begin <= end) {
            // 二分查找法的终点为low + (high - low)/2
            // 这叫从起点+终点到起点总和的一半就是中点
            int mid = begin + (end - begin) / 2;
            int num = guess(mid);
            if (num == 0) {
                return mid;
            } else if (num == -1) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    //    public int guessNum(int[] arr, int start,int end,int pre){
//        for (int i = start; i <= end; i++) {
//            int num = guess(arr[i]);
//            // 猜中了
//            if(num == 0){
//                return num;
//                // 猜小了
//            }else if(num == -1){
//                return guessNum(arr,(i+end)/2,end,start);
//                // 猜大了
//            }else{
//                return guessNum(arr,pre,i,end);
//            }
//        }
//        return 0;
//    }
    public int getMoneyAmount(int n) {
        int money = 0;
        int begin = 1;
        int end = n;

        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            if(guess(mid) == 0){
                return money;
            }else if(guess(mid) < 0){
                money += mid;
                end = mid - 1;
            }else{
                money += mid;
                begin = mid +1;
            }
        }
        return 0;
    }

    public int guess(int num) {
        int n = 10;
        if (num > n) {
            return 1;
        } else if (num < n) {
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
