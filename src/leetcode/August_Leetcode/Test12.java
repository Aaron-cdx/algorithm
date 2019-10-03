package leetcode.August_Leetcode;

/**
 * @author caoduanxi
 * @2019/8/14 22:05
 */
public class Test12 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;

        ListNode mid = findListNodeMid(head);

        TreeNode res = new TreeNode(mid.val);
        if(mid == head){
            return res;
        }
        res.left = sortedListToBST(head);
        res.right = sortedListToBST(mid.next);
        return res;
    }
    public ListNode findListNodeMid(ListNode head){
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(pre != null){
            pre.next = null;
        }
        return slow;
    }
    /*public ListNode reverseList(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }*/
}
