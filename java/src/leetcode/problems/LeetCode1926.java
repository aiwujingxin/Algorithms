package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/16 22:36
 */
public class LeetCode1926 {

    int[][] di = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int nearestExit(char[][] maze, int[] entrance) {

        if (maze == null || maze.length == 0) {
            return 0;
        }
        if (maze[entrance[0]][entrance[1]] == '+') {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        boolean flag = false;
        queue.add(new int[]{entrance[0], entrance[1], 0});
        visited.add(entrance[0] + "," + entrance[1]);
        while (!queue.isEmpty()) {
            int[] pi = queue.poll();

            List<int[]> nexts = getNexts(pi, visited, maze);

            for (int[] next : nexts) {
                if (next[0] == 0 || next[0] == maze.length - 1
                        || next[1] == 0 || next[1] == maze[0].length - 1) {
                    flag = true;
                    res = Math.min(res, next[2]);
                } else {
                    queue.add(next);
                    visited.add(next[0] + "," + next[1]);
                }
            }
        }
        return flag ? res : -1;
    }

    private List<int[]> getNexts(int[] pi, HashSet<String> set, char[][] mat) {
        List<int[]> list = new ArrayList<>();
        for (int[] d : di) {
            int x = pi[0] + d[0];
            int y = pi[1] + d[1];
            if (x < 0 || y < 0 || x > mat.length - 1 || y > mat[0].length - 1 || mat[x][y] == '+' || set.contains(x + "," + y)) {
                continue;
            }
            list.add(new int[]{x, y, pi[2] + 1});
        }
        return list;
    }
}
