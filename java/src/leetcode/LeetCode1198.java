package leetcode;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/2 15:06
 */
public class LeetCode1198 {

    public int smallestCommonElement(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        for (int j = 0; j < m; ++j) {
            boolean found = true;
            for (int i = 1; i < n && found; ++i) {
                found = Arrays.binarySearch(mat[i], mat[0][j]) >= 0;
            }
            if (found) {
                return mat[0][j];
            }
        }
        return -1;
    }
}
