package knowledge.algorithms.dp.backpack.twocost;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/27 16:32
 * @see 8.cpp
 */
public class TwoCost_dp_2d implements TwoCostPack {

    public int backPack(int N, int V, int M, int[] v, int[] m, int[] w) {
        int[][] dp = new int[V + 1][M + 1];
        Node[][] g = new Node[V + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= v[i - 1]; j--) {
                for (int k = M; k >= m[i - 1]; k--) {
                    if (dp[j][k] < dp[j - v[i - 1]][k - m[i - 1]] + w[i - 1]) {
                        dp[j][k] = dp[j - v[i - 1]][k - m[i - 1]] + w[i - 1];
                        g[j][k] = new Node(i - 1, g[j - v[i - 1]][k - m[i - 1]]);
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        Node treePosition = g[V][M];
        while (treePosition != null) {
            result.add(treePosition.i);
            treePosition = treePosition.pa;
        }
        for (Integer index : result) {
            System.out.println("选择物品 " + index + ",它的价值" + w[index] + ".");
        }
        return dp[V][M];
    }

    static class Node {
        int i;
        Node pa;

        public Node(int number, Node parentNode) {
            this.i = number;
            this.pa = parentNode;
        }
    }
}
