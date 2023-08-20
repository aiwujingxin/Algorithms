package leetcode;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/21 23:51
 */
public class LeetCode410_dp {

    public int splitArray(int[] nums, int m) {
        int n = nums.length;

        //我们可以令f[i][j] 表示将数组的前 i 个数分割为 j 段所能得到的最大连续子数组和的最小值
        int[][] f = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(f[i], Integer.MAX_VALUE);
        }
        int[] sub = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }
        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                for (int k = 0; k < i; k++) {
                    f[i][j] = Math.min(f[i][j], Math.max(f[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return f[n][m];
    }

}
