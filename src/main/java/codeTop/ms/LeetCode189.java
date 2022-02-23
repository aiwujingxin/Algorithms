package codeTop.ms;

/**
 * @author jingxinwu
 * @date 2022-02-18 11:49 AM
 */
public class LeetCode189 {


    //fix 超时
    public void rotate(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return;
        }

        while (k > 0) {
            moveLast(nums);
            k--;
        }

    }

    private void moveLast(int[] nums) {
        int last = nums[nums.length - 1];

        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = last;

    }


    public static void rotateV2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
