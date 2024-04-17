package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/17 15:00
 */
public class LeetCode154 {

    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[l] == nums[r]) {
                r--;
            } else {
                if (nums[mid] > nums[r]) l = mid + 1;
                else r = mid;
            }
        }
        return nums[l];
    }
}
