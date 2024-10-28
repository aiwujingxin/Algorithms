package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/12 00:54
 */
public class LeetCode51 {

    List<List<String>> res;
    int n;
    boolean[] c, p, q;
    int[] pos;

    public List<List<String>> solveNQueens(int n) {
        this.res = new ArrayList<>();
        this.n = n;
        this.pos = new int[n];
        this.c = new boolean[n];
        this.p = new boolean[2 * n];
        this.q = new boolean[2 * n];
        backtrack(0);
        return res;
    }

    private void backtrack(int i) {
        if (i == n) {
            List<String> list = new ArrayList<>();
            for (int row = 0; row < n; row++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(pos[row] == j ? "Q" : ".");
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (c[j] || p[i + j] || q[i - j + n]) {
                continue;
            }
            pos[i] = j;
            c[j] = p[i + j] = q[i - j + n] = true;
            backtrack(i + 1);
            c[j] = p[i + j] = q[i - j + n] = false;
        }
    }
}
