package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/4 11:05
 */
public class LeetCode2661 {

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int total = m * n;
        int[] rowPos = new int[total + 1];
        int[] colPos = new int[total + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = mat[i][j];
                rowPos[val] = i;
                colPos[val] = j;
            }
        }
        int[] rowCnt = new int[m];
        int[] colCnt = new int[n];
        for (int i = 0; i < total; i++) {
            int val = arr[i];
            int r = rowPos[val];
            int c = colPos[val];
            rowCnt[r]++;
            colCnt[c]++;
            // 只要某一行涂满了 n 个，或者某一列涂满了 m 个，立刻返回
            if (rowCnt[r] == n || colCnt[c] == m) {
                return i;
            }
        }
        return -1;
    }
}
