package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/29 21:56
 */
public class LeetCode1514_BellmanFord {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] dp = new double[n];
        dp[start] = 1;//起点
        while (true) {
            boolean k = false;
            for (int j = 0; j < edges.length; j++) {
                if (dp[edges[j][0]] * succProb[j] > dp[edges[j][1]]) {
                    dp[edges[j][1]] = dp[edges[j][0]] * succProb[j];
                    k = true;
                }//因为是无向图,所以再反向遍历
                if (dp[edges[j][1]] * succProb[j] > dp[edges[j][0]]) {
                    dp[edges[j][0]] = dp[edges[j][1]] * succProb[j];
                    k = true;
                }
            }
            if (!k) {
                break;//一遍未修改则表示图已遍历完成
            }
        }
        return dp[end];
    }
}
