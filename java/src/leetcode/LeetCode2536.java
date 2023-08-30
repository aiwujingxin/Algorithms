package leetcode;

import basic.algorithm.prefixanddiff.MatrixDiff;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/27 11:28
 */
public class LeetCode2536 {

    public int[][] rangeAddQueries(int n, int[][] queries) {
        MatrixDiff pm = new MatrixDiff();
        pm.PreDiff(new int[n][n]);
        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];
            pm.insert(r1, c1, r2, c2, 1);
        }
        return pm.result();
    }
}
