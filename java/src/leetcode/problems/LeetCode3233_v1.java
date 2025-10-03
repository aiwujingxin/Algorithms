package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 8/18/25 23:38
 */
public class LeetCode3233_v1 {

    public int nonSpecialCount(int l, int r) {
        int n = (int) Math.floor(Math.sqrt(r)) + 1;
        boolean[] dp = new boolean[n];
        int cnt = 0;
        dp[1] = true;
        for (int i = 2; i * i <= r; i++) {
            if (!dp[i]) {
                if (i * i >= l) {
                    cnt++;
                }
                for (int j = 2; j * i < n; j++) {
                    dp[i * j] = true;
                }
            }
        }
        return r - l + 1 - cnt;
    }
}
