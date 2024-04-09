package leetcode.problems;


import knowledge.algorithms.presumAnddiff.PreDiff;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/27 11:28
 */
public class LeetCode2536 {

    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] nums = new int[n][n];
        PreDiff.PreDiff_2D diff = new PreDiff.PreDiff_2D(nums);
        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];
            diff.update(r1, c1, r2, c2, 1);
        }
        return diff.result();
    }
}
