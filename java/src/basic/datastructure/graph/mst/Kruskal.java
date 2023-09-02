package basic.datastructure.graph.mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/3 16:24
 */
public class Kruskal implements MSTree {
    public int MST(int n, int[][] edges) {
        final List<int[]> graph = new ArrayList<>();
        Collections.addAll(graph, edges);
        // 将边按权重从小到大排序
        graph.sort(Comparator.comparingInt(o -> o[2]));
        // 使用并查集存储顶点的连通分量
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        List<int[]> mst = new ArrayList<>();
        for (int[] edge : graph) {
            int sourceParent = find(parent, edge[0]);
            int destinationParent = find(parent, edge[1]);
            // 判断加入边是否形成环路
            if (sourceParent != destinationParent) {
                mst.add(edge);
                parent[sourceParent] = destinationParent;
            }
        }
        int sum = 0;
        for (int[] edge : mst) {
            sum += edge[2];
        }
        return sum;
    }

    private int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent, parent[vertex]);
        }
        return parent[vertex];
    }
}
