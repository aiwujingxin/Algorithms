package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/22 18:19
 */
public class LeetCode1060 {

    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        if (k > missing(n - 1, nums)) {
            return nums[n - 1] + k - missing(n - 1, nums);
        }
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (missing(mid, nums) >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l - 1] + k - missing(l - 1, nums);
    }

    int missing(int idx, int[] nums) {
        return nums[idx] - (nums[0] + idx);
    }
}
