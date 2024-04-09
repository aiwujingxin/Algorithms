package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/18 20:36
 */
public class LeetCode162 {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid + 1] > nums[mid]) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
