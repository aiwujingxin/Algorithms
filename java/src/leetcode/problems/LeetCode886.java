package leetcode.problems;


import knowledge.datastructure.graph.bipartite.impl.BipartiteGraph_bfs;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/22 23:34
 * <a href="https://leetcode.com/problems/possible-bipartition/discuss/593828/java-DFSBFS-3-clean-simple-approaches-intuitive-%2B-unusual-better-than-most-voted">...</a>
 */
public class LeetCode886 {

    public boolean possibleBipartition(int n, int[][] dislikes) {
//        return new BipartiteGraph_dfs().isBipartite(n + 1, dislikes);
        return new BipartiteGraph_bfs().isBipartite(n + 1, dislikes);
    }
}

