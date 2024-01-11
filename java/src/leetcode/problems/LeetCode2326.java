package leetcode.problems;

import common.ListNode;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/11 18:29
 */
public class LeetCode2326 {

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(matrix[i], -1);
        }
        int top = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;

        ListNode cur = head;

        while (cur != null) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = cur.val;
                cur = cur.next;
                if (cur == null) {
                    return matrix;
                }
            }
            top++;

            for (int i = top; i <= down; i++) {
                matrix[i][right] = cur.val;
                cur = cur.next;
                if (cur == null) {
                    return matrix;
                }
            }
            right--;

            if (left <= right && down >= top) {
                for (int i = right; i >= left; i--) {
                    matrix[down][i] = cur.val;
                    cur = cur.next;
                    if (cur == null) {
                        return matrix;
                    }
                }
                down--;
            }

            if (left <= right && down >= top) {
                for (int i = down; i >= top; i--) {
                    matrix[i][left] = cur.val;
                    cur = cur.next;
                    if (cur == null) {
                        return matrix;
                    }
                }
                left++;
            }
        }
        return matrix;
    }
}
