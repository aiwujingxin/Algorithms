package leetcode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/27 21:40
 */
public class LeetCode629_force {


    int MOD = 1000000007;

    public int kInversePairs(int n, int k) {
        return (int) (dfs(n, k) % MOD);
    }

    private long dfs(int n, int k) {
        if (k > n * (n - 1) / 2) {
            return 0;
        }
        if (n == 1) {
            return k == 0 ? 1 : 0;
        }

        long ans = 0;
        // 比如，求解 f(3)(3)，求解 f(2)(0) 是没有意义的，因为两个数的数组没有倒数第三位
        for (int i = Math.max(0, k - n + 1); i <= k; i++) {
            ans += dfs(n - 1, i);
        }

        return ans % MOD;
    }
}
