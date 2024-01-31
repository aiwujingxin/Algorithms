package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/30 14:33
 */
public class LeetCode1175 {


    public int numPrimeArrangements(int n) {
        if (n <= 2) {
            return 1;
        }
        int cnt = countPrimes(n);
        long res = 1;
        int mod = 1000000007;
        int normal = n - cnt;
        for (int i = 1; i <= cnt; i++) {
            res = (res * i) % mod;
        }
        for (int i = 1; i <= normal; i++) {
            res = (res * i) % mod;
        }
        return (int) (res % mod);
    }

    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        boolean[] dp = new boolean[n + 1];
        int cnt = 0;
        dp[1] = true;
        for (int i = 2; i <= n; i++) {
            if (!dp[i]) {
                cnt++;
                for (int j = 0; j * i <= n; j++) {
                    dp[i * j] = true;
                }
            }
        }
        return cnt;
    }
}
