package leetcode.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/27 13:45
 */
public class LeetCode189 {

    //fix case
    //[-1,-100,3,99]
    //2

    // -100 -1 99  3

    //like: https://leetcode.cn/problems/rotate-list/
    public void rotate(int[] nums, int k) {

        if (nums == null || nums.length == 0 || nums.length < k) {
            return;
        }
        k = k % nums.length;
        //4 3 2 1 7 6 5
        revert(nums, 0, nums.length - 1 - k);
        revert(nums, nums.length - 1 - k + 1, nums.length - 1);
        revert(nums, 0, nums.length - 1);
    }


    public void revert(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
