package leetcode.problems;

import knowledge.datastructure.advanced.BITree;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/7 00:12
 */
public class LeetCode308 {

    class NumMatrix {

        private final BITree[] trees;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            trees = new BITree[m];
            for (int i = 0; i < m; ++i) {
                BITree tree = new BITree(n);
                for (int j = 0; j < n; ++j) {
                    tree.add(j + 1, matrix[i][j]);
                }
                trees[i] = tree;
            }
        }

        public void update(int row, int col, int val) {
            BITree tree = trees[row];
            int prev = tree.sum(col + 1) - tree.sum(col);
            tree.add(col + 1, val - prev);
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int s = 0;
            for (int i = row1; i <= row2; ++i) {
                BITree tree = trees[i];
                s += tree.sum(col2 + 1) - tree.sum(col1);
            }
            return s;
        }
    }
}
