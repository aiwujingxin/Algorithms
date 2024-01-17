package leetcode.problems;


import knowledge.algorithms.prefixanddiff.impl.PreDiff_2d;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/27 11:28
 */
public class LeetCode2536 {

    public int[][] rangeAddQueries(int n, int[][] queries) {
        PreDiff_2d pm = new PreDiff_2d();
        pm.PreDiff(new int[n][n]);
        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];
            pm.insert(r1, c1, r2, c2, 1);
        }
        return pm.result();
    }
}
