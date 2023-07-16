package leetcode.problems;


/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/10 19:55
 */
public class LeetCode427 {

    public static void main(String[] args) {
        System.out.println(new LeetCode427().construct(new int[][]{{0, 1}, {1, 0}}));
    }

    public Node construct(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return new Node();
        }
        return dfs(grid, 0, grid.length - 1, 0, grid[0].length - 1);
    }

    public Node dfs(int[][] grid, int s_row, int e_row, int s_col, int e_col) {
        if (s_row > e_row || s_col > e_col) {
            return null;
        }
        int sum = 0;
        for (int i = s_row; i <= e_row; i++) {
            for (int j = s_col; j <= e_col; j++) {
                sum += grid[i][j];
            }
        }
        Node root = new Node();
        int fill = (e_row - s_row + 1) * (e_col - s_col + 1);
        if (sum == fill || sum == 0) {
            root.isLeaf = true;
            root.val = sum == fill;
        } else {
            int midRow = s_row + (e_row - s_row) / 2;
            int midCol = s_col + (e_col - s_col) / 2;
            root.topLeft = dfs(grid, s_row, midRow, s_col, midCol);
            root.topRight = dfs(grid, s_row, midRow, midCol + 1, e_col);
            root.bottomLeft = dfs(grid, midRow + 1, e_row, s_col, midCol);
            root.bottomRight = dfs(grid, midRow + 1, e_row, midCol + 1, e_col);
        }
        return root;
    }

    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    ;
}
