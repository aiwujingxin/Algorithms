package basic.algorithm.nphard.tsp;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/26 22:06
 * <a href="https://www.baeldung.com/cs/tsp-dynamic-programming"></a>
 */
public class TSP_dp {

    public static int tsp(int[][] distance) {
        int N = distance.length;
        int[][] dp = new int[1 << N][N];

        // 初始化dp数组为最大值
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }

        // 设置起始状态
        dp[1][0] = 0;

        // 动态规划计算
        for (int mask = 1; mask < (1 << N); mask++) {
            for (int currCity = 0; currCity < N; currCity++) {
                // 如果当前城市不在mask表示的集合中，则跳过
                if ((mask & (1 << currCity)) == 0) {
                    continue;
                }
                // 枚举上一个状态中的城市，找到最短路径
                int prevMask = mask ^ (1 << currCity);
                for (int prevCity = 0; prevCity < N; prevCity++) {
                    if (prevCity != currCity && (prevMask & (1 << prevCity)) != 0) {
                        dp[mask][currCity] = Math.min(dp[mask][currCity],
                                dp[prevMask][prevCity] + distance[prevCity][currCity]);
                    }
                }
            }
        }

        // 返回结果
        int fullMask = (1 << N) - 1;
        int minPath = Integer.MAX_VALUE;
        for (int currCity = 1; currCity < N; currCity++) {
            minPath = Math.min(minPath, dp[fullMask][currCity] + distance[currCity][0]);
        }
        return minPath;
    }

    public static void main(String[] args) {
        int[][] distance = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 60},
                {20, 25, 60, 0}
        };

        int shortestPath = tsp(distance);
        System.out.println("The shortest path length is: " + shortestPath);
    }
}
