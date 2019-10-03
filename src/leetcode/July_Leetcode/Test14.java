package leetcode.July_Leetcode;

/**
 * @author caoduanxi
 * @2019/7/11 21:52
 */
public class Test14 {

    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int x){
            this.val = x;
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(12);
        head.next.next.next.next.next.next = new ListNode(5);
//        ListNode[] head = new ListNode[5];
//        head[0] = new ListNode(4);
//        head[1] = new ListNode(3);
//        head[2] = new ListNode(7);
//        head[3] = new ListNode(1);
//        head[4] = new ListNode(2);

        ListNode test = mergeSort1(head);
        while(test != null){
            System.out.print(test.val+" ");
            test = test.next;
        }
    }

//    public static ListNode mergeSort(ListNode head){
//        if(head == null || head.next == null) return head;
//
//        return mergeSort1(head);
//
//    }

    public static ListNode mergeSort1(ListNode head){
        if(head == null || head.next == null) return head;
        // 找到终点
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow在中点处
        ListNode right = mergeSort1(slow.next);
        slow.next = null;// 因为slow永远是中点
        ListNode left = mergeSort1(head);
        return merge(left, right);
    }
    public static ListNode merge(ListNode left, ListNode right){
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        while(left != null && right != null) {
            if(left.val > right.val){
                cur.next = right;
                right = right.next;
            }else{
                cur.next = left;
                left = left.next;
            }
            cur = cur.next;
        }

        cur.next = left == null ? right : left;
        return dummyNode.next;
    }
}
