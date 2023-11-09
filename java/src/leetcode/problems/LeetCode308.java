package leetcode.problems;

import basic.datastructure.advance.BinaryIndexedTree;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/7 00:12
 */
public class LeetCode308 {

    class NumMatrix {

        private final BinaryIndexedTree[] trees;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            trees = new BinaryIndexedTree[m];
            for (int i = 0; i < m; ++i) {
                BinaryIndexedTree tree = new BinaryIndexedTree(n);
                for (int j = 0; j < n; ++j) {
                    tree.update(j + 1, matrix[i][j]);
                }
                trees[i] = tree;
            }
        }

        public void update(int row, int col, int val) {
            BinaryIndexedTree tree = trees[row];
            int prev = tree.query(col + 1) - tree.query(col);
            tree.update(col + 1, val - prev);
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int s = 0;
            for (int i = row1; i <= row2; ++i) {
                BinaryIndexedTree tree = trees[i];
                s += tree.query(col2 + 1) - tree.query(col1);
            }
            return s;
        }
    }
}
