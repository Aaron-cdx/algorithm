package leetcode.July_Leetcode;

/**
 * @author caoduanxi
 * @2019/7/8 19:55
 */
public class Test9 {
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

        ListNode test = reverseKGroup(head,2);
        while(test != null){
            System.out.print(test.val+" ");
            test = test.next;
        }
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        // �жϱ߽磬���headΪ�ջ���ֻ��һ��Ԫ�ػ���kΪ1��ֱ�ӷ���
        if(head == null || head.next == null || k==1) return head;
        // ����dummyNode,��������ת
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode res = dummyNode;
        // ������ٸ��ڵ�
        ListNode cur = head;
        int num = 0;
        while(cur != null){
            num += 1;
            cur = cur.next;
        }
        int cnt = num / k; // ��ת����
        // ������ת�Ľڵ�
        ListNode p1 = res.next;
        ListNode p2 = p1.next;
        int temp = k;
        while(cnt-- > 0){
            // ����Ĳ���
            while(--temp > 0){
                p1.next = p2.next;
                p2.next = res.next;
                res.next = p2;
                p2 = p1.next;
            }
            res = p1;
            // �����ת��ֱ�ӵ���ĩβ����break����
            if(p1.next == null){
                break;
            }else {
                // �����������Ϊ��һ���㣬���ڲ����µĽڵ�����֮��
                p1 = p1.next;
                p2 = p1.next;
                // temp����Ҫ����k��ע�⻹ԭ
                temp = k;
            }
        }
        // ���ؽ��
        return dummyNode.next;
    }
}
