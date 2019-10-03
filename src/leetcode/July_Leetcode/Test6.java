package leetcode.July_Leetcode;

/**
 * @author caoduanxi
 * @2019/7/5 20:39
 */
public class Test6 {
    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int x){
            this.val = x;
        }
    }
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        // ����Ҫ���򣡣���
        // ��������һ����������С��3
        ListNode dummyNode1 = new ListNode(0);
        ListNode p1 = dummyNode1;
        // һ���������Ӵ��ڵ���3
        ListNode dummyNode2 = new ListNode(0);
        ListNode p2 = dummyNode2;
        ListNode cur = head;

        while(cur != null){
            if(cur.val < x){
                p1.next = cur;
                p1 = p1.next;
            }else{
                p2.next = cur;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        // ��������ͺ�
        p2.next = null;
        p1.next = dummyNode2.next;

        return dummyNode1.next;
    }
    public ListNode partition1(ListNode head, int x) {
        // ʹ������С�� x �Ľڵ㶼�ڴ��ڻ���� x �Ľڵ�֮ǰ
        ListNode p1 = head;
        while(p1 != null){
            if(p1.val == x) break;
        }
        ListNode p2 = p1.next;
        p1.next = null;
        p1 = head;
        // 1 4 3 2 5 2 |-> 1 4 3 | 2 5 2
        // ������������� ֻҪ�жϺ���Ĵ�Ĳ�������
        while(p2 != null){
            if(p2.val >= x){
                p2 = p2.next;
            }else{
                // �Ƚ����
                if(p1.val <= p2.val){
                    ListNode temp1 = p1.next;
                    ListNode temp2 = p2.next;

                    p1.next = p2;
                    p2.next = p1;

                    p1 = temp1;
                    p2 = temp2;
                    // ����p1.val > p2.val
                }else{
                    ListNode temp1 = p2.next;
                    ListNode temp2 = p1.next;

                    p2.next = p1;
                    p1.next = p2;

                    p2 = temp2;
                    p1 = temp1;
                }
            }
        }
        // �������Ǻܷ�������ʵ�ܹǸУ�
        // ���ע��Ҫ��headƴ������
        return head;
    }
}
