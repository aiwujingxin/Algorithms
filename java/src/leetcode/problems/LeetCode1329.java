package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/9 17:20
 */
public class LeetCode1329 {

    public int[][] diagonalSort(int[][] mat) {
        List<Node> arrs = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                arrs.add(new Node(i, j, mat[i][j]));
            }
        }
        int m = mat.length;
        int n = mat[0].length;
        arrs.sort((o1, o2) -> {
            if (o1.y - o1.x == o2.y - o2.x) {
                return o1.val - o2.val;
            }
            return (o1.y - o1.x) - (o2.y - o2.x);
        });
        int index = 0;
        for (int i = 0; i < m; i++) {
            int col = 0;
            for (int row = m - i - 1; row < m && col < n; row++) {
                mat[row][col] = arrs.get(index).val;
                col++;
                index++;
            }
        }
        for (int i = 1; i < n; i++) {
            int row = 0;
            for (int col = i; col < n && row < m; col++) {
                mat[row][col] = arrs.get(index).val;
                row++;
                index++;
            }
        }
        return mat;
    }

    static class Node {
        int x;
        int y;
        int val;

        public Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
