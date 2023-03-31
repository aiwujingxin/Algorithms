package leetcode.lists.hot200;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/16 18:36
 */
public class LeetCode351 {

    public static void main(String[] args) {
        System.out.println(new LeetCode351().numberOfPatterns(3, 3));
    }

    public int numberOfPatterns(int m, int n) {
        int[][] skip = new int[10][10];
        //这个skip数组是为了记录跳跃的点数，比如说从1到3，就跳跃2
        //而且因为是对称的操作，所以3到1也是如此
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[4][6] = skip[6][4] = skip[2][8] = skip[8][2] = 5;
        skip[1][9] = skip[9][1] = skip[3][7] = skip[7][3] = 5;
        skip[7][9] = skip[9][7] = 8;
        int result = 0;
        boolean[] visited = new boolean[10];
        for (int i = m; i <= n; i++) {
            result += DFS(1, visited, skip, i - 1) * 4;
            result += DFS(2, visited, skip, i - 1) * 4;
            result += DFS(5, visited, skip, i - 1);
        }
        return result;
    }

    public int DFS(int current, boolean[] visited, int[][] skip, int remainKeyCount) {
        if (remainKeyCount == 0) {
            return 1;
        }
        int result = 0;
        visited[current] = true;

        for (int i = 1; i <= 9; i++) {
            int crossThroughNumber = skip[current][i];
            if (!visited[i] && (crossThroughNumber == 0 || visited[crossThroughNumber])) {
                result += DFS(i, visited, skip, remainKeyCount - 1);
            }
        }
        visited[current] = false;
        return result;
    }
}
