package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 3/3/25 23:04
 */
public class LeetCode1547 {

    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int m = cuts.length + 2;
        int[] newCuts = new int[m];
        System.arraycopy(cuts, 0, newCuts, 1, m - 2);
        newCuts[m - 1] = n;
        int[][] memo = new int[m][m];
        return dfs(0, m - 1, newCuts, memo);
    }

    private int dfs(int l, int r, int[] cuts, int[][] memo) {
        if (l + 1 == r) { // 无需切割
            return 0;
        }
        if (memo[l][r] > 0) { // 之前计算过
            return memo[l][r];
        }
        int res = Integer.MAX_VALUE;
        for (int k = l + 1; k < r; k++) {
            res = Math.min(res, dfs(l, k, cuts, memo) + dfs(k, r, cuts, memo));
        }
        return memo[l][r] = res + (cuts[r] - cuts[l]);
    }
}
