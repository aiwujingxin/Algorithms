package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 11/5/25 01:31
 */
public class LeetCode2017 {

    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] suffixSumRow0 = new long[n];
        suffixSumRow0[n - 1] = grid[0][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSumRow0[i] = suffixSumRow0[i + 1] + grid[0][i];
        }
        long[] prefixSumRow1 = new long[n];
        prefixSumRow1[0] = grid[1][0];
        for (int i = 1; i < n; i++) {
            prefixSumRow1[i] = prefixSumRow1[i - 1] + grid[1][i];
        }
        long minMaxScore = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long topPathScore = (i + 1 < n) ? suffixSumRow0[i + 1] : 0;
            long bottomPathScore = (i - 1 >= 0) ? prefixSumRow1[i - 1] : 0;
            long secondRobotScore = Math.max(topPathScore, bottomPathScore);
            minMaxScore = Math.min(minMaxScore, secondRobotScore);
        }
        return minMaxScore;
    }
}
