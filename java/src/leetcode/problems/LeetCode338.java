package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/5 18:54
 */
public class LeetCode338 {

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = countOnes(i);
        }
        return res;
    }

    private int countOnes(int x) {
        int cnt = 0;
        while (x > 0) {
            x -= (x & -x);
            cnt++;
        }
        return cnt;
    }

    public int[] countBits_dp(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - (i & -i)] + 1;
        }
        return dp;
    }
}
