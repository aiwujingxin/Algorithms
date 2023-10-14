package leetcode.lists.lcr;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/23 13:10
 */

public class LCR9 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int cnt = 0;

        int t = 1;
        while (right < nums.length) {
            t = t * nums[right];
            while (left < right && t >= k) {
                t = t / nums[left];
                left++;
            }
            if (t < k) {
                cnt += right - left + 1;
            }
            right++;
        }
        return cnt;
    }
}
