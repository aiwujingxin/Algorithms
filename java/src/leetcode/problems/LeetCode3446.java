package leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 8/28/25 17:50
 */
public class LeetCode3446 {

    public int[][] sortMatrix(int[][] mat) {
        int n = mat.length;
        for (int start = 0; start < n; start++) {
            // 主对角线和左下角从行开始
            int i = start, j = 0;
            List<Integer> diag = new ArrayList<>();
            while (i < n && j < n) {
                diag.add(mat[i][j]);
                i++;
                j++;
            }
            diag.sort((a, b) -> b - a); // 非递增
            i = start;
            j = 0;
            for (int val : diag) {
                mat[i][j] = val;
                i++;
                j++;
            }
        }
        for (int start = 0; start < n - 1; start++) {
            int i = 0, j = start + 1;
            List<Integer> diag = new ArrayList<>();
            while (i < n && j < n) {
                diag.add(mat[i][j]);
                i++;
                j++;
            }
            Collections.sort(diag); // 非递减
            i = 0;
            j = start + 1;
            for (int val : diag) {
                mat[i][j] = val;
                i++;
                j++;
            }
        }
        return mat;
    }
}
