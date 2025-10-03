package knowledge.datastructure.graph.bipartite.impl;

import knowledge.datastructure.graph.bipartite.BipartiteMatch;
import knowledge.datastructure.graph.networkflow.impl.FordFulkerson;
import knowledge.datastructure.graph.networkflow.impl.ISAP;
import leetcode.problems.LeetCode1349;

/**
 * @author wujingxinit@outlook.com
 * @date 9/14/25 14:54
 * @see LeetCode1349
 */
public class MaxFlow implements BipartiteMatch {

    public int MaxMatch(int n, int[][] edges) {
        ISAP flow = new ISAP();
        return flow.maxFlow(n, edges);
    }
}
