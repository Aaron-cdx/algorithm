package leetcode.Septmber_Leetcode;

/**
 * @author caoduanxi
 * @2019/9/28 22:07
 */
public class Test27 {
    // ��������ֱ�Ӽ�¼ÿ�ε���Ӻ�
    // ���Ӷ�O(n^2)
    public int maxSubArray1(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if(temp > max){
                max = temp;
            }
            for (int j = i+1; j < nums.length; j++) {
                temp += nums[j];
                if(temp > max){
                    max = temp;
                }
            }
        }
        return max;
    }
    // ��̬�滮�� �������һ������һ�δ���0���ֵ��������
    // ��һ��Ľⷨ�����sum>0���ж�sum���ڼ�����ȥ�������������Ч��
    // ���sum <= 0����ʾsum����֮��Ľ��û������Ч��
    // ÿ�αȽ�sum��ans�Ĵ�С�����ó����
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(sum > 0){
                sum += nums[i];
            }else {
                sum = nums[i];
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }
    // ����һ��dp[i]������洢���
    public int maxSubArray3(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < len; i++) {
            if (dp[i - 1] >= 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }

        // ���Ҫ����ȫ����һ�������ֵ
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // �����ַ��η�����ѧϰ
    public int maxSubArray4(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        return maxSubArraySum(nums, 0, len - 1);
    }


    // �����ַ��η�����ѧϰ
    private int maxCrossingSum(int[] nums, int left, int mid, int right) {
        // һ������� nums[mid] ���Ԫ��
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        // ���߰��� nums[mid] Ԫ�أ������Ե�ʲô�ط�
        // �ߵ���߽磬������ֵ��ʲô
        // ������ mid ��β������������ĺ�
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        // �Ұ�߲����� nums[mid] Ԫ�أ������Ե�ʲô�ط�
        // ������ mid+1 ��ʼ������������ĺ�
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;

    }

    private int maxSubArraySum(int[] nums, int left, int right) {
        // Ϊ�˱ܿ�ֻ��һ���������
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) >>> 1;// �����ƶ�һλ����ʾ����2
        // ����ǰ�벿��
        return max3(maxSubArraySum(nums, left, mid),
                // �����벿��
                maxSubArraySum(nums, mid + 1, right),
                // �����Խʱ���ȡ��ֵ
                maxCrossingSum(nums, left, mid, right));
    }

    private int max3(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }

    public static void main(String[] args) {
        System.out.println(2 >>> 1);
    }
}
