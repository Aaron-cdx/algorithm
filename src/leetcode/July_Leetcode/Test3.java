package leetcode.July_Leetcode;

/**
 * @author caoduanxi
 * @2019/7/2 20:19
 */
public class Test3 {
    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int x){
            this.val = x;
        }
    }
    public void reorderList(ListNode head) {
        // 至少三个节点
        if(head == null || head.next == null) return;
        // 链表排序 1 2 3 4 | 1 4 2 3
        // L0 Ln L1 Ln-1 ......
        // 使用快慢指针算出终点
       ListNode fast = head;
       ListNode slow = head;
       while(fast.next != null && fast.next.next != null){
           fast = fast.next.next;
           slow = slow.next;
       }
       // slow到了中点
       fast = slow.next;
       slow.next = null;
       // 指向头部
       slow = head;

       // 链表翻转
        ListNode next2;
        ListNode head2 = fast;
        while(fast.next != null){
            next2 = fast.next;
            fast.next = next2.next;
            next2.next = head2;
            head2 = next2;
        }
        fast = head2;

        ListNode next1;
        while(fast != null){
            next1 = slow.next;
            next2 = fast.next;

            slow.next = fast;
            fast.next = next1;

            fast = next2;
            slow = next1;
        }
    }
}
