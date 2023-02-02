package leetcode.plan.binarysearch.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/9 21:14
 */
public class LeetCode34 {

    public int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                int s = mid;
                while (s > 0 && nums[s - 1] == target) {
                    s--;
                }
                int e = mid;
                while (e < nums.length - 1 && nums[e + 1] == target) {
                    e++;
                }
                return new int[]{s, e};
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}
