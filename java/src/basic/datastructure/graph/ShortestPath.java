package basic.datastructure.graph;

import basic.datastructure.graph.shortestpath.BellmanFord;
import basic.datastructure.graph.shortestpath.Floyd;
import basic.datastructure.graph.shortestpath.SPFA;
import basic.datastructure.graph.shortestpath.TopoOrder;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/2 23:38
 */
public interface ShortestPath {

    int[] getShortestPath(int n, int[][] edges, int source);

    static void main(String[] args) {
        System.out.println("case1");
        System.out.println(Arrays.toString(new SPFA().getShortestPath(5, new int[][]{{0, 1, -1}, {0, 2, 4}, {1, 2, 3}, {1, 3, 2}, {1, 4, 2}, {3, 2, 5}, {3, 1, 1}, {4, 3, -3}}, 0)));
        System.out.println(Arrays.toString(new BellmanFord().getShortestPath(5, new int[][]{{0, 1, -1}, {0, 2, 4}, {1, 2, 3}, {1, 3, 2}, {1, 4, 2}, {3, 2, 5}, {3, 1, 1}, {4, 3, -3}}, 0)));
        System.out.println(Arrays.toString(new Floyd().getShortestPath(5, new int[][]{{0, 1, -1}, {0, 2, 4}, {1, 2, 3}, {1, 3, 2}, {1, 4, 2}, {3, 2, 5}, {3, 1, 1}, {4, 3, -3}}, 0)));
        System.out.println("case2");
        System.out.println(Arrays.toString(new SPFA().getShortestPath(6, new int[][]{{0, 1, 2}, {0, 2, 3}, {1, 3, 2}, {2, 3, 1}, {2, 4, 4}, {3, 5, 3}, {4, 5, 2}}, 0)));
        System.out.println(Arrays.toString(new BellmanFord().getShortestPath(6, new int[][]{{0, 1, 2}, {0, 2, 3}, {1, 3, 2}, {2, 3, 1}, {2, 4, 4}, {3, 5, 3}, {4, 5, 2}}, 0)));
        System.out.println(Arrays.toString(new Floyd().getShortestPath(6, new int[][]{{0, 1, 2}, {0, 2, 3}, {1, 3, 2}, {2, 3, 1}, {2, 4, 4}, {3, 5, 3}, {4, 5, 2}}, 0)));
        System.out.println(Arrays.toString(new TopoOrder().getShortestPath(6, new int[][]{{0, 1, 2}, {0, 2, 3}, {1, 3, 2}, {2, 3, 1}, {2, 4, 4}, {3, 5, 3}, {4, 5, 2}}, 0)));
    }
}
