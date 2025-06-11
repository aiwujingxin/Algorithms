package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/3 17:29
 */
public class LeetCode228 {

    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<String> list = new ArrayList<>();
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            // 如果到达数组尾部，或者当前数字和下一个数字不连续，就生成区间字符串
            if (right == nums.length - 1 || nums[right + 1] != nums[right] + 1) {
                if (left == right) {
                    list.add(String.valueOf(nums[left]));
                } else {
                    list.add(nums[left] + "->" + nums[right]);
                }
                left = right + 1;
            }
        }
        return list;
    }
}
