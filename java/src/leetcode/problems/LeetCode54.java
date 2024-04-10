package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/10 23:20
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
        List<Integer> list = new ArrayList<>();
        while (top <= down && left <= right) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if (top <= down && left <= right) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[down][i]);
                }
            }
            down--;
            if (top <= down && left <= right) {
                for (int i = down; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
            }
            left++;
        }
        return list;
    }
}
