package leetcode.July_Leetcode;

/**
 * @author caoduanxi
 * @2019/7/3 22:18
 */
public class Test5 {
    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int x){
            this.val = x;
        }
    }
    public ListNode[] splitListToParts1(ListNode root, int k) {
        int n = 0;
        ListNode cur = root;
        while(cur != null){
            n++;
            cur = cur.next;
        }
        int mod = n % k;
        int size = n / k;
        ListNode [] res = new ListNode[k];
        cur  = root;
        for (int i = 0; i < k && cur != null; i++){
            res[i] = cur;
            int cursize = size + (mod-- > 0 ? 1 : 0);
            for (int j = 0; j < cursize - 1; j++){
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return res;
    }
    /*
        给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
        每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，
        也就是说可能有些部分为 null
     */
    public ListNode[] splitListToParts(ListNode root, int k) {
        // 1 2 3 | 5  [[1],[2],[3],[],[]];
        ListNode[] head = new ListNode[k];
        // 第一遍遍历看长度是否大于k，不大于，后面部分直接置为0
        int cnt = 0;
        ListNode cur = root;
        while(cur != null){
            cnt += 1;
            cur = cur.next;
        }
        cur = root;
        // 长度小于或者等于k的情况
        if(cnt <= k){
            for (int i = 0; i < k; i++) {
                if(cur != null){
                    head[i] = new ListNode(cur.val);
                    cur = cur.next;
                }else {
                    head[i] = null;
                }
            }
        }else{
            // 长度大于k的情况，此时涉及到分组,如何去分组！！
            // 先用长度cnt/k=初始个数，cnt/k=多出来的个数
            int initLen = cnt / k;
            int extraLen = cnt % k;
            int[] len = new int[k];
            // 分配最基本的长度 多出来的长度如果不为0则加一
            for (int i = 0; i < k; i++) {
                len[i] = extraLen-- > 0 ? initLen+1 : initLen;
            }
            // 数组已经分配好了 一定要判断cur ！= null否则无法进行，会报空指针异常
            for (int i = 0; i < k && cur != null; i++) {
                head[i] = cur;
                // 从1开始是因为cur一开始就在1的位置，如果从0链表会多走一步
                for (int j = 0; j < len[i]-1; j++) {
                    cur = cur.next;
                 }
                // 截断链表
                ListNode temp = cur.next;
                cur.next = null;
                cur = temp;
            }
        }
        return head;
    }
}
