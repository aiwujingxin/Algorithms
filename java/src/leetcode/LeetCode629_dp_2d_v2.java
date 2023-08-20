package leetcode;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/27 23:30
 */
public class LeetCode629_dp_2d_v2 {

    public int kInversePairs(int n, int k) {
        int MOD = 1000000007;
        int[][] opt = new int[k + 1][n];
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    opt[i][j] = 1;
                } else if (j > 0) {
                    opt[i][j] = (opt[i - 1][j] + opt[i][j - 1]) % MOD;
                    if (i >= j + 1) {
                        opt[i][j] = (opt[i][j] - opt[i - j - 1][j - 1] + MOD) % MOD;
                    }
                }
            }
        }

        return opt[k][n - 1];
    }
}
