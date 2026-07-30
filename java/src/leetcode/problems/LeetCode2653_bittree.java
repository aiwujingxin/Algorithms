package leetcode.problems;

import knowledge.datastructure.adv.BIT.BITreeKth;

/**
 * @author wujingxinit@outlook.com
 * @date 7/26/26 11:39
 */
public class LeetCode2653_bittree {

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        final int OFFSET = 50, V = 101;
        BITreeKth bit = new BITreeKth(V);
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int right = 0; right < n; right++) {
            bit.add(nums[right] + OFFSET, 1);
            if (right >= k) bit.add(nums[right - k] + OFFSET, -1);
            if (right >= k - 1) {
                int value = bit.kthSmallest(x) - OFFSET;
                ans[right - k + 1] = Math.min(value, 0);
            }
        }
        return ans;
    }
}
