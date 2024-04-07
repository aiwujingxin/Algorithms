package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/20 16:08
 */
public class LeetCode54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }
        int top = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();
        while (top <= down && left <= right) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (top <= down && left <= right) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[down][i]);
                }
            }
            down--;
            if (top <= down && left <= right) {
                for (int i = down; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
            }
            left++;
        }
        return res;
    }
}
