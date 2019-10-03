package leetcode.July_Leetcode;

import java.util.Stack;

/**
 * @author caoduanxi
 * @2019/7/1 19:54
 */
public class Test1 {
    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int x){
            this.val = x;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(4);
//        head.next.next.next = new ListNode(3);

        ListNode head1 = new ListNode(5);
//        head1.next = new ListNode(6);
//        head1.next.next = new ListNode(4);

        ListNode listNode = addTwoNumbers(head,head1);
        while(listNode != null){
            System.out.print(listNode.val+"-");
            listNode = listNode.next;
        }


    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        ListNode node1 = l1;
        ListNode node2 = l2;
        while(node1 != null){
            stack1.push(node1.val);
            node1 = node1.next;
        }
        while(node2 != null){
            stack2.push(node2.val);
            node2 = node2.next;
        }

        int flag = 0;
        ListNode head = null;
        while(!stack1.isEmpty() || !stack2.isEmpty() || flag != 0){
            int value = 0;
            if(!stack1.isEmpty()){
                value += stack1.pop();
            }
            if(!stack2.isEmpty()){
                value += stack2.pop();
            }
            value += flag;
            // 构建一个新的链表结构 这里做了一个逆序的动作
            ListNode node = new ListNode(value%10);
            flag = value / 10;
            node.next = head;
            head = node;
        }
        return head;
    }
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        // 先用翻转来写
        ListNode listNode1 = l1.next == null ? l1 : reverseListNode(l1);
        ListNode listNode2 = l2.next == null ? l2 : reverseListNode(l2);

        ListNode node1 = listNode1;
        ListNode node2 = listNode2;

        int carry = 0;
        int value;
        boolean flag1 = false;
        boolean flag2 = false;
        while(node1 != null && node2 != null){
            value = node1.val + node2.val;
            node1.val = (value % 10)+carry;
            node2.val = (value % 10)+carry;
            carry = value/10;

            node1 = node1.next;
            node2 = node2.next;
        }
        while(node1 != null){
            flag1 = true;
            value = node1.val;
            node1.val = ((value % 10)+carry);
            carry = value/10;

            node1 = node1.next;
        }
        while(node2 != null){
            flag2 = true;
            value = node2.val;
            node2.val = (value % 10)+carry;
            carry = value/10;

            node2 = node2.next;
        }
        if(carry != 0){
            if(flag1){
                node2.val = carry;
                node2.next = null;
                return reverseListNode(listNode1);
            }else{
                node2.val = carry;//
                node2.next = null;
                return reverseListNode(listNode2);
            }
        }else{
            if(flag1){
                return reverseListNode(listNode1);
            }else{
                return reverseListNode(listNode2);
            }
        }
    }
    // 链表翻转
    public static ListNode reverseListNode(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
