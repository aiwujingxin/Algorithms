package leetcode.plan.binarysearch.level1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/15 17:25
 */
public class LeetCode1337 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode1337().kWeakestRows(new int[][]{{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}}, 3)));
    }


    public int[] kWeakestRows(int[][] mat, int k) {
        if (mat == null || mat.length == 0) {
            return new int[]{};
        }

        //2 4 1 2 5
        int[] sum = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            int[] s = mat[i];
            sum[i] = sum(s);
        }

        int[][] matrix = new int[mat.length][1];

        for (int i = 0; i < sum.length; i++) {
            matrix[i] = new int[]{sum[i], i};
        }

        Arrays.sort(matrix, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
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

