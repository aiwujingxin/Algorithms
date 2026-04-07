package leetcode.problems;

import common.ListNode;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/11 18:29
 */
public class LeetCode2326 {

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(matrix[i], -1);
        }
        int dir = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < m * n; i++) {
            if (head != null) {
                matrix[x][y] = head.val;
                head = head.next;
            } else {
                break;
            }
            int nx = x + dirs[dir][0];
            int ny = y + dirs[dir][1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || matrix[nx][ny] != -1) {
                dir = (dir + 1) % 4; // 顺时针转向
            }
            x += dirs[dir][0];
            y += dirs[dir][1];
        }
        return matrix;
    }
}
