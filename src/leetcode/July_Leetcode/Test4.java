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
                // һֱ���������Ļ����ͼ�һ
                // ����һֱ�����Ļ���Ҳ��ȡ����������
                // ÿ��ͣ�ٱؼ�һ
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
        // Ҫ������G�е�����������������ɼ������
        // 1 2 3 4 | [0 1 3] 2
        // 0 1 2 | [0 2] 2
        ListNode cur = head;
        // ���ȥ���������
        Arrays.sort(G);
        int res = 0;// ������һ��
        while(cur.next != null){
            // �Լ�������һ��Ҳ���ڣ�����
            if(isTrue(cur.val,G) && isTrue(cur.next.val, G)){
                cur = cur.next;
                // �Լ����ڣ���һ�������ڣ�+1
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
