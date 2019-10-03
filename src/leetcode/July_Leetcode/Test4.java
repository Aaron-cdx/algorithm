package leetcode.July_Leetcode;

import java.util.Arrays;

/**
 * @author caoduanxi
 * @2019/7/3 20:34
 */
public class Test4 {
    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int x){
            this.val = x;
        }
    }
    public int numComponents(ListNode head, int[] G) {
        int num = 0;
        boolean[] A = new boolean[10000];
        for (int i : G) {
            A[i] = true;
        }
        ListNode cur = head;
        while(cur != null){
            if(A[cur.val]){
                // 一直遍历到最后的话，就加一
                // 不是一直到最后的话，也是取的最长的组件。
                // 每次停顿必加一
                while(cur.next != null && A[cur.next.val]){
                    cur = cur.next;
                }
                num ++;
            }
            cur = cur.next;
        }
        return num;
    }
    public int numComponents1(ListNode head, int[] G) {
        // 要求解的是G中的数字在链表中能组成几个组件
        // 1 2 3 4 | [0 1 3] 2
        // 0 1 2 | [0 2] 2
        ListNode cur = head;
        // 如何去组成这个组件
        Arrays.sort(G);
        int res = 0;// 至少是一个
        while(cur.next != null){
            // 自己存在下一个也存在，继续
            if(isTrue(cur.val,G) && isTrue(cur.next.val, G)){
                cur = cur.next;
                // 自己存在，下一个不存在，+1
            }else if(isTrue(cur.val,G) && !isTrue(cur.next.val, G)){
                res += 1;
                cur = cur.next;
            }else if(!isTrue(cur.val,G) && isTrue(cur.next.val, G)){
                res += 1;
                cur = cur.next;
            }
        }
        return res;
    }
    public boolean isTrue(int num, int[] G){
        for (int i = 0; i < G.length; i++) {
            if(num == G[i]) return true;
        }
        return false;
    }
}
