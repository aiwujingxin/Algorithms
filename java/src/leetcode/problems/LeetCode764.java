package leetcode.problems;

import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 5/3/25 21:02
 */
public class LeetCode764 {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        HashSet<Integer> set = new HashSet<>();
        for (int[] m : mines) {
            set.add(m[0] * n + m[1]);
        }
        int[][] up = new int[n][n];
        int[][] down = new int[n][n];
        int[][] left = new int[n][n];
        int[][] right = new int[n][n];
        boolean has = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                up[i][j] = set.contains(i * n + j) ? 0 : (i == 0 ? 0 : up[i - 1][j]) + 1;
                down[n - i - 1][j] = set.contains((n - i - 1) * n + j) ? 0 : (i == 0 ? 0 : down[n - i][j]) + 1;
                left[i][j] = set.contains(i * n + j) ? 0 : (j == 0 ? 0 : left[i][j - 1]) + 1;
                right[i][n - j - 1] = set.contains(i * n + (n - j - 1)) ? 0 : (j == 0 ? 0 : right[i][n - j]) + 1;
                if (up[i][j] == 1 || down[n - i - 1][j] == 1 || left[i][j] == 1 || right[i][n - j - 1] == 1) {
                    has = true;
                }
            }
        }
        int max = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (set.contains(i * n + j))
                    continue;
                int a = Math.min(up[i - 1][j], down[i + 1][j]);
                int b = Math.min(left[i][j - 1], right[i][j + 1]);
                max = Math.max(max, Math.min(a, b));
            }
        }
        return max == 0 ? (has ? 1 : 0) : max + 1;
    }
}
