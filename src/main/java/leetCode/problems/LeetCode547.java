package leetCode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/19 21:18
 */
public class LeetCode547 {

    public int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int res = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0) {
                dfs(i, isConnected, visited);
                res++;
            }
        }
        return res;
    }

    public void dfs(int v, int[][] isConnected, int[] visited) {
        if (visited[v] == 0) {
            visited[v] = 1;
        }

        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0 && isConnected[v][i] == 1) {
                dfs(i, isConnected, visited);
            }
        }
    }
}
