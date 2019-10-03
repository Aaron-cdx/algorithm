package leetcode.July_Leetcode;

/**
 * @author caoduanxi
 * @2019/7/9 20:26
 */
public class Test10 {
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

        ListNode test = removeNthFromEnd(head,5);
        while(test != null){
            System.out.print(test.val+" ");
            test = test.next;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        // 可以采用反转然后再删除
        ListNode cur = head;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode res = dummyNode;
        // 计算节点个数
        int cnt = 1;// 包括人为构造的头结点
        while(cur != null){
            cnt += 1;
            cur = cur.next;
        }

        int num = 0;// 计数到达第几个就停止
        while(res != null){
            num += 1;
            if (num == cnt - n){
                // 删除节点
                ListNode temp = res.next;
                res.next = res.next.next;
                temp.next = null;
                break;
            }else {
                res = res.next;
            }
        }
        return dummyNode.next;
    }
}
