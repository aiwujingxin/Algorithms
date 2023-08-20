package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/4/26 16:41
 */
public class LeetCode499_bfs_opt {
    public int[][] dirs = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}, {0, 0}};
    public String[] action = {"d", "l", "r", "u"}; // 下左右上四个方向, 对应上面dirs

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int N = maze.length, M = maze[0].length;
        // visited [行][列][方向] 球当前的位置可能是由4个不同方向来到的，一个坐标有4个方向状态
        boolean[][][] visited = new boolean[N][M][4];
        Node start = new Node(ball[0], ball[1], 4, ""); // 起始节点
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Node node = queue.poll();
                // 遇到了洞，终止，返回到当前为止做过的所有决定
                if (node.x == hole[0] && node.y == hole[1]) {
                    return node.path;
                }
                bfs(maze, node, queue, visited, N, M); // 否则继续广搜
            }
        }
        return "impossible";
    }

    // cur: 当前来到的节点
    public void bfs(int[][] maze, Node cur, Queue<Node> queue, boolean[][][] visited, int N, int M) {
        int dir = cur.dir;
        int x = cur.x + dirs[dir][0], y = cur.y + dirs[dir][1]; // 沿着来的方向继续走
        // 球处于初始状态 或 越界撞墙，改变方向继续走
        if (dir == 4 || x < 0 || x == N || y < 0 || y == M || maze[x][y] == 1) {
            for (int i = 0; i < 4; i++) {
                if (i == dir) {
                    continue;
                }

                x = cur.x + dirs[i][0];
                y = cur.y + dirs[i][1];
                if (x >= 0 && x < N && y >= 0 && y < M && maze[x][y] == 0 && !visited[x][y][i]) {
                    visited[x][y][i] = true;
                    queue.offer(new Node(x, y, i, cur.path + action[i])); // 入队
                }
            }
        } else if (!visited[x][y][dir]) { // 非初始状态 && 也没越界, 沿着当前方向dir一直走！
            visited[x][y][dir] = true;
            queue.offer(new Node(x, y, dir, cur.path)); // 入队
        }
    }

    public static class Node {
        public int x;  // 球当前的坐标位置
        public int y;
        public int dir; // 从哪个方向来的！0 1 2 3 4，4表示初始状态
        public String path; // 之前做了哪些决定让你来到这个位置。

        public Node(int row, int col, int dir, String path) {
            x = row;
            y = col;
            this.dir = dir;
            this.path = path;
        }
    }
}
