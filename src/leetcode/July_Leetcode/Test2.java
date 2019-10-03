package leetcode.July_Leetcode;

import java.util.Arrays;

/**
 * @author caoduanxi
 * @2019/7/1 21:15
 */
public class Test2 {
    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int x){
            this.val = x;
        }
    }
    public static int[] nextLargerNodes(ListNode head) {
        // 数组取出来
        int res[]=new int[10000];
        int len=0;
        while(head!=null){
            res[len++]=head.val;
            head=head.next;
        }
        // 构建一个新的数组
        int stack[]=new int[len];
        int top=-1,i=len-1;
        // 遍历
        for(;i>=0;i--){
            if(top==-1||res[i]<stack[top]){
                stack[++top]=res[i];
                res[i]=(top>0)?stack[top-1]:0;
            }
            else{
                while(res[i]>=stack[top]){
                    top--;
                    if(top==-1)break;
                }
                stack[++top]=res[i];
                res[i]=(top>0)?stack[top-1]:0;
            }
        }
        return Arrays.copyOf(res,len);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(3);
        int[] ints = nextLargerNodes(head);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
    }
    public static int[] nextLargerNodes1(ListNode head) {
        // TODO 还没看懂！
        int[] res = new int[10000];
        ListNode cur = head;
        int num = 0;
        while(cur != null){
            res[num++] = getMax(cur.next,cur.val);
            cur = cur.next;
        }
        return Arrays.copyOfRange(res,0,num);
    }

    public static int getMax(ListNode node, int value){
        int temp = 0;
        ListNode cur = node;

        while(cur != null){
            if(cur.val > value){
                temp = cur.val;
                break;
            }
            cur = cur.next;
        }
        return temp;
    }
}
