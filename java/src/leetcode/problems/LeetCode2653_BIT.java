package leetcode.problems;

import knowledge.datastructure.adv.BIT.BITreeKth;

/**
 * @author wujingxinit@outlook.com
 * @date 7/26/26 11:39
 */
public class LeetCode2653_BIT {

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        final int OFFSET = 10001, V = 20001;     // -10000..10000 → 1..20001
        BITreeKth bit = new BITreeKth(V);
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int right = 0; right < n; right++) {
            bit.add(nums[right] + OFFSET, 1);            // 右端进入
            if (right >= k) bit.add(nums[right - k] + OFFSET, -1);   // 左端移出
            if (right >= k - 1) {
                int value = bit.kthSmallest(x) - OFFSET; // 还原真实值
                ans[right - k + 1] = Math.min(value, 0);
            }
        }
        return ans;
    }
}
