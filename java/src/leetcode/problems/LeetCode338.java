package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/17 18:35
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
            //去掉最后一个 1
            x = x & (x - 1);
            cnt++;
        }
        return cnt;
    }

    public int[] countBits_dp(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i & (i - 1)] + 1;
        }
        return dp;
    }
}
