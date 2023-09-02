package basic.datastructure.graph;

import basic.datastructure.graph.shortestpath.BellmanFord;
import basic.datastructure.graph.shortestpath.Floyd;
import basic.datastructure.graph.shortestpath.SPFA;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/2 23:38
 */
public interface ShortestPath {

    int[] getShortestPath(int n, int[][] edges, int source);

    static void main(String[] args) {
        int n = 5;
        int src = 0;
        System.out.println(Arrays.toString(new SPFA().getShortestPath(n, new int[][]{{0, 1, -1}, {0, 2, 4}, {1, 2, 3}, {1, 3, 2}, {1, 4, 2}, {3, 2, 5}, {3, 1, 1}, {4, 3, -3}}, src)));
        System.out.println(Arrays.toString(new BellmanFord().getShortestPath(n, new int[][]{{0, 1, -1}, {0, 2, 4}, {1, 2, 3}, {1, 3, 2}, {1, 4, 2}, {3, 2, 5}, {3, 1, 1}, {4, 3, -3}}, src)));
        System.out.println(Arrays.toString(new Floyd().getShortestPath(n, new int[][]{{0, 1, -1}, {0, 2, 4}, {1, 2, 3}, {1, 3, 2}, {1, 4, 2}, {3, 2, 5}, {3, 1, 1}, {4, 3, -3}}, src)));
    }
}
