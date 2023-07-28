package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/31 00:59
 */
public class LeetCode128_sort_fastest {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        //开始位置
        int start = 0;
        int maxLen = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 1) {
                //结束位置
                maxLen = Math.max(maxLen, nums[i - 1] - nums[start] + 1);
                start = i;  //重置开始位置
            }
        }
        return Math.max(maxLen, nums[nums.length - 1] - nums[start] + 1);
    }
}
