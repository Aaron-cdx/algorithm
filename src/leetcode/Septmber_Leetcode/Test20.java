package leetcode.Septmber_Leetcode;

/**
 * @author caoduanxi
 * @2019/9/19 19:38
 */
public class Test20 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    /**
     * ��֪ǰ������Ľ��Ϊ��->��->�ң�����ֻҪ֪��ÿ��������������Ԫ�ص���ʼ��Χ�Ϳ��Թ̶�������
     * <p>
     * ��1-2--3--4-5--6--7����֪1Ϊ���ڵ㣬�ӽڵ����Ϊ1����Ϊ2��5����ȶ�Ϊ1��������������Ԫ��Ϊ[2--3--4]��
     * �������ķ�Χ��[5--6--7]������������[2--3--4]�����ڵ�Ϊ[2]���ӽڵ����Ϊ2���������������ֱ�Ϊ[3][4]��
     * <p>
     * �������ǿ��Ը��ݵ�ǰ�ڵ����ڵ�������ҳ���ǰ���ڵ������������Χ��
     * ������ڵ�Ϊ1ʱ�����Ϊ1��������λ��Ϊ0���������ĸ��ڵ����ʼλ��Ϊ2��
     * <p>
     * ��չ��ͨ������������ڵ����һλ��������Ϊlo��
     * ���Ϊdepth(��1��ʼ)�����������ĸ��ڵ������λ��Ϊlo+1+depth��
     * �����������ڵ㿪ʼ�����������������ĸ��ڵ㣬��ǰ����depth��'-'�����֣�����λ��Ϊstart��
     * <p>
     * ����Ҫע��һ�������������������������ʱ��
     * ������Ԫ�ص�ĩβ����Ϊ��ǰ�ݹ��������ĩ������������������ڣ���������Ԫ�ص�ĩβ����Ϊstart-1-depth��
     */
    public TreeNode recoverFromPreorder(String S) {
        if (S.length() == 0 && S == null) return null;
        return helper(S.toCharArray(), 0, S.length() - 1, 1);
    }

    private TreeNode helper(char[] arr, int lower, int upper, int depth) {
        if (lower > upper) return null;
        // ��ȡ���ڵ�
        StringBuilder sb = new StringBuilder();
        sb.append(arr[lower]);
        // ��Ҫ����Զ�λ������234
        while (lower < upper && arr[lower + 1] >= '0' && arr[lower + 1] <= '9') {
            lower++;
            sb.append(arr[lower]);
        }
        TreeNode root = new TreeNode(Integer.parseInt(sb.toString()));
        // ���ҽڵ����ʼ��ʵ�ʾ��Ƕ�λǰ��ġ�-����
        int start = lower + 1 + depth;
        // ���start��λ��
        while (start <= upper) {
            // ���count==1��ʱ��Ҳ������һ���ҽڵ㿪ʼ�ĵط�����ʱ��Ҫ�жϣ���λ�����ҽڵ�λ��
            int count = 0;
            while (start < upper && arr[start] == '-') {
                start++;
                count++;
            }
            if(count == depth) break;
            start++;
        }
        // �ҵ����ҽڵ㿪ʼ�ĵط�
        int rightStart = start;
        // �����ҽڵ����
        if(start < upper){
            start = start - 1 -depth;
        }else{
            // �����������ҽڵ�
            start = upper;
        }
        root.left = helper(arr,lower+1+depth,start,depth+1);
        root.right = helper(arr,rightStart,upper,depth+1);
        return root;
    }

}
