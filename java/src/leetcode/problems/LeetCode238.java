package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/5 14:45
 */
public class LeetCode238 {

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int[] arr = new int[nums.length];
        arr[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            arr[i] = arr[i - 1] * nums[i - 1];
        }
        int t = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            arr[i] = arr[i] * t;
            t = t * nums[i];
        }
        return arr;
    }
}
