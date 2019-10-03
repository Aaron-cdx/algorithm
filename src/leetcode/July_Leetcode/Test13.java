package leetcode.July_Leetcode;

/**
 * @author caoduanxi
 * @2019/7/11 21:35
 */
public class Test13 {

    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int x){
            this.val = x;
        }
    }
    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(1);
//        head.next.next = new ListNode(1);
//        head.next.next.next = new ListNode(3);
//        head.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next.next = new ListNode(5);
        ListNode[] head = new ListNode[5];
        head[0] = new ListNode(4);
        head[1] = new ListNode(3);
        head[2] = new ListNode(7);
        head[3] = new ListNode(1);
        head[4] = new ListNode(2);

        ListNode test = mergeSort(head);
        while(test != null){
            System.out.print(test.val+" ");
            test = test.next;
        }
    }
    // 使用归并排序对链表进行排序
    public static ListNode mergeSort(ListNode[] head){
        if(head == null || head.length == 0) return null;
        return mergeSort(head,0,head.length - 1);
    }

    public static ListNode mergeSort(ListNode[] head, int left, int right){
        if(left == right){
            return head[left];
        }
        int m = left + (right - left)/2;

        ListNode l1 = mergeSort(head,left,m);
        ListNode l2 = mergeSort(head,m+1,right);

        return merge(l1,l2);
    }

    public static ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = merge(l1.next,l2);
            return l1;
        }else{
            l2.next = merge(l2.next,l1);
            return l2;
        }
    }
}
