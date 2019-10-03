package leetcode.July_Leetcode;

import java.util.*;

/**
 * @author caoduanxi
 * @2019/7/11 20:33
 */
public class Test12 {
    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int x){
            this.val = x;
        }
    }
    public ListNode mergeKLists1(ListNode[] lists) {
        // N个有序链表排序
        // 暴力法
        List<Integer> res = new ArrayList<>();
        for (ListNode list : lists) {
            while(list != null){
                res.add(list.val);
                list = list.next;
            }
        }
        // 取出来排序
        Collections.sort(res);
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        // 重整链表
        for (int i = 0; i < res.size(); i++) {
            cur.next = new ListNode(res.get(i));
            cur = cur.next;
        }
        return dummyNode.next;
    }


    public ListNode mergeKLists(ListNode[] lists) {
        // 使用归并排序
        if (lists == null || lists.length == 0) return lists[0];

        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] list, int left, int right){
        // 归并
        if(left == right) return list[left];
        int m = left + (right - left)/2;

        ListNode l1 = merge(list,left,m);
        ListNode l2 = merge(list,m+1,right);

        return mergeListNode(l1,l2);
    }

    public static ListNode mergeListNode(ListNode l1, ListNode l2){
        // 递归方式
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeListNode(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeListNode(l2.next,l1);
            return l2;
        }
    }
}
