package leetcode.plan.algorithm.level2;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/23 15:59
 */
public class LeetCode34_left_right_bound {

    //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/discuss/2587025/Java-Solution-using-binary-search
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    static int findFirst(int[] nums, int target) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                idx = mid;
            }
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return idx;
    }

    static int findLast(int[] nums, int target) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                idx = mid;
            }
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return idx;
    }
}
