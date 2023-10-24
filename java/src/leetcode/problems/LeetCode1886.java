package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/24 22:59
 */
public class LeetCode1886 {

    public static void main(String[] args) {
        System.out.println(new LeetCode1886().
                findRotation(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        if (eq(mat, target)) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            rotate2(mat);
            rotate1(mat);
            if (eq(mat, target)) {
                return true;
            }
        }
        return false;
    }

    private void rotate1(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < i; j++) {
                int t = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = t;
            }
        }
    }

    private void rotate2(int[][] mat) {
        for (int i = 0; i < mat.length / 2; i++) {
            int[] t = mat[i];
            mat[i] = mat[mat.length - i - 1];
            mat[mat.length - i - 1] = t;
        }
    }

    private boolean eq(int[][] mat, int[][] target) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < target.length; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
