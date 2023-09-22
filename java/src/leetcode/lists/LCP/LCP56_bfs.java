package leetcode.lists.LCP;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/9 01:26
 */
public class LCP56_bfs {

    //https://leetcode.cn/problems/6UEx57/solutions/1443583/by-focused-poincareqp6-3nej/
    private int[][] directions = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    private final char[] cs = new char[]{'>', '<', 'v', '^'};

    public int conveyorBelt(String[] matrix, int[] start, int[] end) {
        int row = matrix.length;
        int col = matrix[0].length();
        boolean[][] visited = new boolean[row][col];
        LinkedList<Node> queue = new LinkedList<>();
        queue.addFirst(new Node(start[0], start[1]));
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Node> currentLevel = new LinkedList<>();
            for (int k = 0; k < size; k++) {
                Node current = queue.removeLast();
                // 沿着箭头的方向找一条path，该path上的所有点与current有相同的steps
                List<Node> nodes = findAlongPath(matrix, current, row, col, visited);
                currentLevel.addAll(nodes);
            }
            for (Node current : currentLevel) {
                if (current.row == end[0] && current.col == end[1]) {
                    return steps;
                }
                for (int i = 0; i < 4; i++) {
                    int nextRow = current.row + directions[i][0];
                    int nextCol = current.col + directions[i][1];
                    if (nextRow < 0 || nextRow == row || nextCol < 0 || nextCol == col || visited[nextRow][nextCol]) {
                        continue;
                    }
                    visited[nextRow][nextCol] = true;
                    queue.addLast(new Node(nextRow, nextCol));
                }
            }
            steps++;
        }
        return -1;
    }

    private List<Node> findAlongPath(String[] matrix, Node start, int row, int col, boolean[][] visited) {
        List<Node> list = new ArrayList<>();
        Node current = start;
        list.add(current);
        visited[current.row][current.col] = true;
        while (true) {
            int nextDirection = nextDirection(matrix[current.row].charAt(current.col));
            int nextRow = current.row + directions[nextDirection][0];
            int nextCol = current.col + directions[nextDirection][1];
            if (nextRow < 0 || nextRow == row || nextCol < 0 || nextCol == col || visited[nextRow][nextCol]) {
                return list;
            }
            Node next = new Node(nextRow, nextCol);
            list.add(next);
            current = next;
            visited[nextRow][nextCol] = true;
        }
    }


    private int nextDirection(char direction) {
        for (int i = 0; i < 4; i++) {
            if (direction == cs[i]) {
                return i;
            }
        }
        return -1;
    }

    private static class Node {
        int row;
        int col;

        private Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "(" + row + "," + col + ")";
        }
    }
}
