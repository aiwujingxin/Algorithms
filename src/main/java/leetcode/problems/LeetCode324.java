package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/4 21:30
 */
public class LeetCode324 {

    //https://www.youtube.com/watch?v=M2pnGMBo9Vs
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        Arrays.sort(nums);
        int[] copy = Arrays.copyOf(nums, nums.length);

        int mid = (nums.length + 1) / 2 - 1;

        int end = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 1) { // i = 0, 2, 4, 6...
                nums[i] = copy[end--];
            } else {
                nums[i] = copy[mid--];
            }
        }
    }
}
