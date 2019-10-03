package leetcode.July_Leetcode;

/**
 * @author caoduanxi
 * @2019/7/7 19:35
 */

/**
 * 旋转链表--链表移位
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
        // 快慢指针解决
        ListNode fast = head, slow = head, cur = head;
        // 统计个数
        int len = 0;
        while(cur != null){
            cur = cur.next;
            len++;
        }
        // 真正需要移动的位数
        k = k % len;

        // 说到底就是找到K次之后的新头结点的前一个节点即可
        // 利用slow和fast之间差距k个节点来的
        while(k > 0){
            fast = fast.next;
            if(fast == null)
                fast = head;
            k--;
        }

        // 这是在寻找新的尾节点
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        // 如果slow和fast同时到达尾部，则k相当于没变化，直接返回head
        if(slow.next == null)
            return head;
        // 做一个拼接1 2 3 4 5
        // fast在5处，slow在3处，
        // 拼接起来
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
        num += 2;// 最后为空时，后面两个节点加入

        // 0 1 2 3 4 5 无论移动多少次，都是一直在往0后面插入
        // 永远保证最后一个节点一直在往前插！必须一直往前进
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
