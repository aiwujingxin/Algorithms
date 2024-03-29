package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2024.01.08 20:54
 */
public class LeetCode1985 {

    public String kthLargestNumber(String[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        Arrays.sort(nums, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o2.compareTo(o1);
            }
            return o2.length() - o1.length();
        });
        return nums[k - 1];
    }
}
