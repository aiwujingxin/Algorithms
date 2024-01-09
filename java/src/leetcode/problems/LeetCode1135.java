package leetcode.problems;


import knowledge.graph.mst.Kruskal;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/6 16:37
 */
public class LeetCode1135 {

    public int minimumCost(int n, int[][] connections) {
        Kruskal kruskal = new Kruskal();
        int sum = kruskal.MST(n + 1, connections);
        if (kruskal.getCount() - 1 != 1) {
            return -1;
        }
        return sum;
    }
}
