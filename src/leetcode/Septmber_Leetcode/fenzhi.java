package leetcode.Septmber_Leetcode;

/**
 * @author caoduanxi
 * @2019/9/29 22:21
 */
public class fenzhi {

    // ���η���ʱ�临�Ӷ�O(NlogN)  �ռ临�Ӷ�O(1)
    // ��֧����˼����Ǵ��м俪ʼ�����е�ֵ�ֳ�����
    // ÿһ�ζ���ݵ���ֵ���̴������м俪ʼ����ǰ���һ����������
    // ������ȡ����ֵ��ǰ�벿�ֻ�ȡ����ֵ�ͺ�벿�ֻ�ȡ����ֵ���Աȣ�һ����ó�����ֵ
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) return len;
        return maxSubArray(nums, 0, len - 1);
    }

    public int maxSubArray(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) >> 1;
        // ����һ���ݹ�������̣����ַ�Ҳ�������￪ʼ
        return getMax(maxSubArray(nums, left, mid),
                maxSubArray(nums, mid + 1, right),
                solutionArray(nums, left, mid, right));
    }

    private int solutionArray(int[] nums, int left, int mid, int right) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        // ���м俪ʼ����ǰ�����������Ϊ���٣����Զ϶�һ����������
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }

        sum = 0;
        // ���м俪ʼ����ߣ������Ϊ����
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }

    public int getMax(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }
}
