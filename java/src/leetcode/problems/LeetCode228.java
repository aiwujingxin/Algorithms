package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/3 17:29
 */
public class LeetCode228 {

    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        if (nums.length == 1) {
            List<String> list = new ArrayList<>();
            list.add(String.valueOf(nums[0]));
            return list;
        }

        List<String> list = new ArrayList<>();
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            while (right + 1 < nums.length && nums[right + 1] == nums[right] + 1) {
                right++;
            }
            add(list, nums, left, right);
            left = right + 1;
            right = left;
        }
        return list;
    }

    private void add(List<String> list, int[] nums, int left, int right) {
        if (left == right) {
            list.add(String.valueOf(nums[left]));
            return;
        }
        list.add(nums[left] + "->" + nums[right]);
    }
}
