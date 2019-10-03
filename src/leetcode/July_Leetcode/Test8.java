package leetcode.July_Leetcode;

/**
 * @author caoduanxi
 * @2019/7/7 19:35
 */

/**
 * ��ת����--������λ
 */
public class Test8 {
    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int x){
            this.val = x;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode test = rotateRight(head,3);
        while(test != null){
            System.out.print(test.val+" ");
            test = test.next;
        }
    }

    public static ListNode test(ListNode head){
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        ListNode res = head;
        while(res.next.next != null){
            res = res.next;
        }
        ListNode p1 = res;
        ListNode p2 = p1.next;
        p1.next = p2.next;
        p2.next = cur.next;
        cur.next = p2;
        return dummyNode.next;
    }
    public static ListNode rotateRight2(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        // ����ָ����
        ListNode fast = head, slow = head, cur = head;
        // ͳ�Ƹ���
        int len = 0;
        while(cur != null){
            cur = cur.next;
            len++;
        }
        // ������Ҫ�ƶ���λ��
        k = k % len;

        // ˵���׾����ҵ�K��֮�����ͷ����ǰһ���ڵ㼴��
        // ����slow��fast֮����k���ڵ�����
        while(k > 0){
            fast = fast.next;
            if(fast == null)
                fast = head;
            k--;
        }

        // ������Ѱ���µ�β�ڵ�
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        // ���slow��fastͬʱ����β������k�൱��û�仯��ֱ�ӷ���head
        if(slow.next == null)
            return head;
        // ��һ��ƴ��1 2 3 4 5
        // fast��5����slow��3����
        // ƴ������
        ListNode oldTail = fast, tail = slow, newHead = tail.next;
        tail.next = null;
        oldTail.next = head;

        return newHead;
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        ListNode res = head;
        int num = 0;
        while(res.next.next != null){
            num += 1;
            res = res.next;
        }
        num += 2;// ���Ϊ��ʱ�����������ڵ����

        // 0 1 2 3 4 5 �����ƶ����ٴΣ�����һֱ����0�������
        // ��Զ��֤���һ���ڵ�һֱ����ǰ�壡����һֱ��ǰ��
        ListNode p1 = res;
        ListNode p2 = p1.next;
        int n = k%num;
        while(n-- > 0){
            p1.next = p2.next;
            p2.next = cur.next;
            cur.next = p2;
            while(p2.next != p1){
                p2 = p2.next;
            }
            p1 = p2;
            p2 = p2.next;
        }
        return dummyNode.next;
    }
}
