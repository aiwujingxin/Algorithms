package leetcode.lists.hot100;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 21:15
 */
public class LeetCode169_sort {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
