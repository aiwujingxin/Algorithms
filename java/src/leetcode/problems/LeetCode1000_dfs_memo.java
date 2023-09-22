package leetcode.problems;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2023/2/11 21:59
 * <a href="https://leetcode.cn/problems/minimum-cost-to-merge-stones/solution/yi-dong-you-yi-dao-nan-yi-bu-bu-shuo-ming-si-lu-he/">...</a>
 */
public class LeetCode1000_dfs_memo {

    int[][] memo;
    int[] preSum;

    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) return -1;
        preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + stones[i];
        }
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, n - 1, k);
    }

    private int dfs(int l, int r, int k) {
        if (r - l + 1 < k) {
            return 0;
        }

        if (r - l + 1 == k) {
            return preSum[r + 1] - preSum[l];
        }

        if (memo[l][r] != -1) {
            return memo[l][r];
        }

        int min = Integer.MAX_VALUE;
        int mergeCost = (r - l) % (k - 1) == 0 ? preSum[r + 1] - preSum[l] : 0;
        for (int i = l; i < r; i += k - 1) {
            int left = dfs(l, i, k);
            int right = dfs(i + 1, r, k);
            min = Math.min(min, left + mergeCost + right);
        }
        memo[l][r] = min;
        return min;
    }
}
