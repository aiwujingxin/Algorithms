package leetcode.plan.graph.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/22 23:25
 * <a href="https://leetcode.com/problems/possible-bipartition/discuss/158957/Java-DFS-solution">...</a>
 */
public class LeetCode886_dfs {


    //study
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[][] graph = new int[N][N];
        for (int[] d : dislikes) {
            graph[d[0] - 1][d[1] - 1] = 1;
            graph[d[1] - 1][d[0] - 1] = 1;
        }
        int[] group = new int[N];
        for (int i = 0; i < N; i++) {
            if (group[i] == 0 && dfs(graph, group, i, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] group, int index, int g) {
        group[index] = g;
        for (int i = 0; i < graph.length; i++) {
            if (graph[index][i] == 1) {
                if (group[i] == g) {
                    return true;
                }
                if (group[i] == 0 && dfs(graph, group, i, -g)) {
                    return true;
                }
            }
        }
        return false;
    }

}
