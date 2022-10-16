package leetplan.graph.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/16 20:23
 */
public class LeetCode547 {

    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }

        int ans = 0;
        int[] visited = new int[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0) {
                dfs(isConnected, i, visited);
                ans++;
            }
        }
        return ans;
    }

    private void dfs(int[][] isConnected, int v, int[] visited) {
        if (visited[v] == 0) {
            visited[v] = 1;
        }
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0 && isConnected[v][i] == 1) {
                dfs(isConnected, i, visited);
            }
        }
    }
}
