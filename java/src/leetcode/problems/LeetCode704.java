package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-12-04 12:19 上午
 */
public class LeetCode704 {

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            int num = nums[mid];
            if (num == target) {
                return mid;
            }
            if (num > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
