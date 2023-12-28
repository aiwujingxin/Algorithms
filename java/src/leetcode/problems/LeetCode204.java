package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/27 16:05
 */
public class LeetCode204 {

    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        boolean[] dp = new boolean[n];
        int cnt = 0;
        dp[1] = true;
        for (int i = 2; i < n; i++) {
            if (!dp[i]) {
                cnt++;
                for (int j = 0; j * i < n; j++) {
                    dp[i * j] = true;
                }
            }
        }
        return cnt;
    }
}
