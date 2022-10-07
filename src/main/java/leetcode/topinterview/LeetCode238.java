package leetcode.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/28 22:35
 */
public class LeetCode238 {


    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] one = new int[nums.length];
        one[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            one[i] = nums[i - 1] * one[i - 1];
        }
        int temp = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            one[i] = one[i] * temp;
            temp = temp * nums[i];
        }
        return one;
    }
}
