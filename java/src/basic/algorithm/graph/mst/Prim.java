package basic.algorithm.graph.mst;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/3 16:24
 * 和Dijkstra很像
 * @see leetcode.problems.LeetCode1584_prim
 */
public class Prim {

    // todo 考虑不存在的情况
    static int v;
    static int[] parent;

    public static void main(String[] args) {
        /*v = 4;
        int[][] graph = {
                {0, 1, 2, 3},
                {1, 0, 2, 0},
                {2, 2, 0, 4},
                {3, 0, 4, 0}
        };*/
        v = 5;
        int[][] graph = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };
        Prim prim = new Prim();
        System.out.println(prim.primMST(graph));
        prim.printMST(parent, graph);
    }

    public int primMST(int[][] graph) {
        v = graph.length; // 图的顶点数
        parent = new int[v]; // 用于存储最小生成树中每个顶点的父节点
        // 用于存储每个顶点与最小生成树的最小权值
        int[] dist = new int[v];
        boolean[] visited = new boolean[v]; // 记录顶点是否被访问过
        int res = 0;
        Arrays.fill(dist, Integer.MAX_VALUE); // 初始化所有顶点的权值为最大值

        // 将第一个顶点作为起始顶点
        dist[0] = 0;
        parent[0] = -1;

        for (int i = 0; i < v; i++) {
            int minKeyIndex = getMinKeyIndex(dist, visited);
            visited[minKeyIndex] = true;
            res += dist[minKeyIndex];
            for (int j = 0; j < v; j++) {
                if (graph[minKeyIndex][j] != 0 && !visited[j] && graph[minKeyIndex][j] < dist[j]) {
                    parent[j] = minKeyIndex;
                    dist[j] = graph[minKeyIndex][j];
                }
            }
        }
        return res;
    }

    private int getMinKeyIndex(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        // -1?
        int minIndex = -1;
        for (int i = 0; i < v; i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private void printMST(int[] parent, int[][] graph) {
        System.out.println("Edge   Weight");
        for (int i = 1; i < v; i++) {
            System.out.println(parent[i] + " - " + i + "    " + graph[i][parent[i]]);
        }
    }
}
