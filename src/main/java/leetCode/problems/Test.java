package leetCode.problems;

/**
 * @author jingxinwu
 * @date 2021-08-07 11:55 上午
 */
public class Test {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, -2, 4};
        int res = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(max * nums[i], min * nums[i]));
            System.out.println("max: " + max + " min: " + min);
            if (max > res) {
                res = max;
            }
        }

        System.out.println(res);
    }

}
