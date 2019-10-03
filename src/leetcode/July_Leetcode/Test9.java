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
        // 判断边界，如果head为空或者只有一个元素或者k为1则直接返回
        if(head == null || head.next == null || k==1) return head;
        // 设置dummyNode,用于链表翻转
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode res = dummyNode;
        // 计算多少个节点
        ListNode cur = head;
        int num = 0;
        while(cur != null){
            num += 1;
            cur = cur.next;
        }
        int cnt = num / k; // 翻转几次
        // 用作翻转的节点
        ListNode p1 = res.next;
        ListNode p2 = p1.next;
        int temp = k;
        while(cnt-- > 0){
            // 链表的插入
            while(--temp > 0){
                p1.next = p2.next;
                p2.next = res.next;
                res.next = p2;
                p2 = p1.next;
            }
            res = p1;
            // 如果翻转完直接到了末尾，则break结束
            if(p1.next == null){
                break;
            }else {
                // 否则将这个点作为第一个点，用于插入新的节点在其之间
                p1 = p1.next;
                p2 = p1.next;
                // temp还是要等于k，注意还原
                temp = k;
            }
        }
        // 返回结果
        return dummyNode.next;
    }
}
