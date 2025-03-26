package leetcode.problems;

import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 3/1/25 12:34
 */
public class LeetCode2811 {

    public boolean canSplitArray(List<Integer> nums, int m) {
        int n = nums.size();
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums.get(i - 1);
        }
        boolean[][] f = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = true;
            if (i + 1 < n) {
                f[i][i + 1] = true;
            }
            for (int j = i + 2; j < n; j++) {
                if ((sum[j] - sum[i] >= m && f[i][j - 1]) || (sum[j + 1] - sum[i + 1] >= m && f[i + 1][j])) {
                    f[i][j] = true;
                }
            }
        }
        return f[0][n - 1];
    }
}
