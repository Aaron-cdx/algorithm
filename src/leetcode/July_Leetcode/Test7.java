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
        // 道理都懂就是翻译不成代码 图没画全，指针可以进两个，但是出只能出一个，而且后出的会覆盖之前的。
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;

        for(int i=0; i < m-1; i++) pre = pre.next;// 确定第一个节点

        ListNode node = null;
        ListNode cur = pre.next;
        // 直接反转
        for (int i = 0; i < n-m+1 ; i++) {
            ListNode temp = cur.next;
            cur.next = node;
            node = cur;
            cur = temp;
        }
        // 1-> 2 <- 3 <- 4 -> 5 链表连接！
        pre.next.next = cur;
        pre.next = node;

        return dummyNode.next;
    }
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        // 1 2 3 4 5 插在1 2之间
        // 1 3 2 4 5 插在1 3之间
        // 1 4 3 2 5 结束
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for(int i=0; i < m-1; i++) pre = pre.next;// 第一个指针
        ListNode p1 = pre.next;
        ListNode p2 = p1.next;
        for(int i=0; i< n-m; i++){
            p1.next = p2.next;
            p2.next = pre.next;// 用pre是因为pre是恒定不变的，只有用pre才能保证一定是插在这个位置上
            pre.next = p2;
            p2 = p1.next;
        }
        return dummyNode.next;
    }
}
