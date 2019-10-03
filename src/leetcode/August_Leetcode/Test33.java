package leetcode.August_Leetcode;

/**
 * @author caoduanxi
 * @2019/8/30 21:10
 */
public class Test33 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int l, int h) {
        if (l > h) return null;
        // Ѱ�����ֵ�±������ֵ
        int[] max = findMax(nums,l,h);
        int index = max[0];
        int value = max[1];
        // ���ֵ�������ڵ�
        TreeNode root = new TreeNode(value);
        // С�������
        root.left = buildTree(nums, l, index - 1);
        // ������ұ�
        root.right = buildTree(nums, index + 1, h);
        return root;
    }

    public int[] findMax(int[] nums,int l, int h) {
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = l; i <= h; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        // �±�����ֵ
        return new int[]{index, max};
    }
}
