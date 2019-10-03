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
        ����һ��ͷ���Ϊ root ������, ��дһ�������Խ�����ָ�Ϊ k �������Ĳ��֡�
        ÿ���ֵĳ���Ӧ�þ����ܵ����: ���������ֵĳ��Ȳ�಻�ܳ��� 1��
        Ҳ����˵������Щ����Ϊ null
     */
    public ListNode[] splitListToParts(ListNode root, int k) {
        // 1 2 3 | 5  [[1],[2],[3],[],[]];
        ListNode[] head = new ListNode[k];
        // ��һ������������Ƿ����k�������ڣ����沿��ֱ����Ϊ0
        int cnt = 0;
        ListNode cur = root;
        while(cur != null){
            cnt += 1;
            cur = cur.next;
        }
        cur = root;
        // ����С�ڻ��ߵ���k�����
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
            // ���ȴ���k���������ʱ�漰������,���ȥ���飡��
            // ���ó���cnt/k=��ʼ������cnt/k=������ĸ���
            int initLen = cnt / k;
            int extraLen = cnt % k;
            int[] len = new int[k];
            // ����������ĳ��� ������ĳ��������Ϊ0���һ
            for (int i = 0; i < k; i++) {
                len[i] = extraLen-- > 0 ? initLen+1 : initLen;
            }
            // �����Ѿ�������� һ��Ҫ�ж�cur ��= null�����޷����У��ᱨ��ָ���쳣
            for (int i = 0; i < k && cur != null; i++) {
                head[i] = cur;
                // ��1��ʼ����Ϊcurһ��ʼ����1��λ�ã������0��������һ��
                for (int j = 0; j < len[i]-1; j++) {
                    cur = cur.next;
                 }
                // �ض�����
                ListNode temp = cur.next;
                cur.next = null;
                cur = temp;
            }
        }
        return head;
    }
}
