package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/3 12:08
 */
public class LeetCode427 {

    public Node construct(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return null;
        }
        return dfs(grid, 0, grid.length - 1, 0, grid[0].length - 1);
    }

    private Node dfs(int[][] grid, int top, int down, int left, int right) {
        if (top > down || left > right) {
            return null;
        }
        int value = grid[top][left];
        int sum = 0;
        for (int i = top; i <= down; i++) {
            for (int j = left; j <= right; j++) {
                sum += grid[top][left];
            }
        }
        boolean isLeaf = sum == 0 || sum == (down - top + 1) * (right - left + 1);
        Node root = new Node(value == 1, isLeaf);

        if (isLeaf) {
            return root;
        }
        int rowmid = (top + down) / 2;
        int colmid = (left + right) / 2;
        root.topLeft = dfs(grid, top, rowmid, left, colmid);
        root.bottomLeft = dfs(grid, rowmid + 1, down, left, colmid);
        root.topRight = dfs(grid, top, rowmid, colmid + 1, right);
        root.bottomRight = dfs(grid, rowmid + 1, down, colmid + 1, right);
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
}
