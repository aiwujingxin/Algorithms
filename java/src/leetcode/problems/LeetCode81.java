package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/26 11:37
 * @see LeetCode33
 */
public class LeetCode81 {

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                l++;
                r--;
            } else {
                if (nums[mid] >= nums[l]) {
                    if (target >= nums[l] && target <= nums[mid]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else {
                    if (target >= nums[mid] && target <= nums[r]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
        }
        return false;
    }
}
