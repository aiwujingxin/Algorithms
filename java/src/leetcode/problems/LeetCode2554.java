package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 12/4/25 16:36
 */
public class LeetCode2554 {

    public int maxCount(int[] banned, int n, int maxSum) {
        int len = 10001;
        int[] nums = new int[len];
        for (int i = 1; i <= n; i++) {
            nums[i] = i;
        }
        for (int j : banned) {
            if (j >= 1 && j <= n) {
                nums[j] = 0;
            }
        }
        int[] presum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }

        int[] cntsum = new int[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            cntsum[i] = cntsum[i - 1] + (nums[i - 1] == 0 ? 1 : 0);
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            // 如果当前数字被禁止，跳过
            if (nums[i] == 0) continue;
            int l = i;
            int r = n;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (check(presum, i, mid, maxSum)) l = mid;
                else r = mid - 1;
            }
            if (r >= i) {
                ans = Math.max(ans, r - i + 1 - (cntsum[r + 1] - cntsum[i]));
            }
        }

        return ans;
    }

    private boolean check(int[] presum, int i, int j, int maxSum) {
        return presum[j] - presum[i - 1] <= maxSum;
    }
}
