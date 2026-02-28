package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/26 11:37
 * @see LeetCode33
 */
public class LeetCode81 {

    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            // 核心优化：直接跳过首尾重复元素，恢复单调性
            while (l < r && nums[l] == nums[l + 1]) l++;
            while (l < r && nums[r] == nums[r - 1]) r--;
            int m = (l + r) >> 1;
            if (nums[m] == target) return true;
            if (nums[l] <= nums[m]) {
                if (nums[l] <= target && target < nums[m]) r = m - 1;
                else l = m + 1;
            } else {
                if (nums[m] < target && target <= nums[r]) l = m + 1;
                else r = m - 1;
            }
        }
        return false;
    }
}
