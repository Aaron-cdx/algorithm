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
     * 可知前序遍历的结果为中->左->右，所以只要知道每颗子树的右子树元素的起始范围就可以固定二叉树
     * <p>
     * 如1-2--3--4-5--6--7，可知1为根节点，子节点深度为1，因为2和5的深度都为1，所以左子树的元素为[2--3--4]，
     * 右子树的范围是[5--6--7]。对于左子树[2--3--4]，根节点为[2]，子节点深度为2，所以左右子树分别为[3][4]。
     * <p>
     * 所以我们可以根据当前节点所在的深度来找出当前根节点的左右子树范围：
     * 例如根节点为1时，深度为1，其索引位置为0，左子树的根节点的起始位置为2。
     * <p>
     * 扩展到通用情况，当根节点最后一位数的索引为lo，
     * 深度为depth(从1开始)，其左子树的根节点的索引位置为lo+1+depth，
     * 从左子树根节点开始，向右搜索右子树的根节点，即前面有depth个'-'的数字，索引位置为start。
     * <p>
     * 这里要注意一种特殊情况，即右子树不存在时，
     * 左子树元素的末尾索引为当前递归数组的最末索引；如果右子树存在，则左子树元素的末尾索引为start-1-depth。
     */
    public TreeNode recoverFromPreorder(String S) {
        if (S.length() == 0 && S == null) return null;
        return helper(S.toCharArray(), 0, S.length() - 1, 1);
    }

    private TreeNode helper(char[] arr, int lower, int upper, int depth) {
        if (lower > upper) return null;
        // 获取根节点
        StringBuilder sb = new StringBuilder();
        sb.append(arr[lower]);
        // 主要是针对多位数例如234
        while (lower < upper && arr[lower + 1] >= '0' && arr[lower + 1] <= '9') {
            lower++;
            sb.append(arr[lower]);
        }
        TreeNode root = new TreeNode(Integer.parseInt(sb.toString()));
        // 求右节点的起始，实质就是定位前面的‘-’数
        int start = lower + 1 + depth;
        // 求出start的位置
        while (start <= upper) {
            // 如果count==1的时候也就是下一个右节点开始的地方，此时需要中断，定位到了右节点位置
            int count = 0;
            while (start < upper && arr[start] == '-') {
                start++;
                count++;
            }
            if(count == depth) break;
            start++;
        }
        // 找到了右节点开始的地方
        int rightStart = start;
        // 表明右节点存在
        if(start < upper){
            start = start - 1 -depth;
        }else{
            // 表明不存在右节点
            start = upper;
        }
        root.left = helper(arr,lower+1+depth,start,depth+1);
        root.right = helper(arr,rightStart,upper,depth+1);
        return root;
    }

}
