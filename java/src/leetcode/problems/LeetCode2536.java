package leetcode.problems;


import knowledge.algorithms.presumAnddiff.PreDiff;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/27 11:28
 */
public class LeetCode2536 {

    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] nums = new int[n][n];
        PreDiff.PreDiff2D diff = new PreDiff.PreDiff2D(nums);
        for (int[] q : queries) {
            diff.update(q[0], q[1], q[2], q[3], 1);
        }
        return diff.result();
    }
}
