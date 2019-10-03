package leetcode.Septmber_Leetcode;

/**
 * @author caoduanxi
 * @2019/9/23 18:59
 */
public class NumArray {
//    int[] res;
//
//    public NumArray(int[] nums) {
//        this.res = nums;
//    }
//
//    public int sumRange(int i, int j) {
//        int sum = 0;
//        for (int k = i; k <= j; k++) {
//            sum += res[k];
//        }
//        return sum;
//    }

    private int[] sum;

    public NumArray(int[] nums) {
        // �����˼�����Լ��ȼ�������е�֮�����ֵ
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            // �˴��������е�ֵ,��֤sum[0]=0,��1��ʼ����
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);
        System.out.println(obj.sumRange(0, 2));
    }
}
