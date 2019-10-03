package leetcode.July_Leetcode;

/**
 * @author caoduanxi
 * @2019/7/5 21:31
 */
public class Test7 {
    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int x){
            this.val = x;
        }
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // ���������Ƿ��벻�ɴ��� ͼû��ȫ��ָ����Խ����������ǳ�ֻ�ܳ�һ�������Һ���ĻḲ��֮ǰ�ġ�
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;

        for(int i=0; i < m-1; i++) pre = pre.next;// ȷ����һ���ڵ�

        ListNode node = null;
        ListNode cur = pre.next;
        // ֱ�ӷ�ת
        for (int i = 0; i < n-m+1 ; i++) {
            ListNode temp = cur.next;
            cur.next = node;
            node = cur;
            cur = temp;
        }
        // 1-> 2 <- 3 <- 4 -> 5 �������ӣ�
        pre.next.next = cur;
        pre.next = node;

        return dummyNode.next;
    }
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        // 1 2 3 4 5 ����1 2֮��
        // 1 3 2 4 5 ����1 3֮��
        // 1 4 3 2 5 ����
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for(int i=0; i < m-1; i++) pre = pre.next;// ��һ��ָ��
        ListNode p1 = pre.next;
        ListNode p2 = p1.next;
        for(int i=0; i< n-m; i++){
            p1.next = p2.next;
            p2.next = pre.next;// ��pre����Ϊpre�Ǻ㶨����ģ�ֻ����pre���ܱ�֤һ���ǲ������λ����
            pre.next = p2;
            p2 = p1.next;
        }
        return dummyNode.next;
    }
}
