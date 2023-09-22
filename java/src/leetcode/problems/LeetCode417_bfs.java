package leetcode.problems;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/13 00:09
 */
public class LeetCode417_bfs {


    //https://leetcode.com/problems/pacific-atlantic-water-flow/discuss/2517431/JAVA-or-DFS-%2B-recursion-or-BFS-%2B-iteration-or-two-solutions
    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        boolean[][] pacific = helper_bfs(heights, true);
        boolean[][] atlantic = helper_bfs(heights, false);

        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    //Time: O(M + N + M*N); Space:  O(M*N)
    private boolean[][] helper_bfs(int[][] heights, boolean flag) {
        //flag true: pacific
        Queue<int[]> queue = new LinkedList<>();
        int fixJ = flag ? 0 : heights[0].length - 1;
        for (int i = 0; i < heights.length; i++) {
            queue.add(new int[]{i, fixJ});
        }

        int fixI = flag ? 0 : heights.length - 1;
        for (int j = 0; j < heights[0].length; j++) {
            queue.add(new int[]{fixI, j});
        }

        boolean[][] res = new boolean[heights.length][heights[0].length];
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int i = node[0], j = node[1];
            res[i][j] = true;
            for (int[] dir : DIRECTIONS) {
                int x = i + dir[0], y = j + dir[1];
                if (x >= 0 && x < heights.length && y >= 0 && y < heights[0].length && heights[x][y] >= heights[i][j] && !res[x][y]) {
                    queue.add(new int[]{x, y});
                }
            }
        }
        return res;
    }
}
