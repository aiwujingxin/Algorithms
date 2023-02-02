package leetcode.plan.graph.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/16 20:58
 */
public class LeetCode1319_dfs_MLE {

    public static void main(String[] args) {
        System.out.println(new LeetCode1319_dfs_MLE().makeConnected(4, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections == null || connections.length == 0) {
            return 0;
        }
        int ans = 0;
        int[] visited = new int[n];


        int[][] isConnected = new int[n][n];
        for (int[] connection : connections) {
            isConnected[connection[0]][connection[1]] = 1;
            isConnected[connection[1]][connection[0]] = 1;
        }
        for (int i = 0; i < n; i++) {
            isConnected[i][i] = 1;
        }

        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0) {
                dfs(isConnected, i, visited);
                ans++;
            }
        }
        return ans - 1;
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
