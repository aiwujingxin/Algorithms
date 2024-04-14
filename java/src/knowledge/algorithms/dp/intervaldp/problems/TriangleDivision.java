package knowledge.algorithms.dp.intervaldp.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/14 13:56
 */
public class TriangleDivision {

    public static void main(String[] args) {
        int[] vertices = {0, 1, 2, 3, 4, 5}; // 示例多边形顶点坐标
        int minCost = minTriangulationCost(vertices);
        System.out.println("最小三角剖分代价: " + minCost);
    }

    public static int minTriangulationCost(int[] vertices) {
        int n = vertices.length;
        int[][] dp = new int[n][n];
        for (int r = 2; r < n; r++) {
            for (int i = 1; i < n - r + 1; i++) {
                int j = i + r - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + w(vertices[i - 1], vertices[k], vertices[j]);
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        return dp[1][n - 1];
    }

    private static int w(int a, int b, int c) {
        return Math.abs(a + b + c);
    }
}
