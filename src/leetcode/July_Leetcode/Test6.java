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
        // 不需要排序！！！
        // 两个链，一个链表连接小于3
        ListNode dummyNode1 = new ListNode(0);
        ListNode p1 = dummyNode1;
        // 一个链表连接大于等于3
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
        // 组合起来就好
        p2.next = null;
        p1.next = dummyNode2.next;

        return dummyNode1.next;
    }
    public ListNode partition1(ListNode head, int x) {
        // 使得所有小于 x 的节点都在大于或等于 x 的节点之前
        ListNode p1 = head;
        while(p1 != null){
            if(p1.val == x) break;
        }
        ListNode p2 = p1.next;
        p1.next = null;
        p1 = head;
        // 1 4 3 2 5 2 |-> 1 4 3 | 2 5 2
        // 现在是组合问题 只要判断后面的大的不动就行
        while(p2 != null){
            if(p2.val >= x){
                p2 = p2.next;
            }else{
                // 比较组合
                if(p1.val <= p2.val){
                    ListNode temp1 = p1.next;
                    ListNode temp2 = p2.next;

                    p1.next = p2;
                    p2.next = p1;

                    p1 = temp1;
                    p2 = temp2;
                    // 大于p1.val > p2.val
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
        // 理想总是很丰满，现实很骨感！
        // 最后注意要把head拼起来！
        return head;
    }
}
