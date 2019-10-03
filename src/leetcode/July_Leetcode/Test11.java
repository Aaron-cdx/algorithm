package leetcode.July_Leetcode;

import java.util.Stack;

/**
 * @author caoduanxi
 * @2019/7/10 19:38
 */
public class Test11 {
    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int x){
            this.val = x;
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        ListNode test = deleteDuplicates(head);
        while(test != null){
            System.out.print(test.val+" ");
            test = test.next;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        if(head.next != null && head.val == head.next.val){
            while(head.next != null && head.val == head.next.val){
                head = head.next;
            }
            return deleteDuplicates(head.next);
        }else{
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummyNode = new ListNode(Integer.MAX_VALUE);
        dummyNode.next = head;
        ListNode res = dummyNode;
        ListNode cur = res.next;
        while(cur.next != null){
            if(cur.val == cur.next.val){
                ListNode temp = cur.next;
                if(temp.next != null){
                    while(temp.next != null && temp.val == temp.next.val){
                        temp = temp.next;
                    }
                }
                // 找到cur前一个节点
                while(res.next != cur){
                    res = res.next;
                }
                // 此时交换位置
                res.next = temp.next;
                temp.next = null;
                res = dummyNode;
                cur = res.next;
                if(cur == null){
                    break;
                }
            }else{
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }
    public static ListNode deleteDuplicates1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        ListNode cur = head;
        while(cur != null){
            if(stack.isEmpty()){
                stack.push(cur);
            }else{
                if(stack.peek().val == cur.val){
                    stack.pop();
//                    cur = cur.next;
                }else{
                    stack.push(cur);
                }
            }
            cur = cur.next;
        }
        // stack中装满了所有的非重复节点
        ListNode res = null;
        while(!stack.isEmpty()){
            res = stack.pop();
            res = res.next;
        }

        ListNode pre = null;
        while(res != null){
            ListNode temp = res.next;
            res.next = pre;
            pre = res;
            res = temp;
        }
        return pre;
    }
}
