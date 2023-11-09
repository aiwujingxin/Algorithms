package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/14 19:19
 */
public class LeetCode311 {

    public int[][] multiply(int[][] mat1, int[][] mat2) {

        int[][] ans = new int[mat1.length][mat2[0].length];

        int[][] mat3 = reverse(mat2);
        for (int row = 0; row < mat1.length; row++) {
            for (int col = 0; col < mat3.length; col++) {
                int sum = 0;
                for (int k = 0; k < mat1[row].length; k++) {
                    sum += mat1[row][k] * mat3[row][k];
                }
                ans[row][col] = sum;
            }
        }
        return ans;
    }

    public int[][] reverse(int[][] mat) {
        int[][] res = new int[mat[0].length][mat.length];
        for (int j = 0; j < mat[0].length; j++) {
            for (int i = 0; i < mat.length; i++) {
                res[j][i] = mat[i][j];
            }
        }
        return res;
    }
}
