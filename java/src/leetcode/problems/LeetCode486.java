package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/7 13:09
 */
public class LeetCode486 {

    Integer[][] memo;

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        memo = new Integer[n][n];
        return dfs(nums, 0, n - 1) >= 0;
    }

    private int dfs(int[] nums, int l, int r) {
        if (l > r) {
            return 0;
        }
        if (memo[l][r] != null) {
            return memo[l][r];
        }
        memo[l][r] = Math.max(nums[l] - dfs(nums, l + 1, r), nums[r] - dfs(nums, l, r - 1));
        return memo[l][r];
    }

    public boolean predictTheWinnerDP(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                dp[l][r] = Math.max(nums[l] - dp[l + 1][r], nums[r] - dp[l][r - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }

    public boolean predictTheWinnerDP2(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        // 初始化：长度为1的区间，玩家只能拿自己
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        // 区间从后往前（起点 i 倒序），终点 j 正序
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }
}
