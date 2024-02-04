package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/4 11:05
 */
public class LeetCode2661 {

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer, Integer> rowMap = new HashMap<>();
        HashMap<Integer, Integer> colMap = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowMap.put(mat[i][j], i);
                colMap.put(mat[i][j], j);
            }
        }
        HashMap<Integer, Integer> rowCnt = new HashMap<>();
        HashMap<Integer, Integer> colCnt = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            int row = rowMap.get(a);
            int col = colMap.get(a);
            rowCnt.put(row, rowCnt.getOrDefault(row, 0) + 1);
            colCnt.put(col, colCnt.getOrDefault(col, 0) + 1);
            if (rowCnt.get(row) == n || colCnt.get(col) == m) {
                return i;
            }
        }
        return -1;
    }
}
