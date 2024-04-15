package leetcode.lists.lcr;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/13 22:53
 */
public class LCR172 {

    public int countTarget(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = lb(nums, target);
        int right = rb(nums, target);
        if (nums[left] != target && nums[right] != target) {
            return 0;
        }
        return right - left + 1;
    }

    public int lb(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    public int rb(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] > target) r = mid - 1;
            else l = mid;
        }
        return l;
    }
}
