package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/15 17:25
 */
public class LeetCode1337 {

    public int[] kWeakestRows(int[][] mat, int k) {
        if (mat == null || mat.length == 0) {
            return new int[]{};
        }

        int[] sum = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            int[] s = mat[i];
            sum[i] = sum(s);
        }

        int[][] matrix = new int[mat.length][1];

        for (int i = 0; i < sum.length; i++) {
            matrix[i] = new int[]{sum[i], i};
        }

        Arrays.sort(matrix, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = matrix[i][1];
        }
        return res;
    }


    private int sum(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res += n;
        }
        return res;
    }
}

