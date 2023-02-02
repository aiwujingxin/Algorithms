package leetcode.lists.hot100;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/19 13:46
 */
public class LeetCode238 {


    public int[] productExceptSelf(int[] nums) {

        if (nums == null || nums.length == 0) {
            return nums;
        }

        //[1,2,3,4]
        // 1 1 2 6

        //[-1,1,0,-3,3]
        // -1 -1 -1
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
