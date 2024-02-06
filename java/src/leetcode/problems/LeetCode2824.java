package leetcode.problems;

import java.util.Collections;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/6 15:07
 */
public class LeetCode2824 {

    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int res = 0;
        int left = 0;
        int right = nums.size() - 1;
        while (left < right) {
            while (left < right && nums.get(left) + nums.get(right) >= target) {
                right--;
            }
            res += right - left;
            left++;
        }
        return res;
    }
}
